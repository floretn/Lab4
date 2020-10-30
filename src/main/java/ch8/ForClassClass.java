package ch8;

import java.util.ArrayList;

public class ForClassClass {

    int a = 1;
    int[] array = new int[] {1, 2, 3, 4, 5};
    ArrayList<Integer> arrayList = new ArrayList<>();
    Example ex = new Example();

    public class Example{
        int b = a;
    }

    public static void method(Object o){
        Class<?> classForClass = o.getClass();
        System.out.println(classForClass.getCanonicalName());
        System.out.println(classForClass.getSimpleName());
        System.out.println(classForClass.getTypeName());
        System.out.println(classForClass.getName());
        System.out.println(classForClass.toString());
        System.out.println(classForClass.toGenericString());
        System.out.println("************************************************************************");
    }

    public static void main(String[] args) {
        ForClassClass fcc = new ForClassClass();
        fcc.arrayList.add(1);
        fcc.arrayList.add(2);
        method(fcc.array);
        method(fcc.arrayList);
        method(fcc.ex);
        method(fcc.a);
    }
}
