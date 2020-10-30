package classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException
    {
        MyClassLoader loader = new MyClassLoader("/home/floret/",
                ClassLoader.getSystemClassLoader());
        Class<?> cl = Class.forName("ch0.HelloWorld", true, loader);
        Object obj = cl.newInstance();
        Method m = obj.getClass().getMethod("write");
        m.invoke(obj);
    }
}
