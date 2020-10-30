package dop.download;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        InputStream stream = Main.class.getResourceAsStream("example.txt");
        System.out.println(Main.class);
        System.out.println(stream);
        Scanner in = new Scanner(stream);
        System.out.println(in.nextLine());
        System.out.println(in.nextLine());
        while (in.hasNext()){
            System.out.println(in.nextLine());
        }
    }
}
