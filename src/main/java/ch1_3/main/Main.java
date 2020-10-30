package ch1_3.main;

import ch1_3.LabeledPoint;
import ch1_3.Point;

public class Main {
    public static void main(String[] args) {
        LabeledPoint point = new LabeledPoint(1.0, 2.0, "");
        System.out.println(point.hashCode());
        Point point2 = new LabeledPoint(1.0, 2.0, "");
        System.out.println(point2.hashCode());
        System.out.println(point.getY());
        System.out.println(point2.equals(point));
        double x = point.getX();
    }
}
