public class Main {
	public static void main(String[] args) {
			Rock rock = new Rock();
			// following method have different argument lists.
			rock.info(3, "good");
			rock.info("good", 3);
	}
}

class Rock {
	// Method can be overloaded with different argument list.
	// As long as the argument list is unique. (order of arguments, argument types)
	public void info(String info, int number) {
		System.out.println("Method 1");
	}
	
	public void info(int number, String info) {
		System.out.println("Method 2");
	}
}
