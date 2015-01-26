/* You may encounter two problems when trying to call instantiation of an object.
   1. InstantiationException : you may feed wrong parameters into the constructor.
   2. IllegalAccessException : the constructor might me private, so you cannot call it.
*/
public class Play{
	public static void main(String [] args){

		Class ball = returnClass("Ball"); // Can't find Ball class.
		if (ball!=null){
			info(ball);
			Object o = returnObject(ball);
		}
		
		Class pattern = returnClass("java.util.regex.Pattern");
		if (pattern!=null){
			info(pattern);
			Object o = returnObject(pattern); // Can't, cause Pattern has no public constructur class.
		}
		Class list = returnClass("java.util.List");
		if (list != null){
			info(list);
			Object o = returnObject(list); // can't, cause List is interface.
		}
        Class shape = returnClass("Shape");
        if (shape != null){
            info(shape);
			Object o = returnObject(shape); // can't, cause Shape is interface.
        }
        Class bus = returnClass("Bus");
        if (bus != null){
            info(bus);
			Object o = returnObject(bus); // will work.
			System.out.println("bus class object instantiated, return class is: " + o.getClass());
        }
        Class car = returnClass("Car");
        if (car != null){
            info(car);
			Object o = returnObject(car); // can't, cause Car() is private
        }
	}

	public static Class returnClass(final String name){
		/* Get a class object, if not found, return null*/
		Class temp = null;
		try{
			temp = Class.forName(name); // this is a static method.
		}catch (ClassNotFoundException e){
			System.out.println("Cannot get class:" + name);
		}
		return temp;
	}
	
	public static Object returnObject(final Class cc){
		/* Try to get an object of a certain class.
			We may face: not instantiate-able, or constructor is private,
			or constructor parameter is wrong.*/
		Object o = null;
		try{
			o = cc.newInstance();
		} catch (InstantiationException e){
			System.out.println(e);
		} catch (IllegalAccessException e){
			System.out.println(e);
		}
		
		return o;
	}

	public static void info(Class cc){
		/* So what methods does Class object have?*/
		System.out.printf("Class Name: %s, is Interface? %b %n", cc.getName(), cc.isInterface());
	}
}

/* This class is defined in this file */
interface Shape{
	void draw();
	String toString();
}

class Car{
	private Car(){;}
}

class Viechle{
	Viechle(){System.out.println("This is Viechle");}
}

class Bus extends Viechle{
	Bus(){
		super();
		System.out.println("This is bus.");
	}
}

/*
Cannot get class:Ball
Class Name: java.util.regex.Pattern, is Interface? false 
java.lang.InstantiationException: java.util.regex.Pattern
Class Name: java.util.List, is Interface? true 
java.lang.InstantiationException: java.util.List
Class Name: Shape, is Interface? true 
java.lang.InstantiationException: Shape
Class Name: Bus, is Interface? false 
This is Viechle
This is bus.
bus class object instantiated, return class is: class Bus
Class Name: Car, is Interface? false 
java.lang.IllegalAccessException: Class Play can not access a member of class Car with modifiers "private"
*/
