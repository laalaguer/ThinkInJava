public class Main {

	public static void main(String [] args) {
		Rock rock = new Rock();
		// increment() method returns the (Rock) type object.
		rock.increment().increment();
	}
}


class Rock {
	int internal;
	Rock(){
		int internal = 0;
	}

	// this keyword is used to return the object of this class.
	public Rock increment(){
		internal ++;
		return this;
	}

}