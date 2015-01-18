/* How to format your output? Do high level operations on a string.
 * You can directly use System.out.printf(), but it will lock your output
 * to System.out. If you use Formatter class, then it can be redirect later.
*/
import java.util.Formatter;

public class TryFormatter{
	public static void main(String [] args){
		Formatter f = new Formatter(); // this creates a formatter doesn't connect anywhere.
		f.format("%s is %dcm tall, and weights %dkg", "John", 180, 70);
		System.out.println(f); // John is 180cm tall, and weights 70kg
		f.format(" and %f is a float number.", 3.14);
		System.out.println(f); // John is 180cm tall, and weights 70kg and 3.140000 is a float number.
		/* So the formatter has a stateful memory. It wont erase previous content.*/


		Formatter f2 = new Formatter(System.out); // System.out is a PrintStream. 
		f2.format("%d is the number of December\n", 12); // 12 is the number of December
		f2.format("And %s doesnt remember the last sentence", "f2"); // And f2 doesnt remember the last sentence


		Formatter f3 = new Formatter(new StringBuilder());
		f3.format("Can we call String Builder here? %b\n", true);
		System.out.println(f3);
		f3.format("format this %d into octal number. %o", 12, 12);
		System.out.println(f3);
	}
}

/*
John is 180cm tall, and weights 70kg
John is 180cm tall, and weights 70kg and 3.140000 is a float number.
12 is the number of December
And f2 doesnt remember the last sentenceCan we call String Builder here? true

Can we call String Builder here? true
format this 12 into octal number. 14
*/