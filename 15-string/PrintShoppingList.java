import java.util.Formatter;

public class PrintShoppingList{
	private Formatter f = new Formatter(System.out);

	public void printTitle(){
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}

	public static void main (String [] args){
		PrintShoppingList psl = new PrintShoppingList();
		psl.printTitle();
	}
}