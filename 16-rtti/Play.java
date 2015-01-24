public class Play{
	public static void main(String [] args){

		Class ball = returnClass("Ball");
		if (ball!=null){
			info(ball);
		}

		Class pattern = returnClass("java.util.regex.Pattern");
		if (pattern!=null){
			info(pattern);
		}
		Class list = returnClass("java.util.List");
		if (list != null){
			info(list);
		}

	}

	public static Class returnClass(final String name){
		/* Get a class object, if not found, return null*/
		Class temp = null;
		try{
			temp = Class.forName(name); // this is a static method.
		}catch (ClassNotFoundException e){
			System.out.println(name);
		}
		return temp;
	}

	public static void info(Class cc){
		/* So what methods does Class object have?*/
		System.out.printf("Class Name: %s, is Interface? %b %n", cc.getName(), cc.isInterface());
	}
}