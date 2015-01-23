# StringBuilder
`TryStringBuilder.java`

This class is built for setup a string. Ususally it is cheaper than build strings with `+`
You can easily reverse, delete some characters,
do some substring before you call `toString()` to output this final string.

# String
`TryString.java`

Main class that we uses everyday. Some similarities with `StringBuilder`, each time
you call the object method, it will generate a new string.

# Different Conversion
`DifferentConversion.java`
Want to know how to format a `Date()` object ? Display the second, hour, minute and year?
How to format an Integer? Into hex value?

# Formatter
`TryFormatter.java`
Start to remember the `C` language `printf()` function? Java Formatter class gives you the chance.
The only thing it differs from String.format(), is that it can be used on any out put object.

# Format with different width, different percision
`PrintShoppingList.java`

Want to format with different length, align to left/right? or change formatting argument list?

# Regex on String
`RegularExpression.java`

String object can replace some parts, with a matched regular expression.
You also want to pay attention to greedy mode and lazy mode, when match the given string.

# Regex
`Regex.java`
Gives you a basic idea, how this `Pattern` and `Matcher` are used. When you are doing regular expression.
Pay attention to `matcher(), matches(), compile()` and `group(), start(), end()` method.


# Dive into Matcher
`CountUniqueWords.java`
Tell you how to use the `group(i)` method more deeply. 
And `appendBuffer(StringBuffer, String)` and `appendTail(StringBuffer)` method.

# Dive into Matcher 2
`StringLooking.java`
Tell you how to match the whole String, or the beginning part of it. And reset() the matcher inner states.