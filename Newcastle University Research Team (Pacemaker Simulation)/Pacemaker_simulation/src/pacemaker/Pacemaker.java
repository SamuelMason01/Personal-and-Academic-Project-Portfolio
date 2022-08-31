package pacemaker;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import heart.Heart;
import mechanism.Mechanism;

public class Pacemaker implements Serializable  {
	private Heart heart;
	private boolean isPacing;
    
    // Battery and memory information.
    private int batteryCapacity;
    private float batteryLoad;
    private float batteryVoltage;
    private float memoryCapacity;
    private float memoryUsage;

    // Memory usage.
    private ArrayList<Mechanism> mechanisms;

    // Pacemaker settings.
    private int targetBpm;
    private int targetDiff; //The delay between the atrium and ventricle pulsing
    private int pulseDuration; // The time that each pulse lasts

    // Pacing settings.
    private int paced; // 0 = none, 1 = A, 2 = V, 3 = DUAL
    private int sensed; // 0 = none, 1 = A, 2 = V, 3 = DUAL
    private int response; // 0 = none, 1 = Trigger, 2 = Inhibit, 3 = Dual

    // Constructor
    public Pacemaker(Heart heart) {
        this.heart = heart;
        this.paced = 0;
        this.sensed = 0;
        this.response = 0;
        this.mechanisms = new ArrayList<>();
    }

    // Add a mechanism to the list.
    public boolean addMechanism(String name, String description, float load, int memory) {
        float remainingMemory = this.memoryCapacity - calcMemoryUsage();

        // If there is sufficient memory space, add the mechanism
        if (remainingMemory >= load) {
            Mechanism mechanism = new Mechanism(name, description, load, memory);
            this.mechanisms.add(mechanism);
            return true;
        } 
        // Otherwise don't add the mechanism.
        else {
            return false;
        }
    }

    // Remove a mechanism from the list.
    public void removeMechanism(int index) {
        this.mechanisms.remove(index);
    }

    // Get a list of the mechanisms.
    public ArrayList<Mechanism> getMechanisms(){
        return this.mechanisms;
    }

    // Calculate the battery life of the pacemaker, accounting for all of the mechanisms.
    public float calcBatteryLife() {
        float totalLoad = 0;
        
        for (Mechanism m : this.mechanisms) {
            totalLoad += m.getLoad();
        }

        float loadCurrent = (totalLoad + this.batteryLoad)/this.batteryVoltage;
        float batteryLife = this.batteryCapacity/loadCurrent;

        return batteryLife;
    }

    // Calculate the total memory usage, accounting for all of the mechanisms.
    public float calcMemoryUsage() {
        float totalMemory = 0;
        
        for (Mechanism m : this.mechanisms) {
            totalMemory += m.getLoad();
        }

        return totalMemory + this.memoryUsage;
    }

    // Calculate the time period between each heart beat in milliseconds.
    private int calcBeatDelay() {	
		float delay = ((this.targetBpm/1000)*60);
        return (int) delay;
	}

    // Pace the various chambers.
    private void pace(int toPace) throws InterruptedException {
        if (toPace > 0) {
            // If pacing the atrium
            if (toPace == 1) {
                this.heart.setIs_A_Pulsed(true);
                Thread.sleep(pulseDuration);
                this.heart.setIs_A_Pulsed(false);
            } 

            // If pacing the ventricle
            else if (toPace == 2) {
                this.heart.setIs_V_Pulsed(true);
                Thread.sleep(pulseDuration);
                this.heart.setIs_V_Pulsed(false);
            } 

            // If pacing both chambers.
            else {
                this.heart.setIs_A_Pulsed(true);
                Thread.sleep(pulseDuration);
                this.heart.setIs_A_Pulsed(false);
                
                Thread.sleep(targetDiff-pulseDuration);
                
                this.heart.setIs_V_Pulsed(true);
                Thread.sleep(pulseDuration);
                this.heart.setIs_V_Pulsed(false);
            }
        }
    }

    // Run the pacemaker.
    public void runPacemaker() throws InterruptedException{
        this.isPacing = true;
        
        while (this.isPacing) {
            boolean hasPaced = false;
            int beatDelay = this.calcBeatDelay();

            if (this.sensed > 0) {
                // Pacing modes that sense the atrium
                if (this.sensed == 1){
                    // AAT/VAT/DAT pacing modes.
                    if (this.response == 1 & (this.paced == 2 | this.paced == 3) & this.heart.isIs_A_Pulsed()) {
                        Thread.sleep(this.targetDiff);
                        this.pace(2);
                        hasPaced = true;
                    }

                    // AAI/VAI/DAI pacing modes.
                    else if (this.response == 2 & ((Instant.now().toEpochMilli() - heart.getLastAtriumContraction()) >= beatDelay) & !this.heart.isIs_A_Pulsed()) {
                        this.pace(this.paced);
                        hasPaced = true;
                    }

                    // AAD/VAD/DAD pacing modes.
                    else if (this.response == 3) {
                        if (this.heart.isIs_A_Pulsed() & (this.paced == 2 | this.paced == 3)) {
                            Thread.sleep(this.targetDiff);
                            this.pace(2);
                            hasPaced = true;
                        }
                        else if ((Instant.now().toEpochMilli() - heart.getLastAtriumContraction()) >= beatDelay & !this.heart.isIs_A_Pulsed()){
                            this.pace(this.paced);
                            hasPaced = true;
                        }
                    }

                    // AAO/VAO/DAO pacing modes.
                    else {
                        this.pace(this.paced);
                        hasPaced = true;
                    }
                }


                // Pacing modes that sense the ventricle.
                if (this.sensed == 2){
                    // AVT/VVT/DVT pacing modes.
                    if (this.response == 1 & (this.paced == 1 | this.paced == 3) & this.heart.isIs_V_Pulsed()) {
                        Thread.sleep(beatDelay);
                        this.pace(1);
                        // Has paced is not set, to avoid second beat delay
                    }

                    // AVI/VVI/DVI pacing modes.
                    else if (this.response == 2 & ((Instant.now().toEpochMilli() - heart.getLastVentricleContraction()) >= beatDelay) & !this.heart.isIs_V_Pulsed()) {
                        this.pace(this.paced);
                        hasPaced = true;
                    }

                    // AVD/VVD/DVD pacing modes.
                    else if (this.response == 3) {
                        if (this.heart.isIs_V_Pulsed() & (this.paced == 1 | this.paced == 3)) {
                            Thread.sleep(beatDelay);
                            this.pace(1);
                            // Has paced is not set to avoid double beat delay
                        }
                        else if ((Instant.now().toEpochMilli() - heart.getLastVentricleContraction()) >= beatDelay & !this.heart.isIs_V_Pulsed()){
                            this.pace(this.paced);
                            hasPaced = true;
                        }
                    }

                    // AVO/VVO/DVO pacing modes.
                    else {
                        this.pace(this.paced);
                        hasPaced = true;
                    }
                }

                // Pacing modes that sense both chambers.
                if (this.sensed == 2){
                    // ADT/VVT/DDT pacing modes.
                    if (this.response == 1) {
                        if  ((this.paced == 2 | this.paced == 3) & this.heart.isIs_A_Pulsed()) {
                            Thread.sleep(this.targetDiff);
                            this.pace(2);
                            hasPaced = true;
                        }

                        if ((this.paced == 1 | this.paced == 3) & this.heart.isIs_V_Pulsed()) {
                            Thread.sleep(beatDelay);
                            this.pace(1);
                            // Has paced is not set, to avoid second beat delay
                        }
                    }

                    // ADI/VDI/DDI pacing modes.
                    else if (this.response == 2) {
                        if ((Instant.now().toEpochMilli() - heart.getLastAtriumContraction()) >= beatDelay & !this.heart.isIs_A_Pulsed()) {
                            this.pace(this.paced);
                            hasPaced = true;
                        }

                        else if (((Instant.now().toEpochMilli() - heart.getLastVentricleContraction()) >= beatDelay) & !this.heart.isIs_V_Pulsed()) {
                            this.pace(this.paced);
                            hasPaced = true;
                        }
                    }

                    // ADD/VDD/DDD pacing modes.
                    else if (this.response == 3) {
                        if (this.heart.isIs_A_Pulsed() & (this.paced == 2 | this.paced == 3)) {
                            Thread.sleep(this.targetDiff);
                            this.pace(2);
                            hasPaced = true;
                        }
                        else if ((Instant.now().toEpochMilli() - heart.getLastAtriumContraction()) >= beatDelay & !this.heart.isIs_A_Pulsed()){
                            this.pace(this.paced);
                            hasPaced = true;
                        }
                        else if (this.heart.isIs_V_Pulsed() & (this.paced == 1 | this.paced == 3)) {
                            Thread.sleep(beatDelay);
                            this.pace(1);
                            // Has paced is not set to avoid double beat delay
                        }
                        else if ((Instant.now().toEpochMilli() - heart.getLastVentricleContraction()) >= beatDelay & !this.heart.isIs_V_Pulsed()){
                            this.pace(this.paced);
                            hasPaced = true;
                        }
                    }

                    // ADO/VDO/DDO pacing modes.
                    else {
                        this.pace(this.paced);
                        hasPaced = true;
                    }
                }
            }

            // Asynchronous Pacing
            else {
                this.pace(this.paced);
                hasPaced = true;
            }

            // If the pacemaker has paced the heart, wait until the next beat is supposed to happen.
            if (hasPaced) {
                Thread.sleep(beatDelay);
            }
        }
    }
}