package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Scanner;

public class Server implements ServerInterface {

    @Override
    public boolean getRequest(String s) {
            if (s.equals("hello")) {
                System.out.println("Привет!");
                return true;
            }

            if (s.equals("exit")) {
                System.out.println("Пока!");
                return false;
            }

            System.out.println("Не нашёл команды:((");
            return true;
    }

    public static <s> void main(String[] args) throws NoSuchMethodException {
        ServerInterface client = new Server();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();
        InvocationHandler ih = new IH(client);
        Object proxy = Proxy.newProxyInstance(Server.class.getClassLoader(),
                client.getClass().getInterfaces(), ih);

        do {
            System.out.print("> ");

        } while ((boolean) ((ServerInterface) proxy).getRequest(sc.next()));
    }
}
