# keyword `this`

`this` keyword have two functionality, the first is to refer to an object.

```java
class Rock {

	public Rock returnMe(){
		return this; // -->  return current Rock object.
	}
}
```
You may call above method like this:
```java
Rock r = new Rock();
Rock r2 = r.returnMe(); // r and r2 will refer to the same Rock type object in memory.
```

`this` keyword also refers to the other constructor in the class.

```java
class Rock{
	
	Rock(){
		System.out.println("This is Rock");
	}

	Rock(int i){
		this(); // --> This will invoke Rock() method defined above.
		System.out.println("We called Rock(), then :" + String.valueOf(i));
	}
}
```