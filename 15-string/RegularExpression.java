public class RegularExpression{
	public static void main (String [] args){
		System.out.println(numberMatch("321"));// true
		System.out.println(numberMatch("+321")); // true
		System.out.println(numberMatch("-321")); // true

		System.out.println(letterMatch("h")); //true
		System.out.println(letterMatch("a")); // false
		System.out.println(replaceDotAtEnd("Replace the dot at the end."));
		System.out.println(replaceAllWords("Replace the words.\t @!#&^%*&%^"));
		System.out.println(replaceGreedy("Repace the numbers 123123123"));
		System.out.println(replaceLazy("Repace the numbers 123123123"));
	}

	public static boolean numberMatch(String number){
		// see if number is +1321 or -1231 style
		return number.matches("(-|\\+)?\\d+");
	}

	public static boolean letterMatch(String arg){
		return arg.matches("[a-z&&[hij]]"); // a letter in h, i or j.
	}

	public static String replaceDotAtEnd(String arg){
		return arg.replaceAll("\\.$", "!");
	}

	public static String replaceAllWords(String arg){
		return arg.replaceAll("\\w", "");
	}

	public static String replaceGreedy(String arg){
		return arg.replaceFirst("\\d+", "-");
	}

	public static String replaceLazy(String arg){
		return arg.replaceFirst("\\d+?", "-");
	}
}