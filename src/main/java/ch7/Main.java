package ch7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int i = rnd.nextInt(8);
        Colors color = Colors.values()[i];
        System.out.println(color);
        if (color == color.getBlue() || color == color.getGreen() || color == color.getRed()){
            System.out.println("Yes!");
        }else{
            System.out.println("No:(");
        }
    }
}
