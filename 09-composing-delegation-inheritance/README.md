# Concept of Inheritance, Composition and Delegation

You have a car, which consists of wheels, car engine. (Composition)

Car engine is inherited from a genric idea "engine". (Inheritance)

You have a controller to control the car, to tell the car go "forward", "backward".
But car "is not" a controller, it only exposes the same interface "forward", "backward".
Instead of say "car.contoller.forward()", you say "car.forward()".
So you delegate the interface from controller to car. (Delegation)
