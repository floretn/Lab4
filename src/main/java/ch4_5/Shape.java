package ch4_5;

import ch1_3.Point;

public abstract class Shape implements Cloneable {

    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void move(double dx, double dy){
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }

    abstract public Point getCenter();

    public Shape clone(){
        try {
            Shape clone = (Shape) super.clone();
            clone.point = new Point(point.getX(), point.getY());
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
