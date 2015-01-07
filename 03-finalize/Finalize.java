public class Finalize {
	
	public static void main(String [] args){
		Dog dog1 = new Dog(1);
		new Dog(2);
		System.gc(); //Force JVM garbage collection.
	}
}

class Dog{
	int number ;
	Dog(int number){
		this.number = number;
	}

	protected void finalize(){ // called before object is destroyed.
		System.out.println("do finalize of Dog class object: " + String.valueOf(number));
	}
}