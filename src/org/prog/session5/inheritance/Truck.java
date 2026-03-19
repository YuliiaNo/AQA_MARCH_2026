package org.prog.session5.inheritance;

public class Truck extends Crossover {
    public Truck(String plateNumber) {
        super(plateNumber);
    }

    public void addCargo() {
        System.out.println("Adding cargo");
    }
}
