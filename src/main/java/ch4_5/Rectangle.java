package ch4_5;

import ch1_3.Point;

public class Rectangle extends Shape{

    double width;
    double height;
    Point topLeft;

    public Rectangle(Point topLeft, double width, double height){
        super(new Point(topLeft.getX(), topLeft.getY()));
        this.move(width/2, height/2);
        this.topLeft = new Point(point.getX(), point.getY());
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    public Rectangle clone(){
        Rectangle clone = (Rectangle) super.clone();
        clone.topLeft = new Point(topLeft.getX(), topLeft.getY());
        return clone;
    }
}
