package ch1_3;

import java.util.Objects;

public class LabeledPoint extends Point{

    private final String label;

    public LabeledPoint(double x, double y, String label) {
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
        LabeledPoint that = (LabeledPoint) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }

    public static Point plus(LabeledPoint... arr){
        Point point = new Point(0.0, 0.0);
        for (LabeledPoint lp : arr){
            point.x += lp.x;
            point.y += lp.y;
        }
        return point;
    }
}
