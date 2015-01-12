/* Rather than only having next(), hasNext() and remove(), ListIterator has more functionality.
   Collection --> Iterator, 
   			which can next(), hasNext() and remove();
   List extends Collection --> ListIterator, 
   			which can do more like add(), hasPrevious(), previous(),
   			previousIndex(), nextIndex(), add(Object) and set(Object)
*/

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class TryListIterator{
	public static void main (String [] args){
		List<Apple> apples = new ArrayList<Apple>();
		for (int i = 0;i < 5;i++)
			apples.add(new Apple());
		// print the apples.
		System.out.println(apples); // [0 , 1, 2, 3, 4]

		ListIterator<Apple> li = apples.listIterator();
		Apple a0 = li.next(); // get on the [0] apple.
		System.out.println(a0);
		li.next(); // onto [1] apple.
		li.next(); // onto [2] apple.
		Apple a3 = li.next(); // get on the [3] apple. li pointer goes between [3] and [4]
		System.out.println(a3);
		System.out.println(li.previousIndex()); // [3]
		System.out.println(li.nextIndex()); // [4]
		Apple a4 = li.next(); // get on the [4] apple, li pointer goes beyongd [4], think it as 4.5
		System.out.println(li.previousIndex()); // [4]
		System.out.println(li.nextIndex()); // [5]
		// li.next(); // This will go wrong ,as there is no element on [5]
		li.add(new Apple()); // pointer at 4.5, add new apple at [5], pointer moves pointer to 5.5
		// print the apples
		System.out.println(apples); // [0 , 1, 2, 3, 4, 5]
		System.out.println(li.previousIndex()); // [5]
		System.out.println(li.nextIndex()); // [6]
		// li.set(new Apple()); // This will go wrong, as li is at position 5.5, there is no 6
		li.previous(); // go back to 4.5
		li.set(new Apple()); // pointer at 4.5, which is between [4] and [5]
		// set apple at [5]. pointer not moving. Still at 4.5
		// print the apples
		System.out.println(apples); // [0 , 1, 2, 3, 4, 6]
		System.out.println(li.previousIndex()); // [4]
		System.out.println(li.nextIndex()); // [5]
	}
}