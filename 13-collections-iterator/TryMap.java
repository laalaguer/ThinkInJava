/* Map is important to solve the problem of related business logic.
   It is the same as the dictionary functionality in Python.
   Let us test the ramdomness of random number generated in Java.
*/

import java.util.Random;
import java.util.Map;
import java.util.TreeMap;

public class TryMap{
	public static void main(String [] args){
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>(); // TreeMap will keep acsending order.
		Random rand = new Random();
		for (int i=0;i<10000;i++){
			int number = rand.nextInt(20);
			if (m.get(number) == null){
				m.put(number, 1);
			}else{
				m.put(number, m.get(number) + 1);
			}
		}
		System.out.println(m);
	}
}