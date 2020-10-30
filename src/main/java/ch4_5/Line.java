package ch4_5;

import ch1_3.Point;

public class Line extends Shape{

    Point from;
    Point to;

    public Line(Point from, Point to) {
        super(new Point((from.getX() - to.getX())/2, (from.getY() - to.getY())/2));
        this.from = from;
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    public Line clone(){
        Line clone = (Line) super.clone();
        clone.from = new Point(this.from.getX(), this.from.getY());
        clone.to = new Point(this.to.getX(), this.to.getY());
        return clone;
    }
}
