/* let us use LinkedList to implement a Stack.
   Stack is first in, last out.
*/
import java.util.LinkedList;

public class Stack<T>{
	private LinkedList<T> holder = new LinkedList<T>();
	public void push(T object){
		holder.addFirst(object);
	}
	public T peek(){
		// look at the first element.
		return holder.peek(); // return null if empty.
	}
	public T pop(){
		// get the first element, remove it from holder.
		return holder.removeFirst();
	}
	public boolean empty(){
		return holder.isEmpty();
	}
	public String toString(){
		return holder.toString();
	}


	public static void main (String [] args){
		Stack<Apple> s = new Stack<Apple>();
		s.push(new Apple());
		s.push(new Apple());
		s.push(new Apple());
		System.out.println(s);
		s.pop();
		System.out.println(s);		
		System.out.println(s.peek());
	}


}

/*
[Apple 2, Apple 1, Apple 0]
[Apple 1, Apple 0]
Apple 1
*/