/* How to format your output? Do high level operations on a string.
 * You can directly use System.out.printf(), but it will lock your output
 * to System.out. If you use Formatter class, then it can be redirect later.
*/
import java.util.Formatter;

public class TryFormatter{
	public static void main(String [] args){
		Formatter f = new Formatter(); // this creates a formatter doesn't connect anywhere.
		f.format("%s is %dcm tall, and weights %dkg", "John", 180, 70);
		System.out.println(f); // f object has a .toString() method.
		f.format(" and %f is a float number.", 3.14);
		System.out.println(f);
		f.flush();
		System.out.println(f);
	}
}