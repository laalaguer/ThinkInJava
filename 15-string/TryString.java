/* Let's see some good methods in String class which can speed up your programming.
 * .split("regex") // split the string according to some pattern.
 * .replace(char a, char b) //replace the char.
 * .concat("Another String") // add the string to the end of this string.
 * .substring(int begin ,int end) // subset of the string.
*/
import java.nio.charset.Charset;

public class TryString{
	public static void main(String [] args){
		String a = "This is a test.";
		System.out.println(a);
		

		String [] b= a.split("(\\s)|(\\.)"); // split when meet white space, or .
		for (String object: b){
			System.out.print(object);
			System.out.println();
		}
		

		String c = a.replace(".", "").concat(", is it?"); // add some new chars to it.
		System.out.println(c);


		// How to make the first word capitalized?
		String[] pieces = a.split("\\s", 2); // split into 2 parts. at the first white space.
		String part1 = pieces[0].toUpperCase().concat(" ");
		String finalString = part1.concat(pieces[1]);
		System.out.println(finalString);
		// Another way to do it.
		int position = a.indexOf(" ");
		String firstPart = a.substring(0, position);// get the first word out.
		String secondPart = a.substring(position, a.length()); // get the remaining part.
		String uppered = firstPart.toUpperCase();
		finalString = uppered.concat(secondPart);
		System.out.println(finalString);

		// encode the string into byte[]
		try{
			byte [] utf8 = a.getBytes("UTF-8");
			for (byte each: utf8){
				System.out.printf("%d ", each);
			}
			System.out.println();
		}catch (Exception e){
			// do nothing
		}
		
		try{
			byte [] utf8 = a.getBytes("GB18030");
			for (byte each: utf8){
				System.out.printf("%d ", each);
			}
		}catch (Exception e){
			// do nothing
		}
	}
}