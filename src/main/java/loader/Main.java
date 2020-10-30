package loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MalformedURLException,
            ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        URL[] urls = new URL[] {new URL("file:///home/floret/OS_jar/OS.jar")};
        System.out.println(Arrays.toString(urls));
        URLClassLoader loader = new URLClassLoader(urls);
        Class<?> cl = Class.forName("fs.DownloadFS", true, loader);
        Object obj = cl.newInstance();
        Method m = obj.getClass().getMethod("download");
        m.invoke(obj);
    }
}
