public class ThisInConstructor {

	/* Sometimes you need to refer to a constructor 
		when you want to call some other constructor.
	*/
	public static void main(String [] args){
		Dog dog = new Dog(3);	
	}
	
}

class Dog {

	Dog() {
		System.out.println("Empty Constructor");
	}

	Dog(int number) {
		this(); // Call the constructor Dog().
		System.out.println("Call a number:" + String.valueOf(number));
	}

}