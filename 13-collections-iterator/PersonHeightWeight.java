/* This way we hold a person's height, weight data in a map.*/

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PersonHeightWeight{
	public static void main(String [] args){
		Map<String, Integer[]> holder = new HashMap<String, Integer[]>();
		// ok, a person has a name, and has a collection of data associate with him.
		holder.put("John", new Integer[] {170, 50});
		holder.put("Marry", new Integer[] {160 , 45});
		System.out.println("Keys in Map: "+ holder.keySet()); // it is a Set.
		System.out.println("Values in Map: "+ holder.values()); // it is a Collection.
		// Lets apply some general collection skills to do a review.
		Iterator<Integer[]> it = holder.values().iterator();
		while(it.hasNext()){
			Integer [] array = it.next();
			System.out.print("[");
			for (Integer i : array){
				System.out.print(i.intValue());
				System.out.print(",");
			}
			System.out.println("]");	
		}
	}	
}