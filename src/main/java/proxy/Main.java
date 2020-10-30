package proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<Object> before(Object[] proxies, Object objBefore){
        ArrayList<Object> rez = new ArrayList<>();
        for (Object obj : proxies){
            if (((Comparable) obj).compareTo(objBefore) >= 0){
                break;
            }
            rez.add(obj);
        }
        return rez;
    }

    public static void main(String[] args) {
        Object[] values = new Object[1000];
        for (int i = 0; i < values.length; i++) {
            Object value = new Integer(i);
            values[i] = Proxy.newProxyInstance(
                    null,
            value.getClass().getInterfaces(),
                    (Object proxy, Method m, Object[] margs) -> {
                        System.out .println(value + " " + m.getName() + " "
                                + Arrays.toString(margs));
                        return m.invoke(value, margs);
                    });
        }
        Arrays.binarySearch(values, new Integer(120));
        ArrayList<Object> rez = before(values, new Integer(25));
        System.out.println(rez);
    }
}
