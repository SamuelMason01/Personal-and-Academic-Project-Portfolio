

public class Main {
	
	  public static void main(String[] args) {
		  
		  final SmartCard sm1 = new SmartCard("Sam", "Mason");
		  final StudentId id1 = new StudentId("ds", 4112);
		  final Student Stu1 = StudentFactory.getInstance(StudentFactory.PostgraduateStudent, id1, sm1);	 
		  
		  System.out.println(Stu1.toString());
		  
		  System.out.println(sm1.toString());
		  
		  System.out.println(Stu1.getType());
		  
		  
		  
		  System.out.println(id1);
			  
		  }
	  
	  private static void printAccountInfo(String accType, Student student) {
		        System.out.println(accType + " " + student);
		    }
		  
	       
	    }


