/** Let's build a car again.
 *  We want the car to have a door, a wheel.
 *	Normally when we hands out the "Car" class, we want to tell client programmer:
 *  "Hey, you can get a Door and a Wheel." but not "CarDoor" or "CarWheel"
*/

// Door, is an abstract class.
// It can be any type of door.(Car door, house door)
abstract class Door{
	public abstract void open();
	public abstract void close();
}
// Wheel, is also abstract, can be car wheel, truck wheel.
abstract class Wheel{
	public abstract void roll();
}

public class Car { // cannot inherit Door and Wheel at same time.
	// Inner class to inherit from Door.
	class CarDoor extends Door{
		@Override
		public void open(){ System.out.println("Open car door");}
		@Override
		public void close(){ System.out.println("Close car door");}
	}
	// Inner class to inherit from Wheel
	class CarWheel extends Wheel{
		@Override
		public void roll(){ System.out.println("Roll the wheel");}
	}
	// But Outsider class can use those inner class objects.
	public Door getDoor(){ //--> remember, only return interface Door
		return new CarDoor();
	}
	public Wheel getWheel(){//--> remember, only return interface Wheel
		return new CarWheel();
	}

	public static void main (String []args){
		/* now client programmer only knows that "Car" class has 
		   "Door getDoor()"" function and "Wheel getWheel()" function
		   But client programmer don't know implementation details.
		   Totally decoupled, give me flexibility to modify "CarWheel" and "CarDoor".
		 */
		Car c = new Car();
		Door door = c.getDoor();
		Wheel wheel = c.getWheel();
		door.open();
		door.close();
		wheel.roll();
	}
}

/* result is:
Open car door
Close car door
Roll the wheel
*/