
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Module - class.
 */

public class Module {
	
	/**
     * Variables
     */
	private String modName;
	private String modCode;
	private int credits;

	/**
     * ArrayList (To store modules)
     */  	
	private static ArrayList<Module> modulelist = new ArrayList<Module>();
	
	/**
     * Constructor 
     */  
	public Module(String modCode, String modName, int credits)
	{
		this.modCode = modCode;
		this.modName = modName;
		this.credits = credits;	
	}
	
	/**
     * Method - get module credits
     */  
	public int getCredits()
	{
		return credits;
	}
	/**
     * Method - get module name
     */  
	public String getModName()
	{
		return modName;
	}
	/**
     * Method - get module code
     */  
	public String getModCode()
	{
		return modCode;
	}
	
	/**
     * Method - create a list of modules
     */  
	public static void createListOfModules()
	{
		Scanner readAllFromFile;
		
		try
		{
			readAllFromFile = new Scanner(new FileReader(textFilePath.ModulePath));

			while (readAllFromFile.hasNext())
			{
				String mod = readAllFromFile.nextLine();
				
				String[] seperateFile = mod.split(",");
				
				String splitModCode = seperateFile[0];
				String splitModName = seperateFile[1];
				int splitCredits = Integer.parseInt(seperateFile[2].substring(1, (seperateFile[2].length())));
				
				Module mod1 = new Module(splitModCode, splitModName, splitCredits);

				modulelist.add(mod1);
				
			}
		}
		catch (FileNotFoundException e)
		{
			
		}
	}
	
	/**
     * Method - get No of stored modules
     */  
	public static int getNoOfModules()
	{
		return modulelist.size();
	}
	
	/**
     * Method - find a specific module
     */  
	public static Module findAModule(String code)
	{
		try
		{			
			if(modulelist.isEmpty())
			{
				createListOfModules();
			}
			
			code.toUpperCase();
			
			for (Module mod : modulelist) {
		        if (mod.getModCode().equals(code)) {
		            return mod;
		        }
		    }
		}
			
		catch (IllegalArgumentException a)
		{
			
		}
		
		listModule();
		System.out.println("Module not found, pls try again");
		Scanner sc = new Scanner(System.in);
		code = sc.next();
		return findAModule(code);
		
	}
	
	/**
     * Method - return a list of modules
     */  
	public static String listModule()
	{
		String currentModuleList = null;
		
		if(modulelist.isEmpty())
		{
			System.out.println("Is empty");
			createListOfModules();
		}	
		for(int i = 0; i < modulelist.size(); i++) {   
			currentModuleList = modulelist.get(i).toString();
		    System.out.println(currentModuleList);
		}  
		return currentModuleList;
	}
	
	/**
     * Method - Overide toString
     */  
	public String toString()
	{
		return getModCode() + ", " + getModName() + ", " + getCredits() + " "; 
	}
	
	}

