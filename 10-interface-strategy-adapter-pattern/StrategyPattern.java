import java.util.Arrays;
// Strategy is just an interface.
// It has 2 methods needed to be implemented.
interface Strategy{
	String getName();
	Object process(Object o);
}

// In order not to re-implement getName() over and over again,
// We use StringStrategy as abstract class to do implementation of getName().
// But process(Object) is still left out to be implemented.
abstract class StringStrategy implements Strategy{
	public String getName(){
		return getClass().getSimpleName();
	}
	public abstract String process(Object o);
}

// SplitStrategy, a kind of strategy we want.
class SplitStrategy extends StringStrategy{
	public String process(Object o){
		return Arrays.toString(((String)o).split(" "));
	}
}
// UpperCaseStrategy, a kind of strategy we want.
class UpperCaseStrategy extends StringStrategy{
	public String process(Object o){
		return ((String)o).toUpperCase();
	}
}

// The wrapper that does the real job.
public class StrategyPattern{
	// --> Strategy pattern, we apply different strategy to objects.
	public static void apply(Strategy s, Object o){
		System.out.println("Strategy name is: " + s.getName());
		System.out.println(s.process(o));
	}

	public static void main(String [] args){
		apply(new SplitStrategy(), "Good Morning");
		apply(new UpperCaseStrategy(), "Good Morning");
		/*
		Strategy name is: SplitStrategy
		[Good, Morning]
		Strategy name is: UpperCaseStrategy
		GOOD MORNING
		*/
	}
}