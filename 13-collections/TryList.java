/* 	Let's explore the List interface,
	List is a subclass of Collection, which we explored in TryCollection.java
	Collection has method add(), addAll(), contains(), isEmpty(), remove(), clear() etc.
	What new methods does List adds to the Collection interface?
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Apple{
	static int number = 0 ;
	public int myNumber = 0;
	public Apple() {
		myNumber = number;
		number ++;
	}
	public String toString() { return "Apple " + myNumber;}
}


public class TryList{
	public static void print(Object o){
		System.out.println(o);
	}

	public static void main(String [] args){
		List<Apple> apples = new ArrayList<Apple>();
		for (int i = 0; i < 10; i++){
			apples.add(new Apple()); // Method of Collection.
		}
		print(apples);
		Apple anExample = apples.get(2); // Method of List.
		print("Index of: " + anExample + " is: " + apples.indexOf(anExample)); // Method of List.
		apples.add(3, new Apple()); // Method of List, insert at some point.
		print(apples);
		List<Apple> subApples = apples.subList(1,5); // Method of List. including [1] excluding [5]
		print("sub list: " + subApples);
		Collections.shuffle(subApples, new Random(47)); // Method of Collections.
		print("shuffled sub list: "+ subApples);
		print("original list contains shuffled sub list? " + apples.containsAll(subApples));
		List<Apple> myCopy = new ArrayList<Apple>(apples); // Lets try to make a copy of original apples.
		print("Copied Apples: " + myCopy);
		print("Copied Apples [1] is the same object of apples [1]? " + apples.contains(myCopy.get(1)));
		// Obviously copied apples holds the reference to the original apples.
		myCopy.get(1).myNumber = 999; // let's modify an apple in the copy list.
		print("if i modify copy apple [1] to "+ myCopy.get(1) +", then original apple [1] is: "+apples.get(1));
		// seems modify will create a mutual effect on both apple lists.
		myCopy.clear(); // Method of Collections. Clear all elements in copy list.
		// Does clear() affect original apples? No. It just delete all reference to apples in one list.
		print("Original apples: " + apples); 

	}
	
}
/*
[Apple 0, Apple 1, Apple 2, Apple 3, Apple 4, Apple 5, Apple 6, Apple 7, Apple 8, Apple 9]
Index of: Apple 2 is: 2
[Apple 0, Apple 1, Apple 2, Apple 10, Apple 3, Apple 4, Apple 5, Apple 6, Apple7, Apple 8, Apple 9]
sub list: [Apple 1, Apple 2, Apple 10, Apple 3]
shuffled sub list: [Apple 1, Apple 2, Apple 3, Apple 10]
original list contains shuffled sub list? true
Copied Apples: [Apple 0, Apple 1, Apple 2, Apple 3, Apple 10, Apple 4, Apple 5,Apple 6, Apple 7, Apple 8, Apple 9]
Copied Apples [1] is the same object of apples [1]? true
if i modify copy apple [1] to Apple 999, then original apple [1] is: Apple 999
Original apples: [Apple 0, Apple 999, Apple 2, Apple 3, Apple 10, Apple 4, Apple 5, Apple 6, Apple 7, Apple 8, Apple 9]
*/