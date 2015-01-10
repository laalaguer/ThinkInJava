# A Control Framework

We have many examples to build a framework, which is like an environment. Client programmers
try to extends some of the classes. But the control framework will take care of the whole life 
cycle of objects that client programmer creates.

One example is the Android programming. Client programmers extends `Activities`, and overrides
methods like `onCreate()` and `onPause()` to do their business logic. But still, Android operating
system (on behalf of users) generates those events and send to `Activities`.

So you see here, `events` are sent to `Activities` that will make responses. So framework, events,
they are linked together. Client programmers extends `Activities` and register them on frameworks,
then those special `Activities` will respond to `event`s.

Java Swing library is another example. GUI is a bunch of special classes that client programmers extends.
Then GUI framework will send `events` to `Buttons`, `TextField` and other components. These components are
resigtered onto the framework already. These components will respond to `event`s.

Let's see an example of a control framework.

`Event.java` describes events. It is abstract.

`ControlFramework.java` describes a generic control framework which will have system inputs, and trigger events.
Above two are quite generic.

`SmartPhoneControlFramework.java` describes a framework specialized for the smartphone, it defines events to be used.
You can see that events can trigger each other.

`ClientProgram.java` describes a program that client writes, to run a demo example.