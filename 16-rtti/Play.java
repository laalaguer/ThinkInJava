public class Play{
	public static void main(String [] args){

		Class ball = returnClass("Ball");
		Class pattern = returnClass("java.util.regex.Pattern");


	}

	public static Class returnClass(final String name){
		Class temp = null;
		try{
			temp = Class.forName(name);
		}catch (ClassNotFoundException e){
			System.out.println(name);
		}
		return temp;

	}
}