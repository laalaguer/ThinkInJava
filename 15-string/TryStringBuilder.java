/** Most important methods of StringBuilder is:
  * .append()
  * .toString()
  * .delete(int start, int end); // end is excluded.
  * .reverse().toString(); // reverse the whole string and output it.
*/
public class TryStringBuilder{
	public static void main (String [] args){
		// Ok, StringBuilder will modify the original string.
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append("def");
		System.out.println(sb.toString()); // abcdef
		// let us reverse this string.
		System.out.println(sb.reverse().toString()); // fedcba
		System.out.println(sb.toString()); // fedcba


		// Ok, StringBuilder can also used to construct Strings.
		String a1 = arrayToString(new Integer[] {1, 2, 3, 4, 5});
		System.out.println(a1); // [1, 2, 3, 4, 5]
		a1 = arrayToString(new String[] {"a", "b", "c", "d", "e"});
		System.out.println(a1); // [a, b, c, d, e]
	}

	public static String arrayToString(Object[] args){
		// Print objects in the array args[] into a string.
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Object o : args){
			sb.append(o.toString()); // This is universally appliable.
			sb.append(",");
			sb.append(" ");
		}
		// remove the last " " and "," from the tail.
		int length = sb.length();
		sb.delete(length-2, length); // (int start, int end), start include, end exclude.
		// add brackets
		sb.append("]");
		return sb.toString();
	}
}