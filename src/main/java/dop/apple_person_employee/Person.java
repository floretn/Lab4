package dop.apple_person_employee;

public class Person extends Apple {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void who(){
        System.out.println("You are " + name + ". And you are human!");
    }
}
