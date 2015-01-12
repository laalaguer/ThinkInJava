/* 	java has a featuered iterator, which gets a light-weight object out of a list.
	However iterator only walks in one direction in java and provides limited functionality.
	hasNext(), next() and remove(). 
	It is powerful when you want to go through a list.
	for (Item i : list){
		list.remove(i); // This will cause concurrency error, as we are doing a for loop in list.
		// list cannot inserting/deleting items during this phase.
		// see the example in 12-control-framework/ folder of this tutorial.
	}
	But you can solve above problem while using an iterator.
*/

/* We want to unified go through Set and List, but you know,
   List provides get(int i) option which will return the object at position.
   But Set has no such functionality. We can't go through it one by one.
   So how do we do it?
   We tell Set and List both to give us an iterator, and we use 
   hasNext(), next() and remove() to do the job!
 */
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class TryIterator{

	public static void main(String [] args){
		List<Apple> apples = new ArrayList<Apple>();
		for (int i = 0;i < 5;i++)
			apples.add(new Apple());
		Set<Apple> apples2 = new HashSet<Apple>(apples);
		System.out.println("Apples in List: " + apples);
		System.out.println("Apples in Set: " + apples2);
		show(apples.iterator());
		show(apples2.iterator()); // regardless of structure, show will also work.
		remove(apples.iterator());
		System.out.println("Apples in List after remove even-number apples: " + apples);
		System.out.println("Does it affect apples in Set?: " + apples2);
	}

	public static void show(Iterator<Apple> it){
		System.out.println();
		while (it.hasNext()){ 
			Apple a = it.next(); // let a refer to the objects. Remember, next() will first land at [0]
			System.out.println(a);
		}
	}

	public static void remove(Iterator<Apple> it){
		System.out.println();
		while (it.hasNext()){
			Apple a = it.next();
			if (a.myNumber % 2 == 0) // remove some apples. No concurrency problem.
				it.remove();
		}
	}
}