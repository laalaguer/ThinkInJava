// Say you have a fruit interface.
interface Fruit {
	String getName();
	Fruit peel();
}

// Ok, then you have a class works properly with Fruit
public class AdapterPattern{
	public static void apply (Fruit f){
		System.out.println(f.getName());
		Fruit f1 = f.peel();
	}
	public static void main (String [] args){
		apply(new Apple()); // Apple complies with Fruit interface, so we can call it here.
		// See line 36 to understand how we adapt a `String` to a `Fruit`.
		apply(new StringObjectToFruitAdapter("good morning")); 
	}

}

// if you create a class, which complies with fruit interface,
// Then you know it will work with AdapterPattern.apply(Fruit)
class Apple implements Fruit{
	public String getName(){
		return "I am Apple";
	}
	public Apple peel(){ // --> hey, here we return not Fruit, but Apple, a subclass
		System.out.println("Peel an apple.");
		return this;
	}
}

// If you happend to discover a class, which doesn't have this Fruit interface.
// Let's say you have an String class object. it doesn't have peel() or getName().
// Let's build an adapter to make it work.
class StringObjectToFruitAdapter implements Fruit{
	String s;
	public StringObjectToFruitAdapter(String s){ // --> we take a string object.
		this.s = s;
	}

	public String getName(){
		return "I was: " + s + " But I am now fruit adapter.";
	}

	public StringObjectToFruitAdapter peel(){
		System.out.println("I peel a string, strange, but doable.");
		return this;
	}
}

/** result from running this file would be
* I am Apple
* Peel an apple.
* I was: good morning But I am now fruit adapter.
* I peel a string, strange, but doable.
*/