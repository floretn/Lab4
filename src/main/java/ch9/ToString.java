package ch9;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ToString {

    HashMap<Class<?>, List<Object>> cashMap = new HashMap<>();
    //ArrayList<Object> cash = new ArrayList<>();

    public String toString(Object obj) throws InvocationTargetException, IllegalAccessException {
        String rez = toString1(obj, cashMap);
        cashMap.clear();
        return rez;
    }

    private String toString1(Object obj, HashMap<Class<?>, List<Object>> hm) throws InvocationTargetException,
            IllegalAccessException
    {

        System.out.println(hm.size());


        if (hm.containsKey(obj.getClass())){
            for (Object o : hm.get(obj.getClass())){
                if (obj == o) {
                    return "first element";
                }
            }
            hm.get(obj.getClass()).add(obj);
        }else{
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add(obj);
            hm.put(obj.getClass(), arrayList);

        }

        Class<?> cl = obj.getClass();

        if (cl.equals(String.class)){
            return (String) obj;
        }

        if (cl.isArray()){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < Array.getLength(obj); i++){
                if (i != Array.getLength(obj) - 1) {
                    sb.append(toString1(Array.get(obj, i), hm)).append(", ");
                }else{
                    sb.append(toString1(Array.get(obj, i), hm)).append("]");
                }
            }
            return String.valueOf(sb);
        }

        if (obj instanceof Collection){
            return toString1(((Collection<?>) obj).toArray(), hm);
        }

        if (obj instanceof Map){
            Map<?, ?> map = (Map<?, ?>) obj;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Object key : map.keySet().toArray()){
                sb.append("[key: ").append(toString1(key, hm)).append(", entry: ").
                        append(toString1(map.get(key), hm)).append("]");
            }
            sb.append("]");
            return String.valueOf(sb);
        }

        Method m = null;
        try {
            m = obj.getClass().getDeclaredMethod("toString");
            return (String) m.invoke(obj);
        } catch (NoSuchMethodException ignored) {
        }

        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getCanonicalName()).append(": ");

        if (obj.getClass().getSuperclass() != Object.class){
            Class<?> superClass = obj.getClass().getSuperclass();
            for (Field f : superClass.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(obj);
                if (value.getClass().isPrimitive()){
                    sb.append(f.getName()).append("= ").append(toString1(value, hm)).append(", ");
                }else {
                    sb.append(f.getName()).append(": [").append(toString1(value, hm)).append("], ");
                }
            }
        }

        int i = 0;
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(obj);
            if (i != obj.getClass().getDeclaredFields().length - 1) {
                if (value.getClass().isPrimitive()){
                    sb.append(f.getName()).append("= ").append(toString1(value, hm)).append(", ");
                }else {
                    sb.append(f.getName()).append(": [").append(toString1(value, hm)).append("], ");
                }
            } else {
                if (value.getClass().isPrimitive()){
                    sb.append(f.getName()).append("= ").append(toString1(value, hm));
                }else {
                    sb.append(f.getName()).append(": [").append(toString1(value, hm)).append("] ");
                }
            }
            i++;
        }
        return String.valueOf(sb);
    }


}
