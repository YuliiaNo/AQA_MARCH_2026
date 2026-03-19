package org.prog.session5.inheritance;

public class Crossover extends Car {

    public Crossover(String plateNumber) {
        super(plateNumber);
        System.out.println("Constructing crossover is finished");
    }

    public void switchToFullDrive() {
        System.out.println("Switching to full drive");
    }
}
