package ch6;

public class Main {
    public static void main(String[] args) {
        Item x = new DiscountedItem("tovar", 10.0, 5.0);
        Item y = new Item("tovar", 10.0);
        Item z = new DiscountedItem("tovar", 10.0, 6.0);
        System.out.println(x.equals(y));
        System.out.println(y.equals(x));
        System.out.println(y.equals(z));
        System.out.println(z.equals(y));
        System.out.println(x.equals(z));
    }
}
