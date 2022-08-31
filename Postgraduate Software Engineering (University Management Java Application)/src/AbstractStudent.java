import java.util.ArrayList;

/** 
 * Abstract student - class.
 */

public abstract class AbstractStudent implements Student {
		
    /**
     * ArrayList (To store modules)
     */    
    private ArrayList<Module> modules = new ArrayList<Module>();
    
    /**
     * Variables
     */
    private StudentId studentId;    
    private SmartCard smartCard;
    
    /**
     * Constructor 
     */  
    public AbstractStudent(StudentId studentid, SmartCard smartcard, ArrayList<Module> modules)
    {
    	 this.studentId = new StudentId();
    	 this.smartCard = new SmartCard(smartcard.getfName(), smartcard.getsName(), smartcard.getDOB());
    	 this.modules = modules;
    }

    /**
     * Method - return student number
     */  
    public StudentId getStudentId()
    {
    	return studentId;
    }
    
    /**
     * Method - return smart card
     */  
    public SmartCard getSmartCard()
    {
    	return smartCard;
    }
    
    /**
     * Method - set smart card
     */ 
    public void setSmartCard(SmartCard smartcard)
    {
    	this.smartCard = smartcard;
    }
    
    /**
     * Method - return no of modules a student has
     */ 
    public int getNoOfStudentsModules()
    {
    	return modules.size();
    }
    
    /**
     * Method - return module
     */  
    public String returnModule()
    {
    	
    	String currentModuleList = null;
    	
    	System.out.println("Modules currently registered for: ");
    	for(int i = 0; i < modules.size(); i++)
    	{
    		currentModuleList = modules.get(i).toString();
		    System.out.println(currentModuleList);
    	}
    	
    	return currentModuleList; 	
    }
    
    /**
     * Method - register module
     * @throws Exception 
     */  
    public Module registerModule(String code) throws Exception
    {
    	if (!(this.getClass().getName().equals("PostgraduateResearchStudent")))
    	{
    	Module mod = Module.findAModule(code);
    	modules.add(mod);
    	System.out.println("You have registered for the following module: " + mod.toString());
    	
    	return mod;
    	}
    	else
    	{
    		throw new Exception("Postgraduate Research students can't register for modules");
    	}
    }
    
    /**
     * Method - remove module
     * @throws Exception 
     */  
    public Module removeModule(String code) throws Exception
    {
    	if (!(this.getClass().getName().equals("PostgraduateResearchStudent")))
    	{
    	Module mod = Module.findAModule(code);
    	modules.remove(mod);
    	System.out.println("You have removed the following module: " + mod.toString());
    	
    	return mod;
    	}
    	else
    	{
    		throw new Exception("Postgraduate Research students can't remove modules");
    	}
    }
    
    /**
     * Method - check module
     */  
    public boolean checkModule()
    {
    	int total = 0;
    	
    	for(int i = 0; i < modules.size(); i++)
    	{
    	 total += modules.get(i).getCredits();
    	}
    	
    	System.out.println(total);
    	
    	if(this.getClass().getName().equals("UndergraduateStudent") && total == 120)
    	{
    		return true;
    	}
    	if(this.getClass().getName().equals("PostgraduateStudent") && total == 180)
    	{
    		return true;
    	}
    	if(this.getClass().getName().equals("PostgraduateResearchStudent") && total == 0)
    	{
    		return true;
    	}
    	
    	return false;    			
    }
    
    /**
     * Method - get student type
     */  
    public String getType()
    {
    	return this.getClass().getName();
    }
    
    /**
     * Method - Overide toString
     */    
    public String toString()
    {
    	  return "Student type: " + this.getClass().getName() + " Student number: " +  studentId + " Student name: " + smartCard.getfName() + " " + smartCard.getsName() + " Smartcard ID: " + smartCard.getSmartCardId();
    }
    

}
