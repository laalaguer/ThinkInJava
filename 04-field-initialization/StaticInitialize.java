/** Demonstrates that static initialization occurs 
 * when class is called (rather than object is instantiated)
 */

class Car {

	Car(){
		System.out.println("Create a Car.");
	}

	public void drive(){
		System.out.println("Drive this car.");
	}
}

class CarFactory {
	static Car car1 = new Car(); // Static member field.
	CarFactory(){
		System.out.println("Inside CarFactory Constructor.");
	}

}

public class StaticInitialize {
	public static void main(String [] args){
		System.out.println("Inside main()");
		CarFactory.car1.drive(); // No sentence "Inside CarFactory Constructor" appears.
		// Actually we didn't create a CarFactory type object at all.
	}
	/**
	* Inside main()
	* Create a Car.
	* Drive this car.
	*/
}



