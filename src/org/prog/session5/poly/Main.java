package org.prog.session5.poly;

public class Main {

    public static void main(String[] args) {
        Ford ford = new Ford();
        Mazda mazda = new Mazda();

        ford.goTo("Lviv");
        ford.goTo("Lviv", "Kyiv");
        ford.goTo("Lviv", "Kyiv", "Zhytomyr");

        carDirections(ford);
        carDirections(mazda);
    }

    public static void carDirections(ICar iCar) {
        iCar.turnLeft();
        iCar.turnRight();
    }
}
