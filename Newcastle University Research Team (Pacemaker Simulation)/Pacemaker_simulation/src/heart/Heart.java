package heart;
import java.io.Serializable;
import java.time.Instant;

public class Heart implements Runnable, Serializable {

	// Variable - Simulation
	// Start
	boolean start_Simulation = false;

	// Variables - Heart
	// Status
	private String heart_Status;

	// Heart rate
	private int heart_Rate = 100;
	private int heart_Distance;

	// AP and AV
	// Width
	private int arterial_Pulse_Width;
	private int ventricular_Pulse_Width;
	// Distance
	private int chamber_Distance;
	// Contraction duration
	private int chamber_Contraction_Duration;


	// Is pulsed
	private boolean is_V_Pulsed;
	private boolean is_A_Pulsed;
	private long lastAtriumContraction;
	private long lastVentricleContraction;

	// Getters and Setters
	
	// Last Atrial and Ventricular contractions
	
	public void setLastVentricleContraction(){
		Instant.now().toEpochMilli();
	}
	
	public void setLastAtriumContraction(){
		Instant.now().toEpochMilli();
	}

	public long getLastVentricleContraction(){
		return lastVentricleContraction;
	}

	public long getLastAtriumContraction(){
		return lastAtriumContraction;
	}

	// Atrial and Ventricular pulse width
	public int getArterial_Pulse_Width() {
		return arterial_Pulse_Width;
	}

	public void setArterial_Pulse_Width(int arterial_Pulse_Width) {
		// Width is limited to 450 Ms... To replicate regular heart function
		if (arterial_Pulse_Width > 450) {
			// If value is greater than 450 Ms... Simply set value to 450 Ms
			this.arterial_Pulse_Width = 450;
		} else {
			// Else stick with user input
			this.arterial_Pulse_Width = arterial_Pulse_Width;
		}	
	}

	public int getVentricular_Pulse_Width() {
		return ventricular_Pulse_Width;
	}

	public void setVentricular_Pulse_Width(int ventricular_Pulse_Width) {
		// Width is limited to 450 Ms... To replicate regular heart function
		if (ventricular_Pulse_Width > 450) {
			// If value is greater than 450 Ms... Simply set value to 450 Ms
			this.ventricular_Pulse_Width = 450;
		} else {
			// Else stick with user input
			this.ventricular_Pulse_Width = ventricular_Pulse_Width;
		}
	}

	// Artrial and Ventricular pulse contraction duration
	public int getChamber_Contraction_Duration() {
		return chamber_Contraction_Duration;
	}

	public void setChamber_Contraction_Duration(int chamber_Contraction_Duration) {
		this.chamber_Contraction_Duration = chamber_Contraction_Duration;
	}

	// Heart rate
	public int getHeart_Rate() {
		return heart_Rate;
	}

	// calculating heart rate
	public void calculateHeart_Rate() {
		// Calculate the heart rate... Taking into consideration both Nodes
		float Rate = (((heart_Rate) / 1000) * 60);

		// This heart rate == Rate
		this.heart_Distance = (int) Rate;
	}

	// Is pulsed (Atrium and Ventricle)
	public boolean isIs_V_Pulsed() {
		return is_V_Pulsed;
	}

	public void setIs_V_Pulsed(boolean is_V_Pulsed) {
		this.is_V_Pulsed = is_V_Pulsed;
	}

	public boolean isIs_A_Pulsed() {
		return is_A_Pulsed;
	}

	public void setIs_A_Pulsed(boolean is_A_Pulsed) {
		this.is_A_Pulsed = is_A_Pulsed;
	}

	// Heart status
	public String getHeart_Status() {
		// If heart rate is greater than 0... We can assume that the patient is
		// considered to be 'Alive'
		if (heart_Rate > 0) {
			return heart_Status = "Heart is functioning";
		}
		// Else... We can assume that the patient is considered to be 'Dead'
		else {
			return heart_Status = "Heart is not functioning";
		}
	}

	// function calculate difference in atrium and Ventrical
	public void calculate_Chamber_Difference() {
		int diff = ventricular_Pulse_Width - arterial_Pulse_Width;
		chamber_Distance = diff;
	}

	// Constrcutor function
	public Heart() {
		// All values intially = 0 and null
		arterial_Pulse_Width = 0;
		ventricular_Pulse_Width = 0;
		chamber_Contraction_Duration = 0;
		heart_Rate = getHeart_Rate();
		heart_Status = getHeart_Status();
	}

	// toString function
	public String toString() {
		// Return a full list of heart details
		return ("\n" +
				"Current vitals: " + "\n" +
				"-------------------------" + "\n" +
				"AP Width: " + arterial_Pulse_Width + "\n" +
				"VP Width: " + ventricular_Pulse_Width + "\n" +
				"Chamber contraction duration: " + chamber_Contraction_Duration + "\n" +
				"Heart rate: " + heart_Rate + " (BPM)" + "\n" +
				"Status: " + heart_Status + "\n" +
				"Atrium is pulsed: " + is_A_Pulsed + "\n" +
				"Ventrical is pulsed: " + is_V_Pulsed);
	}
	
	// thread
	// Start simulation
	public void start_sim() throws InterruptedException {
		
		// Start simulation
		start_Simulation = true;
		
		// While simulation is true
		while (this.start_Simulation != false) {
			calculate_Chamber_Difference();
			try {		
				// Contract atrium
				this.is_A_Pulsed = true;
				Thread.sleep(chamber_Contraction_Duration);
				this.is_A_Pulsed = false;
				this.setLastAtriumContraction();

				// simulation sleeps for the distance between both chambers
				Thread.sleep(chamber_Distance);

				// Contract Ventricle	
				this.is_V_Pulsed = true;
				Thread.sleep(chamber_Contraction_Duration);
				this.is_V_Pulsed = false;
				this.setLastVentricleContraction();
				
				Thread.sleep(heart_Distance);
			}

			// catch exceptions
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	// Stop simulation
	public void stop_sim(Heart h) {
		h.start_Simulation = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}