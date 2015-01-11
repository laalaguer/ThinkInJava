# Collections
Java `java.util.Collection` interface is interesting. It represents an interface where people can put objects inside.
it has following useful methods. Quit intuitive. See `TryCollection.java`.

```java
boolean contains(Object o); // if this collection contains this object.
boolean add(Object o); // add into collection.
int size(); // how large is collection.
boolean remove(Object o); // remove an object.
boolean removeAll(Collection another); // remove objects overlapped with another collection.
boolean addAll(Collection another); // add all objects in another collection.
boolean isEmpty(); // check if collection is empty.
// Most importantly, change it back to Array
T[] toArray(T[] a); // output collections into an array. String[] s = c.toArray(new String[0]);
```
Also the class-level method (java.util.Collections)
```java
Collections.addAll(Collection c, element, element, element);
Collections.addAll(Collection c, Collection another);
```
works much faster than the object type method. This is the same with Python
```python
s = "a" + "b" + "c" # slower.
s = "".join(["a", "b", "c"]) # faster.
```
