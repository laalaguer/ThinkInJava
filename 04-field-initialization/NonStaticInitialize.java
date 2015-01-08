/** Usually we initialize the member fields of non-static members inside 
 *  constructors, but instead we can do it inside a {}, to make sure before
 *  any possible constructor is called, this {} block is executed.
 */

 class Lamp{}

 public class NonStaticInitialize {

 	public Lamp lamp1;
 	public Lamp lamp2;
 	{
 		lamp1 = new Lamp(); // lamp1
 		lamp2 = new Lamp(); // lamp2
 		System.out.println("Inside {} block.");
 	}
 	// Constructor 1
 	NonStaticInitialize(){
 		System.out.println("Inside NonStaticInitialize Constructor");
 	}
 	// Constructor 2
 	NonStaticInitialize(int i){
 		System.out.println("Inside NonStaticInitialize Constructor with parameter:" + String.valueOf(i));	
 	}

 	public static void main(String [] args){
 		new NonStaticInitialize();
 		new NonStaticInitialize(3);
 	}
 	/*
 	 * Inside {} block.
	   Inside NonStaticInitialize Constructor
	   Inside {} block.
       Inside NonStaticInitialize Constructor with parameter:3
       */
     // So, each time a NonStaticInitialize object is instantiated, {} block will be executed.
 } 