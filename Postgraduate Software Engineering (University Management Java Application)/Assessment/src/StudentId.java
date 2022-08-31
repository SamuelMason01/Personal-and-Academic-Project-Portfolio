import java.util.HashMap;
import java.util.Map;

public class StudentId {
	
	private String LetterComponent;
	private int NumberComponent;
	
	StudentId(String lettercomponent, int numbercomponent){
		if(lettercomponent.length() <= 1  || lettercomponent.length() >= 3)
		{
			throw new IllegalArgumentException("ID name is not 2 characters!");
		}
		else if(Math.log10(numbercomponent) <= 3 || Math.log10(numbercomponent) >= 5)
		{
			throw new IllegalArgumentException("ID number is not 4 digits!");
		}
		else
		{
		this.LetterComponent  = lettercomponent;	
		this.NumberComponent = numbercomponent;
		}
	}
	
	public String toString() {
		return LetterComponent + NumberComponent;
	}
	
	
	
	
	
	
	
	
}
