/* 	if we want a class to work with Scanner class,
	it shall implement Readable interface.
	interface Readable {
		int read(CharBuffer cb);
	}
*/
import java.lang.Readable;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

// Let's implement a Readable class,
// Which will generate fix length random words in to a charbuffer. 
public class RandomReadable implements Readable{
	final static char[] CHARACTORS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	final static char[] NUMBERS = "0123456789".toCharArray();
	final static int TOP_LIMIT = 10;
	int length; // length of fix output.
	int count; // see read method.
	public RandomReadable(int length){
		this.length = length;
		Random rand = new Random();
		count = rand.nextInt(TOP_LIMIT);
	}

	public int read(CharBuffer cb){
		// Try to always append fixed length to cb, return fixed length.
		// Random a counter, if counter is hit, return -1
		if (count -- > 0){
			// fill the cb, return fix length.
			Random rand = new Random();
			for (int i=0;i<this.length;i++){
				cb.append(CHARACTORS[rand.nextInt(CHARACTORS.length)]);
			}
			cb.append("\n");
			return (this.length + 1);
		}else{
			return -1;
		}
	}

	public static void main(String [] args){
		RandomReadable rr = new RandomReadable(10);
		Scanner s = new Scanner(rr);
		while(s.hasNext())
			System.out.println(s.next());
	}
}