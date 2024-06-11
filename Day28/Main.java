package com.Day28;

//Example usage
public class Main {
public static void main(String[] args) {
   ShapeFactory shapeFactory = new ShapeFactory();

   // Create different shapes
   Shape circle = shapeFactory.createShape("CIRCLE");
   Shape square = shapeFactory.createShape("SQUARE");
   Shape rectangle = shapeFactory.createShape("RECTANGLE");

   // Call draw method of each shape
   circle.draw();
   square.draw();
   rectangle.draw();
}
}
