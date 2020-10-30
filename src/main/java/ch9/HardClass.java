package ch9;

import ch1_3.LabeledPoint;
import ch4_5.Shape;

import java.util.ArrayList;

public class HardClass {

    private Shape shape;
    private final String s = "Bla-bla-bla";
    private ArrayList<LabeledPoint> al = new ArrayList<>();

    public HardClass(Shape shape) {
        this.shape = shape;
        //s = "Bla-bla-bla";
        al.add(new LabeledPoint(12.0, 22.43, "fker"));
        al.add(new LabeledPoint(12.0, 22.43, "tergetrjer"));
    }

}
