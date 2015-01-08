import java.util.Arrays;

class Demo{
	Demo(String a){
		System.out.println("Argument is: " + a);
	}
}

public class ArrayInitialize{
	public static void main(String [] args){
		Demo [] d;
		System.out.println("--- seperator ---");
		d = new Demo[]{
			new Demo("1"),
			new Demo("2"),
		};
		
		System.out.println(Arrays.toString(d));
	}
	/*
		--- seperator ---
		Argument is: 1
		Argument is: 2
		[Demo@1eb2c1b, Demo@9cbd4b]
	*/
	// Demo[] d; --> doesnt create any Demo type object. d is refer to null.
	// d = new Demo[] can create Demo objects.
	// Arrays.toString() will print out the array object into meaningful string.
}