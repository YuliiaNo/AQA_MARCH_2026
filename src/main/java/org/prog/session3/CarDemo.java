package org.prog.session3;

public class CarDemo {

    /**
     * #################################
     * #################################
     * #################################
     * ########(Car.color)############## <---- aliceCar, redCar
     * #################################
     * ############(Car)################ <---- bobCar
     * #################################
     * #################################
     * #################################
     */

    public static void main(String[] args) {
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Car redCar = aliceCar;

        aliceCar.color = "Red";
        bobCar.color = "Blue";

        System.out.println("Someone has " + redCar.color + " car");

        System.out.println("Alice has " + aliceCar.color + " car");
        System.out.println("Bob has " + bobCar.color + " car");

        aliceCar.goTo("Kyiv");
        bobCar.goTo("Lviv");
    }
}
