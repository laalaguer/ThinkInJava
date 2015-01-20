public class RegularExpression{
	public static void main (String [] args){
		System.out.println(numberMatch("321"));// true
		System.out.println(numberMatch("+321")); // true
		System.out.println(numberMatch("-321")); // true

		System.out.println(letterMatch("h")); //true
		System.out.println(letterMatch("a")); // false
	}

	public static boolean numberMatch(String number){
		// see if number is +1321 or -1231 style
		return number.matches("(-|\\+)?\\d+");
	}

	public static boolean letterMatch(String arg){
		return arg.matches("[a-z&&[hij]]"); // a letter in h, i or j.
	}
}