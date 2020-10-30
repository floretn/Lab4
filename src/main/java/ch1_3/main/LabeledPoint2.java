package ch1_3.main;

import ch1_3.Point;
import java.util.Objects;

public class LabeledPoint2 extends Point {

    private final String label;

    public LabeledPoint2(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", label = " + label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabeledPoint2 that = (LabeledPoint2) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }

    public static Point plus(LabeledPoint2... arr){
        Point point = new Point(0.0, 0.0);
        for (LabeledPoint2 lp : arr){
            point.setX(point.getX() + lp.x);
            point.setY(point.getY() + lp.y);
        }
        return point;
    }
}
