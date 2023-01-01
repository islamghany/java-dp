package creational.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args){
        Rectangle rect = new Rectangle(5,7,"red");
        Circle cir = new Circle(3.5,"blue");

        List<Shape> shapes = List.of(rect,cir);
        List<Shape> shapesCopy = new ArrayList<Shape>();

        // copy all red shapes

        shapes.forEach(shape -> {
            if(shape.color == "red"){
                shapesCopy.add(shape.clone());
            }
        });

        shapesCopy.forEach(shape -> {
            System.out.println(shape.color);
        });



    }

}

// the prototype interface declares the cloning method
// in most cases it's a single clone method
abstract class Shape{
    double height,width;
    String color;
    Shape(double height, double width, String color){
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public abstract  Shape clone();
}


// concrete prototype class implements the cloning method in addition to copying the original object data
//to the clone this method may also handle some edge cases the cloning process related
// the cloning linked objects, untangling recursive dependencies, etc.
class Rectangle extends Shape{
    double height,width;
    String color;
    Rectangle(double h,double w,String c){
        super(h,w,c);
        this.height = h;
        this.width = w;
        this.color = c;
    }

    public Shape clone(){
        return new Rectangle(this.height, this.width, this.color);
    }
}
class Circle extends Shape{
    double radius;
    String color;
    Circle(double radius, String color){
        super(10,10,color);

        this.radius = radius;
    }

    public Shape clone(){
        return new Circle(this.radius,this.color);
    }
}