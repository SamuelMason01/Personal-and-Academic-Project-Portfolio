import java.util.HashMap;
import java.util.Map;

/** 
 * Student Factory - interface to students.
 */


public abstract class StudentFactory implements Student {
		
    /**
     * Undergraduate student type.
     */
    public static final String UndergraduateStudent = "Undergraduate";
    /**
     * Postgraduate student type.
     */
    public static final String PostgraduateStudent = "Postgraduate";
    /**
     * Postgraduate research student type.
     */
    public static final String PostgraduateResearchStudent = "Research";   
    
    /**
     * Map (To store students)
     */
    private static final Map<StudentId, Student> students = new HashMap<StudentId, Student>();
    
    /**
     * Variables
     */
    private StudentId studentNumber;
    
    private SmartCard smartCard;
    
    /**
     * Constructor
     */  
    StudentFactory(StudentId studentnumber, SmartCard smartcard)
    {
    	 this.studentNumber = studentnumber;
    	 this.smartCard = smartcard;
    }
    
    public static Student getInstance(String student, StudentId studentNumber, SmartCard smartcard) {
    	
            Student stu = students.get(studentNumber);
            
            if (stu != null)
                return stu;
            
            if (student.equals(UndergraduateStudent)) {
                stu = new UndergraduateStudent(studentNumber, smartcard);
            } else if (student.equals(PostgraduateStudent)) {
                stu = new PostgraduateStudent(studentNumber, smartcard);
            } else if (student.equals(PostgraduateResearchStudent)) {
                stu = new PostgraduateResearchStudent(studentNumber, smartcard);
            } else {
                throw new IllegalArgumentException(
                            "invalid account type: " + student);
            }
            
            students.put(studentNumber, stu);
            
            return stu;
        }

    public StudentId getStudentNumber()
    {
    	return studentNumber;
    }
    
    public String getType()
    {
    	return this.getClass().getName();
    }
     
    public String toString()
    {
    	  return "Student type: " + this.getClass().getName() + " Student number: " +  studentNumber + " Student name: " + smartCard.getName();
    }
    

}
