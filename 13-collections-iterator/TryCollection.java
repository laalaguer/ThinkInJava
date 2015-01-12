/* This is a try of Collection in Java.
   What is collection? A group of objects.
*/
import java.util.Collection;
import java.util.ArrayList; // an implementation of Collection.
import java.util.Arrays;
import java.util.Collections;

class Apple{
	private static int number = 0;
	public String toString(){
		return "An Apple" + (++ number);
	}
}

public class TryCollection{
	/* We are going to try useful interface of Collections here.*/
	private static Collection<Apple> c = new ArrayList<Apple>(); // static because we want it to run in main().
	public static void main (String [] args){
		Apple a1 = new Apple();
		c.add(a1);
		System.out.println("c is empty? " + c.isEmpty());
		// clear the list
		c.clear();
		System.out.println("c is empty now? " + c.isEmpty());
		// see if contains apple.
		Apple a2 = new Apple();
		c.add(a2);
		System.out.println("c contains a1? " + c.contains(a1));
		System.out.println("c contains a2? " + c.contains(a2));
		// try the size
		System.out.println("c size is? " + c.size());
		// try to add another collection
		Collection<Apple> anotherList = new ArrayList<Apple>();
		anotherList.add(new Apple());
		anotherList.add(new Apple());
		c.addAll(anotherList);
		Collections.addAll(c, new Apple(), new Apple()); // this runs faster then the object method.
		System.out.println("now c size is? " + c.size());
		c.removeAll(anotherList);
		System.out.println("now c size back to? " + c.size());
		// toArray
		c.add(new Apple());
		c.add(new Apple());
		Apple[] aList = c.toArray(new Apple[0]); // dump it back to an array, without spare space allocated.
		// if you put 1 instead of 0 in above sentence, it will allocate one more [null] in the aList.
		System.out.println(Arrays.toString(aList));
	}
}
/*
c is empty? false
c is empty now? true
c contains a1? false
c contains a2? true
c size is? 1
now c size is? 5
now c size back to? 3
[An Apple1, An Apple2, An Apple3, An Apple4, An Apple5]
*/