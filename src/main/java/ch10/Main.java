package ch10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        for (Method m : int[].class.getDeclaredMethods()) {
            System.out.println(
                    Modifier.toString(m.getModifiers()) + " " +
                            m.getReturnType().getCanonicalName() + " " +
                            m.getName() + Arrays.toString(m.getParameters()));
        }

        ch11.Main.main(new String[] {"gm"});
    }
}
