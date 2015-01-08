/** Here we call a class Apple, which buried under directory "layer1/layer2/"
*	so the full path will be layer1.layer2.Apple
*	we call layer1.layer2 as package, and Apple as the real class.
*/


import layer1.layer2.Apple;

public class Runner{
	public static void main(String [] args){
		Apple a = new Apple();
	}
}