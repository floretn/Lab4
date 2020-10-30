package ch9;

import ch1_3.Point;
import ch4_5.Circle;
import ch6.Item;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        ToString ts = new ToString();
        Point point = new Point(10.0, 9.12);
        System.out.println(ts.toString(point));
        Point1 point1 = new Point1(12.0, 13.0);
        System.out.println(ts.toString(point1));
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(ts.toString(arrayList));
        char[] chars = new char[] {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        System.out.println(ts.toString(chars));
        Item item = new Item("description", 100.01);
        System.out.println(ts.toString(item));
        HardClass hc = new HardClass(new Circle(new Point(4.20, 22.8), 435.34));
        System.out.println(ts.toString(hc));
        HardClass[] hcs = new HardClass[] {new HardClass(new Circle(new Point(4.20, 22.8), 435.34)),
                new HardClass(new Circle(new Point(4.20, 22.8), 128.8))};
        System.out.println(ts.toString(hcs));
        ArrayList<HardClass> al = new ArrayList<>();
        al.add(new HardClass(new Circle(new Point(4.20, 22.8), 435.34)));
        al.add(new HardClass(new Circle(new Point(4.20, 22.8), 128.8)));
        System.out.println(ts.toString(al));

        Field f = hc.getClass().getDeclaredField("s");
        f.setAccessible(true);
        f.set(hc, "Выкуси!");
        System.out.println(ts.toString(hc));

        HardClass2 hc1 = new HardClass2(1, null);
        HardClass2 hc2 = new HardClass2(2, hc1);
        HardClass2 hc3 = new HardClass2(3, hc2);
        hc1.hd = hc3;
        System.out.println(ts.toString(hc1));
    }
}
