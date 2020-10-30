package loader.programm;

import helloworld.HelloWorld;
import loader.MyServiceLoader;

public class Main {
//    public static ServiceLoader<HelloWorld> loader =
//            ServiceLoader.load(HelloWorld.class);
    public static void main(String[] args){
//        for (HelloWorld helloWorld : loader){
//            helloWorld.write();
//        }
//        loader.forEach(HelloWorld::write);
        HelloWorld hw = MyServiceLoader.get("hello.Hello");
        if (hw != null) {
            hw.write();
        }else{
            System.out.println("No class");
        }
        hw = MyServiceLoader.get("world.World");
        if (hw != null) {
            hw.write();
        }else{
            System.out.println("No class");
        }
        hw = MyServiceLoader.get("helloworld.HelloWorld");
        if (hw != null) {
            hw.write();
        }else{
            System.out.println("No class");
        }

    }
}
