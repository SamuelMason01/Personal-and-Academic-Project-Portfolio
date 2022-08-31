import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Supervisor - class.
 */

public class Supervisor {
	
	/**
     * Variables
     */
	private String supFirstname;
	private String supSurname;

	/**
     * ArrayList (To store supervisor)
     */ 
	private static ArrayList<Supervisor> supervisorlist = new ArrayList<Supervisor>();
	
	/**
     * Constructor 
     */
	public Supervisor(String supfirstname, String supsurname)
	{
		this.supFirstname = supfirstname;
		this.supSurname = supsurname;	
	}
	
	/**
     * Method - get firstname
     */ 
	public String getFirstname()
	{
		return supFirstname;
	}
	/**
     * Method - get surname
     */ 
	public String getSurname()
	{
		//.replaceAll("\\s+","")
		return supSurname;
	}

	/**
     * Method - create a list of supervisors
     */ 
	public static void createListOfSupervisors()
	{
		Scanner readAllFromFile;
		
		try
		{
			readAllFromFile = new Scanner(new FileReader(textFilePath.SupervisorPath));

			while (readAllFromFile.hasNext())
			{
				String sup = readAllFromFile.nextLine();
				
				String[] seperateFile = sup.split(",");
				
				String splitFirstname = seperateFile[0];
				String splitSurname = seperateFile[1].substring(1, (seperateFile[1].length()));
				
				Supervisor sup1 = new Supervisor(splitFirstname, splitSurname);

				supervisorlist.add(sup1);
				
			}
		}
		catch (FileNotFoundException e)
		{
			
		}
	}
	
	/**
     * Method - get No of stored supervisors
     */  
	public static int getNoOfSupervisors()
	{
		return supervisorlist.size();
	}
	
	/**
     * Method - find a specific supervisor
     */
	public static Supervisor findAsupervisor(String fname, String sname)
	{
		try
		{			
			if(supervisorlist.isEmpty())
			{
				createListOfSupervisors();
			}
			
			fname.toUpperCase();
			sname.toUpperCase();
			
			for (Supervisor mod : supervisorlist) {
		        if (mod.getFirstname().equals(fname) & mod.getSurname().equals(sname)) 
		        {
		            return mod;
		        }
		    }
		}
			
		catch (IllegalArgumentException a)
		{
			
		}
		
		listSupervisor();
		System.out.println("Supervisor not found, pls try again");
		Scanner sc = new Scanner(System.in);
		fname = sc.next();
		sname = sc.next();
		return findAsupervisor(fname, sname);
	}
	
	/**
     * Method - return a list of supervisors
     */  
	public static String listSupervisor()
	{
		String currentSupervisorsList = null;
		
		if(supervisorlist.isEmpty())
		{
			System.out.println("Is empty");
			createListOfSupervisors();
		}
			
		for(int i = 0; i < supervisorlist.size(); i++) {   
		    currentSupervisorsList = supervisorlist.get(i).toString();
		    System.out.println(currentSupervisorsList);
		}  
		return currentSupervisorsList;
	}
	
	/**
     * Method - Overide toString
     */  
	public String toString()
	{
		return getFirstname() + ", " + getSurname() + " "; 
	}
	
	

}
