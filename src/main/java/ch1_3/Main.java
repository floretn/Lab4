package ch1_3;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1.0, 2.0);
        System.out.println(point.hashCode());
        Point point2 = new LabeledPoint(1.0, 2.0, "a");
        System.out.println(point2.hashCode());
        point.y = 10;
        System.out.println(point);
        System.out.println(point2);
        System.out.println(point.equals(point2));
    }
}
