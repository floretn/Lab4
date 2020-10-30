package dop.cast;

import classLoader.MyClassLoader;
import sun.util.resources.cldr.CalendarData;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
//        URL[] urls = new URL[] {new URL("file:///home/floret/IdeaProjects/Person/target/classes/")};
//        URLClassLoader loader = new URLClassLoader(urls);
//        Class<?> cl = Class.forName("person.Person", true, loader);
//        Object obj = cl.getMethod("getNewPerson", String.class).invoke(cl.newInstance(),"Anonim");
//        Person person = (Person) obj;
//        System.out.println(person);

//        URL[] urls = new URL[] {new URL("file:///home/floret/IdeaProjects/" +
//                "Laboratornaya_Rabota_4/target/classes/")};
//        URLClassLoader loader = new URLClassLoader(urls);
//        Class<?> cl = Class.forName("ch1_3.LabeledPoint", true, loader);
//        Object obj = cl.getConstructor(double.class, double.class, String.class).
//                newInstance(12.9, 12.10, "Point");
        CalendarData cd;
        MyClassLoader loaderOne = new MyClassLoader("/home/floret/IdeaProjects/" +
                "Laboratornaya_Rabota_4/target/classes/", CalendarData.class.getClassLoader());
        MyClassLoader loader = new MyClassLoader("/home/floret/IdeaProjects/" +
                "Laboratornaya_Rabota_4/target/classes/", loaderOne);
        Class<?> cl1 = Class.forName("ch1_3.Point", true, loader);
        Class<?> cl = Class.forName("ch1_3.LabeledPoint", true, loader);
        Object obj = cl.getConstructor(double.class, double.class, String.class).
                newInstance(12.9, 12.10, "Point");
    }
}
