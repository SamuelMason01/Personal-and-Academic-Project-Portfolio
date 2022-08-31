import java.util.ArrayList;

/** 
 * Postgraduate research student - class.
 */

public final class PostgraduateResearchStudent extends AbstractStudent{
	
	/**
     * ArrayList (To store supervisors)
     */    
    private ArrayList<Supervisor> Supervisors = new ArrayList<Supervisor>();
	
	/**
	* Constructor 
	*/	
	public PostgraduateResearchStudent(StudentId studentNumber, SmartCard smartcard, ArrayList<Module> modules, ArrayList<Supervisor> supervisors) 
	{
		// To super class
        super(studentNumber, smartcard, modules);
        this.Supervisors = supervisors;
    }
	
	 /**
     * Method - return supervisor
     */  
    public Supervisor returnSupervisor()
    {
    	System.out.println("Supervisors currently attached: ");
    	for(int i = 0; i < Supervisors.size(); i++)
    	{
    		Supervisor sup = Supervisors.get(i);
    		System.out.println(sup.toString());
    		
    		return sup;
    	}
    	
		return null;
    }
    
    /**
     * Method - register supervisor
     * @throws Exception 
     */  
    public Supervisor registerSupervisor(String fname, String sname) throws Exception
    {
    	if (Supervisors.size() != 1)
    	{
    	Supervisor sup = Supervisor.findAsupervisor(fname, sname);
    	Supervisors.add(sup);
    	System.out.println("You have registered the following supervisor: " + sup.toString());
    	
    	return sup;
    	
    	}
    	else
    	{
    		throw new Exception("You have already registered with one supervisor!");
    	}
    }
    
    /**
     * Method - Overide toString
     */
	public String toString()
	{
		return super.toString() + Supervisors.toString();
	}

	
}
