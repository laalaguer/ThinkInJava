/*  Discover Regular expression with more tools, other than String utilities. 
	This will use Pattern and Mather. 
	I think generally, Pattern is used to generate a Matcher which will do further operation.
*/
import java.util.regex.Pattern; // A pattern that you want to compile.
import java.util.regex.Matcher; // Things do the operation on String.
import java.util.Scanner;

public class Regex{
	public static void main (String [] args){
		if (args.length == 0){
			printHelp();
			return;
		} else {
			// note that we usually say comile("\\d") for a number,
			// but here we can just input \d when do the input, because \ is already escaped on command line
			Pattern p = Pattern.compile(args[0]); 
			displayPattern(p.toString());

			Scanner s = new Scanner(System.in);
			while(true){
				String result = prompt("Try to type in a string to match, Ctrl-c to quit", s);
				Matcher m = p.matcher(result); // lets get a matcher.
				while(m.find()){
					displayMatching(m);
				}
			}
		}
	}

	public static void displayMatching(Matcher m){
		System.out.printf(
			"Maches pattern %s at position %d~%d, which is %s %n", 
			m.pattern().toString(), 
			m.start(), 
			m.end()-1, 
			m.group());
	}

	public static void displayPattern(String pattern){
		System.out.printf("Pattern is: %s%n", pattern);
	}

	public static String prompt(String display, Scanner s){
		System.out.println(display);
		return s.nextLine();
	}

	public static void printHelp(){
		System.out.println("Type in a regex pattern, as parameter");
	} 

}

/* *** Note we only input \d+, not \\d+ as we usually do in Java coding.
$ javac Regex.java && java Regex \d+

Pattern is: \d+
Try to type in a string to match, Ctrl-c to quit
123abc132
Maches pattern \d+ at position 0~2, which is 123
Maches pattern \d+ at position 6~8, which is 132
Try to type in a string to match, Ctrl-c to quit
*/