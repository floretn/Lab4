package ch11;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, NoSuchFieldException
    {
        System.class.getField("out").
                get(System.class).getClass().getMethod("println", String.class).
                invoke(System.class.getField("out").
                        get(System.class), "Hello World!");
    }
}
