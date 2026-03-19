package org.prog.session5.inheritance;

public class Lorry extends Truck {

    public Lorry(String plateNumber) {
        super(plateNumber);
    }

    @Override
    public void driveThroughCrossroad() {
        System.out.println("Long cars drive to different lane");
    }
}
