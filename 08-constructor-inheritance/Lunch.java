class Fruit{
	Fruit(){
		System.out.println("Fruit");
	}
}

class Apple extends Fruit{
	Apple(){
		System.out.println("Apple");
	}
}

public class Lunch{

	public static void main(String [] args){
		Apple a = new Apple();
	}
	// output:
	/*Fruit
	 *Apple
	*/
	// JVM will call father class Fruit first, then Apple
}
