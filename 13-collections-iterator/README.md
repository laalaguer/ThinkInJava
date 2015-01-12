# Collections
Java `java.util.Collection` interface is interesting. It represents an interface where people can put objects inside.
it has following useful methods. Quit intuitive. See `TryCollection.java`.

```java
boolean contains(Object o); // if this collection contains this object.
boolean containsAll(Collection c); // if this collection contains the c collection.
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

# List
On the basis of `Collection`, the library `List` provides addtional functionalities.
```java
List<Object> l = new List<Object>();
l.add(3, "Good"); // insert at certain position.
l.get(3); // get object at certain position.
l.subList(2,4) // get [2] [3] elements in the list.
```

# Iterator

`Iterator` solves two problems, to my point of view.

1. First is the way to go through a `Collection`. 
Collection interface implements `Iterator iterator()` method. For `List`, you can go throught it 
with `list.get(int i)` method, but for `Set`, it doesnt event have a `get(int position)` method for you.
So regardless of `List` or `Set`, if they can return an `Iterator` object, then client programmer can 
go through it with `iterator.next()`. Thus, decouple the relation ship between Collection and its iterating.

2. Second is solve the concurrent modification problem.
```java
List<Item> list = new List<Item>();
// ...add some thing to list
for (Item i : list){
	list.remove(i); // remove item, while going through it, is prohibited. because length of list will change.
}
```
But sure if you can get an `Iterator<Item> it`, then you call `it.remove()` to remove the object, it is allowed.
Because `it` and `list` are seperate objects, so you are not travelling on `list` directly.