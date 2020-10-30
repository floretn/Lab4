package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class IH implements InvocationHandler {

    ArrayList<String> al = new ArrayList<>();
    ServerInterface client;

    public IH(ServerInterface client ) {
        this.client = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        al.add((String) args[0]);
        if (((String) args[0]).equals("show")){
            System.out.println(al);
            return true;
        }
        return method.invoke(client, args);
    }
}
