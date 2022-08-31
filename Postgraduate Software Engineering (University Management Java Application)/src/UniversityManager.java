import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** 
 * University Manager - class.
 */

public class UniversityManager {
	
    /**
     * Undergraduate student type.
     */
    private static final String UndergraduateStudent = "UndergraduateStudent";
    /**
     * Postgraduate student type.
     */
    private static final String PostgraduateStudent = "PostgraduateStudent";
    /**
     * Postgraduate research student type.
     */
    private static final String PostgraduateResearchStudent = "PostgraduateResearchStudent";   
     
	
	/**
     * Map (To store students)
     */
    private static final Map<StudentId, Student> students = new HashMap<StudentId, Student>();
	
    /**
     * Method - get register students
     */
    
    // if any problems "student student"
    public static Student registerStudent(AbstractStudent student) {
    	
    	// get student type and ID
        String studentType = student.getType();
        StudentId studentId = student.getStudentId();
        
        // dependant on type add student to list of students 
        if (studentType.equals(UndergraduateStudent)) {
        	System.out.println("You have registered a: " + UndergraduateStudent);
           students.put(studentId, student);
        } else if (studentType.equals(PostgraduateStudent)) {
        	System.out.println("You have registered a: " + PostgraduateStudent);
           students.put(studentId, student);
        } else if (studentType.equals(PostgraduateResearchStudent)) {
        	System.out.println("You have registered a: " + PostgraduateResearchStudent);
           students.put(studentId, student);
        } else {
            throw new IllegalArgumentException(
                        "invalid account type: " + student);
        }
              
        return student;
    }
	
    /**
     * Method - remove students
     */
	public static void removeStudent(StudentId studentNumber) {
        
		System.out.println("Yo have removed student: " + studentNumber);
        students.remove(studentNumber);
        
	}
	
	/**
     * Method - count number of students of specifc type
     */
	public static int noOfStudents(String typeOfStudent) {
		
		Iterator it = students.entrySet().iterator();
		int sum = 0;
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();	        
	        if (pair.getValue().getClass().getName().equals(typeOfStudent)) {	
	        sum += 1;
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove();
	        }
		}
	    
	    System.out.println("Total number of students: ");
	    System.out.println(sum);
	    return sum;
	}
	
	/**
     * Method - ammend student information and characteristcis
     */
	public static void amendStudent(StudentId studentNumber, AbstractStudent newStudent) {
		
		students.replace(studentNumber, newStudent);
	
	}  
	
}


