package org.prog.session5.inheritance;

import org.prog.session5.sub.Child;
import org.prog.session5.sub.Parent;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(null);
        car.goTo("destination");

        Crossover crossover = new Crossover("AA0110AA");
        crossover.color = "red";
        crossover.goTo("destination");
        crossover.switchToFullDrive();

        Truck truck = new Truck("AA0110AA");
        truck.color = "black";
        truck.driveThroughCrossroad();

        Lorry lorry = new Lorry("AA0110AA");
        lorry.driveThroughCrossroad();

        RoadTrain roadTrain = new RoadTrain("AA0110AA");
        roadTrain.driveThroughCrossroad();

    }
}
