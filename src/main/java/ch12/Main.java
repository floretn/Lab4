package ch12;

import ch1_3.Point;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

//    public static ArrayList<Double> doLgo(int length){
//        Random rnd = new Random();
//        ArrayList<Double> arrayList = new ArrayList<>();
//        for (int i = 0; i < length; i++){
//            arrayList.add(rnd.nextDouble());
//        }
//
//        for (int i = 0; i < length - 1; i++){
//            for (int j = 0; j < length; j++){
//                if (arrayList.get(i) < arrayList.get(j)){
//                    double max = arrayList.get(i);
//                    arrayList.set(i, arrayList.get(j));
//                    arrayList.set(j, max);
//                }
//            }
//        }
//        return arrayList;
//    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {


//        long time1;
//        long time2;
//        for (int i = 0; i < 10000; i++) {
//            System.out.println("Через рефлексию: ");
//            time1 = System.nanoTime();
//            System.class.getField("out").
//                    get(System.class).getClass().getMethod("println", String.class).
//                    invoke(System.class.getField("out").
//                            get(System.class), "Hello World!");
//            time2 = System.nanoTime();
//            System.out.println(time2 - time1);
//            System.out.println("Напрямую: ");
//            time1 = System.nanoTime();
//            System.out.println("Hello World!");
//            time2 = System.nanoTime();
//            System.out.println(time2 - time1);
//            System.out.println("**********************************************************************");
//        }

        Point point = new Point(12.0, 13.13);
        long time1;
        long time2;
        long timeReflect = 0;
        long time = 0;
        String s;
        for (int i = 0; i < 1000; i++){
            System.out.println("Напрямую: ");
            time1 = System.nanoTime();
            s = point.toString();
            time2 = System.nanoTime();
            time += time2 - time1;
            System.out.println(time2 - time1);
            System.out.println("Через рефлексию: ");
            time1 = System.nanoTime();
            s = (String) point.getClass().getMethod("toString").invoke(point);
            time2 = System.nanoTime();
            timeReflect += time2 - time1;
            System.out.println(time2 - time1);
            System.out.println("**********************************************************************");
        }
        System.out.println("Напрямую: ");
        System.out.println(time);
        System.out.println("Через рефлексию: ");
        System.out.println(timeReflect);
        timeReflect = 0;
        time = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Method m = point.getClass().getMethod("toString");
        for (int i = 0; i < 1000; i++){
            System.out.println("Напрямую: ");
            time1 = System.nanoTime();
            s = point.toString();
            time2 = System.nanoTime();
            time += time2 - time1;
            System.out.println(time2 - time1);
            System.out.println("Через рефлексию: ");
            time1 = System.nanoTime();
            s = (String) m.invoke(point);
            time2 = System.nanoTime();
            System.out.println(time2 - time1);
            System.out.println("**********************************************************************");
            timeReflect += time2 - time1;
        }
        System.out.println("Напрямую: ");
        System.out.println(time);
        System.out.println("Через рефлексию: ");
        System.out.println(timeReflect);

//        for (int i = 0; i < 11; i++) {
//            long time1 = System.nanoTime();
//            doLgo(10000);
//            long time2 = System.nanoTime();
//            System.out.println(time2 - time1);
//
//            time1 = System.nanoTime();
//            Method m = ch12.Main.class.getMethod("doLgo", int.class);
//            m.invoke(ch12.Main.class, 10000);
//            time2 = System.nanoTime();
//            System.out.println(time2 - time1);
//            System.out.println("***********************************************");
//        }
//        Supplier<String> stringSupplier = point::toString;

    }
}
