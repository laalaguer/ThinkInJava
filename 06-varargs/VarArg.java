public class VarArg{
	private static void print(String... args){
		for (String i : args){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	// main function
	public static void main(String[] args){
		print("a", "b", "c"); // pass String object into function, one by one.
		print(); // Pass no object to the function
		print(new String[]{"d", "e", "f"}); // pass an array of String objects.
	}
	/*
	a b c

	d e f
	*/
}