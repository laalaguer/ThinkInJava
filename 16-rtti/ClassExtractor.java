/**
Build a Class runtime information extractor. Extract methods from the class.
Methods from the base class are usually not showed in JDK doc in the child class.
*/
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ClassExtractor{
	public static void main (String [] args){
		if (args.length < 1){
			System.out.println("Input Class Name");
			System.exit(0);
		}
		
		
		Class <?> cc = null;
		cc = getClass(args[0]);
		Constructor<?> constructors[] = null;
		Method[] methods = null;
		if (cc != null){
			constructors = getConstructors(cc);
			printlist(constructors);
			methods = getDeclaredMethods(cc);
			printlist(methods);
		}
			
	}
	
	private static void printlist(Object [] objects){
		// Filter out. let "java.lang.object.toString()"
		// Becomes "toString()"
		Pattern p = Pattern.compile("\\w+\\.");
		for (Object each: objects){
			Matcher m = p.matcher(each.toString());
			System.out.println(m.replaceAll(""));
		}
	}
	
	private static Class<?> getClass(String name){
		Class <?> cc = null;
		try{
			cc = Class.forName(name); // Try to get the class.
		}catch (ClassNotFoundException e){
			System.out.println("No Such Class: " + name);
		}
		return cc;
	}
	
	private static Constructor<?> [] getConstructors(Class cc){
		Constructor<?> [] c = null;
		try{
			c = cc.getConstructors();
		}catch (SecurityException e){
			System.out.println(e);
		}
		return c;
	}
	
	private static Method[] getDeclaredMethods(Class cc){
		Method[] m = null;
		try{
			m = cc.getDeclaredMethods();
		}catch (SecurityException e){
			System.out.println(e);
		}
		return m;
	}
}