/** For each unknown class, if we write a proxy to cover its interface,
then we have a new proxy class which can be loaded at runtime and do same behavior as we wanted.
That is a requirement if you dont have the target class you want to call, at compile time.
For example, 
"android.util.nfc.emulator" is not included in Android SDK.
But you know that, this package is included in the Android Operating System in runtime.
So you load the class code dynamically and use a proxy to wrap around. Provide the same interface.

But sometimes you have the code of target class at hand. (Probably you write it 5 mins ago)
All you want is to wrap it around so you can see the performance of this class.
Each method shall be timed and logged. How to do it without touching your original class?
You can wrap it around with a dynamic proxy. So you dont need to write code to wrap around each method agian.
*/
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/* We declare an interface */
interface Search{
	void isInside();
}

/* We have a class that implements the interface.*/
class MySearch implements Search{
	public void isInside(){
		for (int i = 0 ;i < 100000; i++)
			;
		System.out.println("isInside() Done");
	}
}

class TimingProxy implements InvocationHandler{
	/* We want to have a proxy instance, that covers the "Search" interface.
	   Usually we create a class, which proxies the "Search" interface, 
	   then load and play with this proxy object.
	   Or we can just directly tell java to create a proxy instance for us.
	*/
		
	private Object proxied = null;
	public TimingProxy(Object proxied){
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object origin, Method method, Object[] args) throws Throwable{
		Object result = null;
		long before = new Date().getTime();
		try{
			result = method.invoke(this.proxied, args); // we invoke it on proxied object.
		} catch (InvocationTargetException e){
			throw e.getCause();
		}
		long after = new Date().getTime();
		System.out.printf("Time elpsed during call: %s is %d milliseconds %n",
			method.toString(), after-before );
		System.out.println("Method was invoked on object, class is: " + origin.getClass());
		return result;
	}
}

public class DynamicProxy{
	public static void main (String [] args){
		Search search = new MySearch();
		/* Let us get an instance of proxied object.*/
		Search proxiedSearch = (Search)Proxy.newProxyInstance(
			Search.class.getClassLoader(), // interface related 
			new Class[]{ Search.class },    // interface related
			new TimingProxy(search) // feed in a real implementation.
			);
		
		
		search.isInside();

		proxiedSearch.isInside();
	}
	
}