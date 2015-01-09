# Inner class

Inner Class can be useful, it is part of Java language feature.
If you want to go advance, this feature you cannot miss.
Java can only allow to inherit from one class. But at the same time implement several interfaces.
The inner class basically solve this question:
`01. How to inherit from multiple classes?`

Another question is, if our class don't want to mess up local methods because of inheritance,
`02. How to nicely seperate inherited methods from local methods?`

The solution is `Inner class`. Let the classes nested inside to inherit super classes.
Let inner class to deal with old methods from super class, but outsider(main) class focus on business logic.

The last question is actually new, inner class can access outerclass `private` members.
`03. Inner class can access outer class members, even private.`

We demonstrate `01` and `02` in `Car.java`, and `03` in `Sequence.java`