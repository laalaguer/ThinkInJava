/* 
matcher.lookingAt()
matcher.matches() (or pattern.matches)
matcher.find() 

they all have different meaning. matches() only success if whole string matches.
lookingAt() will success if first part is ok.
matcher.find() will match each and every part in the string.
*/
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class StringLooking{
	public static String a = "we are 3 people.";

	public static void main (String [] args){
		Matcher m1 = Pattern.compile("\\S+").matcher(a);
		doIt(m1, a);
	}

	public static void doIt(Matcher m, String s){
		System.out.println("String is : " + s);

		System.out.println(m + " matches ? "+ m.matches());
		
		System.out.println(m + " lookingAt ? "+ m.lookingAt()); // now start is pointing before 'are', after 'we'

		m.reset(); // reset matcher inner state to original. so start is pointing at 0 agian.

		List<String> aList = new ArrayList<String>();
		while(m.find()){
			aList.add(m.group());
		}
		System.out.println(m + " find ? "+ aList);

	}
}

/*
String is : we are 3 people.
java.util.regex.Matcher[pattern=\S+ region=0,16 lastmatch=] matches ? false
java.util.regex.Matcher[pattern=\S+ region=0,16 lastmatch=] lookingAt ? true
java.util.regex.Matcher[pattern=\S+ region=0,16 lastmatch=] find ? [we, are, 3, people.]
*/