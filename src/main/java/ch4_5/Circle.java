package ch4_5;

import ch1_3.Point;

public class Circle extends Shape{

    double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    public Circle clone(){
        Circle clone = (Circle) super.clone();
        clone.radius = this.radius;
        return clone;
    }
}
