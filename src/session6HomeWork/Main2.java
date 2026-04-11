package org.prog.session6HomeWork;

public class Main2 {

    public static void main(String[] args) {

        Phone2 p1 = new Phone2("Samsung", "Black");
        Phone2 p2 = new Phone2("Samsung", "Black");
        Phone2 p3 = new Phone2(null, "White");

        try {
            System.out.println(p1.equals(p2)); // true
            System.out.println(p1.equals(p3)); // exception
        } catch (RuntimeException e) {
            System.out.println("oops, phone has no brand or color!");
        }
    }
}