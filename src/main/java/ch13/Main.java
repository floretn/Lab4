package ch13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Main {

    public static void tableOutput(Method m, double low, double high, double step){
        double current = low;
        while(current <= high){
            try {
                System.out.println(m.invoke(m.getDeclaringClass(), current));
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("Вы передали плохой метод. Я не доволен!");
                break;
            }
            current += step;
        }
    }

    public static void tableOutputWithFunction(Function<Double, Object> function,
                                               double low, double high, double step){
        double current = low;
        while(current <= high){
            System.out.println(function.apply(current));
            current += step;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {

        tableOutput(Math.class.getMethod("sqrt", double.class),
                25.0, 625.0, 25.0);
        System.out.println("********************************************");
        tableOutput(Double.class.getMethod("toHexString", double.class),
                25.0, 625.0, 25.0);
        System.out.println("********************************************");
        tableOutputWithFunction(Math::sqrt, 25.0, 625.0, 25.0);
        System.out.println("********************************************");
        tableOutputWithFunction(Double::toHexString, 25.0, 625.0, 25.0);
    }
}
