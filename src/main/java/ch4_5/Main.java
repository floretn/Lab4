package ch4_5;

import ch1_3.Point;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(new Point(0.0, 0.0), 2, 3);
        Rectangle clone = rectangle.clone();
        System.out.println(rectangle.point + " "
                + rectangle.topLeft + " " + rectangle.width + " " + rectangle.height);
        System.out.println(clone.point + " "
                + clone.topLeft + " " + clone.width + " " + clone.height);
        clone.move(10, 10);
        clone.topLeft.setX(10);
        clone.topLeft.setY(10);
        clone.height += 10;
        clone.width += 10;
        System.out.println(rectangle.point + " "
                + rectangle.topLeft + " " + rectangle.width + " " + rectangle.height);
        System.out.println(clone.point + " "
                + clone.topLeft + " " + clone.width + " " + clone.height);
    }
}
