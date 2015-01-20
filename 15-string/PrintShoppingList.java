/* formatting a string, you need to specify %[argument position$][flag][width][.percision]conversion
   so here argument position is the number 1, 2, 3... argument.
   flag is either not specified or a "-", which means alignment to the right.
   width is how large space shall allocate.
   .percision is how precice the number shall be. or if string is larger than width, shall be cut off.
   conversion is like "d" for decimal, "s" for string, "h" for hash, "x" for hex code.
   */
import java.util.Formatter;

public class PrintShoppingList{
	private Formatter f = new Formatter(System.out);
	private double total = 0;
	private double taxRate = 0.06;

	public void printTitle(){
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}
	public void printItem(String name, int qty, double price){
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;
	}
	public void printTotal(){
		f.format("%-15s %5s %10s\n", "","","---");
		f.format("%-15s %5s %10.2f\n", "Tax", "", taxRate*total);
		f.format("\n");
		f.format("%-15s %5s %10.2f\n", "Total", "", total+taxRate*total);
	}


	public static void main (String [] args){
		PrintShoppingList psl = new PrintShoppingList();
		psl.printTitle();
		psl.printItem("Big Pizza Hamburger", 2, 100.2);
		psl.printItem("Toothpaste", 1, 3.23);
		psl.printItem("Microwave", 1, 1000);
		psl.printTotal();
	}
}