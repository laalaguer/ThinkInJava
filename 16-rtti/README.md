# RTTI

RunTime Type Information is an advanced feature in Java. Everything in Java is object, this is the same in the Python. In Python even a function is an object. When you write a class in Java, after compilation, it will create an object, we call it `.class` file. For example, `Apple.java` will create a `Apple.class` file. 

Java class loader sub-system will load this object into memory, then start to instantiate other `Apple` objects. So in Java, a class is not only a template you generate objects, actually it also is object itself.

# What kind of problem does RTTI solve?

RTTI enables some advanced features. For example I have written an application to enable NFC feature in Android phones.
[Android NFC Relay Attack](https://github.com/laalaguer/HCE-NFC-Relay-Attack).

This repo enables one cell phone's NFC chip to behave like like a NFC card. Originally phones only provide API to make the chip works like a NFC reader. So to "enable" this NFC card emulation feature from Android Operating system, I used RTTI feature, or say "Reflection" in Java.
Condition is like this:
```
1. NFC chip emulated as card functionality is already available in operating system.
2. This NFC emulation API is not included in Android SDK. (prevent you from calling it when program a app).
3. We know the package is named as java.util.NFC.
4. We call the emulation API during runtime. (When app is loaded onto cell phone)
5. We use the feature in cell phone app.
```

# In This Folder

You shall first look at `Play.java` to get a general idea about how to use RTTI to get information about a class.
Like how to get class methods. How to construct an object based on the class information.

Then you can go to `ClassExtractor.java` to see how to get list of methods about a class that you dont know anything about.

Last you can read the `DynamicProxy.java` to see the functionality of proxing a already made class. This proxy will time the funtion time.
