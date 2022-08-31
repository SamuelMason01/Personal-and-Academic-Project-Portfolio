package mechanism;

public class Mechanism {
    private String name;
    private String description;
    private float load;
    private int memory;

    // Constructor
    public Mechanism(String name, String description, float load, int memory) {
        this.name = name;
        this.description = description;
        this.load = load;
        this.memory = memory;
    }

    // Get the name.
    public String getName() {
        return this.name;
    } 

    // Get the description 
    public String getDescription() {
        return this.description;
    }

    // Get the battery load.
    public float getLoad() {
        return this.load;
    }

    // Get the memory usage.
    public int getMemory() {
        return this.memory;
    }
}