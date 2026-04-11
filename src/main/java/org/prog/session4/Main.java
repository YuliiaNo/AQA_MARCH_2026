package org.prog.session4;

//TODO: Write class Phone with fields brand and color. And method ring (print color and model)
//TODO: Write class PhoneShop where you can buy phone that is not black and iphone
//TODO: PhoneShop must return phone with requested brand and color



class Phone {
    String brand;
    String color;

    public Phone(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void ring() {
        System.out.println("Телефон " + brand + " " + color + " кольору робить: дінь-дінь");
    }
}

class PhoneShop {


    public static boolean isPhoneAvailable(String brand, String color) {
        boolean found = true;

        if (brand.equals("iPhone") || color.equals("black")) {
            found = false;
        }

        return found;
    }

    public Phone buyPhone(String brand, String color) {

        if (isPhoneAvailable(brand, color)) {
            System.out.println("Телефон " + brand + " " + color + " є в магазині");

            Phone phone = new Phone(brand, color);
            return phone;
        }

        System.out.println("Такого телефону немає в магазині");
        return null;
    }
}

public class Main {

    public static void main(String[] args) {

        String s1 = "Samsung";
        String s2 = "Samsung";
        System.out.println(s1.equals(s2));

        PhoneShop shop = new PhoneShop();

        Phone phone1 = shop.buyPhone("Samsung", "blue");
        if (phone1 != null) {
            phone1.ring();
        }

        System.out.println("-----------");

        Phone phone2 = shop.buyPhone("iPhone", "white");
        if (phone2 != null) {
            phone2.ring();
        }

        System.out.println("-----------");

        Phone phone3 = shop.buyPhone("Nokia", "black");
        if (phone3 != null) {
            phone3.ring();
        }
    }
}