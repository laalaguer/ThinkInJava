# Java interface and Adapter/Strategy Pattern

Java have powerful interface system, which can enable you to do strategy pattern or adapter pattern.

# Strategy Pattern

Apply different strategy onto same object. 
```java
apply(Strategy s, Object o);
```
Where here Strategy is an interface, so implement differently will result differently.

# Adapter Pattern

Just like the name suggests, an "adapter" can take one interface and expose as anther interface.
For example, you have interface `Apple`
```java
interface Apple {
	String getName();
	void peel();
}
```
So you write a method to work with Apple
```java
apply(Apple a);
```
However this time when you discover a new library, you find that you have a class `Orange`.
```java
class Orange{
	String getName(){return "Orange";}
	void peel(){ System.out.println("I peel off skins.");}
}
```
Although `Apple` and `Orange` has the same methods, but `apply(Apple a)` won't work with `Orange` type.
That's why you need adapter, put in `Orange` and behave like `Apple`:
```java
class AppleAdapter implements Apple{
	// Notic that AppleAdapter works like Apple.
	// But actually it uses concept of delegation.
	Orange o;
	AppleAdapter(Orange o){
		this.o = o;
	}
	String getName(){ return o.getName();}
	void peel(){ o.peel();}
}
```
Delegation is used here to let `AppleAdapter` works just like `Apple`. see `09-composing-delegation-inheritance`