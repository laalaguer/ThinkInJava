/* We want to have sequence here, where provides two functionalities.
 * First is to go forward, and goes to the end of sequence.
 * Second is to go backward, and goes to the begin of sequence.
 * We only want Sequece to hold the data, nice and simple.
 * So who is going to privide those two functionalities?
 */
import java.util.Arrays;

// Functionality of go forward.
interface ForwardSelector{
	boolean hasNext();
	void goNext();
	Object current();
	int position();
}
// Functionality of go backward.
interface BackwardSelector{
	boolean hasBackward();
	void goBackward();
	Object current();
	int position();
}

// So we must have a structure to hold the actual data.
public class Sequence{
	private Object [] array;
	private int length;
	private int pointer;
	
	public Sequence(int length){
		this.length = length;
		array = new Object[length];
		pointer = -1;
	}

	public boolean append(Object o){
		if (pointer < length-1){ // if didn't reach the end.
			pointer ++;
			array[pointer] = o;
			return true;
		}else{
			return false;
		}
	}

	public Object[] getArray(){
		return array;
	}

	public ForwardSelector getForwardSelector(){
		return new SequenceForwardSelector();
	}

	// Inner class to implement the ForwardSelector.
	// So we can seperate the logic of "holding data" from "travel on data".
	private class SequenceForwardSelector implements ForwardSelector{
		int pivot = -1;

		SequenceForwardSelector(){
			initialize();
		}
		private void initialize(){
			if (pointer >=0) //--> Magic is here, access "pointer" from inner class.
				pivot = 0;
		}
		public boolean hasNext(){
			if (pivot < pointer)
				return true;
			else
				return false;
		}
		public void goNext(){
			if (hasNext())
				pivot++;
		}
		public Object current(){
			if (pivot >-1)
				return array[pivot]; //--> Magic is here, you can access "array" from inner class.
			else
				return null;
		}
		public int position(){
			return pivot;
		}
	}
	public static void main (String [] args){
		Sequence line = new Sequence(10);
		for (int i=0;i<7;i++){
			if (line.append(i) == false)
				break;
		}

		System.out.println(Arrays.toString(line.getArray()));

		ForwardSelector fs = line.getForwardSelector();
		while (true){
			System.out.println(fs.position() + ":"+ fs.current());
			if (fs.hasNext())
				fs.goNext();
			else
				break;
		}
		
	}
}

/* Result is:
[0, 1, 2, 3, 4, 5, 6, null, null, null]
0:0
1:1
2:2
3:3
4:4
5:5
6:6
*/