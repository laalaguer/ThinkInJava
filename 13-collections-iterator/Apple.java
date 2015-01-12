public class Apple{
	static int number = 0 ;
	public int myNumber = 0;
	public Apple() {
		myNumber = number;
		number ++;
	}
	public String toString() { return "Apple " + myNumber;}
}