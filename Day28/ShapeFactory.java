package com.Day28;



//Interface for shapes
interface Shape {
 void draw();
}

//Concrete implementation of Circle
class Circle implements Shape {
 @Override
 public void draw() {
     System.out.println("Drawing Circle");
 }
}

//Concrete implementation of Square
class Square implements Shape {
 @Override
 public void draw() {
     System.out.println("Drawing Square");
 }
}

//Concrete implementation of Rectangle
class Rectangle implements Shape {
 @Override
 public void draw() {
     System.out.println("Drawing Rectangle");
 }
}

//ShapeFactory class encapsulating object creation logic
public class ShapeFactory {
 // Factory method to create different shapes
 public Shape createShape(String shapeType) {
     if (shapeType == null) {
         return null;
     }
     if (shapeType.equalsIgnoreCase("CIRCLE")) {
         return new Circle();
     } else if (shapeType.equalsIgnoreCase("SQUARE")) {
         return new Square();
     } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
         return new Rectangle();
     }
     return null;
 }
}


