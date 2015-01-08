/*  Lets build a car.
*	During this lets talk about the most common three Java concepts:
* 	Inheritance, Composition and Delegation.
*/

// Engine, a genric class
class Engine{}
// Car engine, a concret class
class CarEngine extends Engine{} //---> Inheritance
// Wheel
class CarWheel{}
// Controller
class Controller{
	public void forward(){
		System.out.println("Go forward.");
	}
	public void backward(){
		System.out.println("Go backward.");
	}
}


public class Car{
	// Let us make a car with 4 wheels, 1 engine and 1 controller.
	// --> Composition
	CarWheel[] cw = new CarWheel[4];
	{
		for (int i=0;i<cw.length;i++){
			cw[i] = new CarWheel();
		}

	}
	CarEngine ce = new CarEngine();
	Controller controller = new Controller();
	// But we still can tell car directly go forward and backward.
	// --> Delegation
	public void forward(){
		controller.forward();
	}
	public void backward(){
		controller.backward();
	}

	//Let us test it
	public static void main (String [] args){
		Car car = new Car();
		car.forward();
		car.backward();
	}
	/* 	Go forward.
		Go backward.
	*/
}