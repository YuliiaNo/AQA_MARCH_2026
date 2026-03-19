package org.prog.session5.poly;

public class Mazda implements ICar, ITransport {
    @Override
    public void turnLeft() {
        System.out.println("Mazda turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("Mazda turning right");
    }

    @Override
    public void pickPassengers() {
        System.out.println("Mazda picking passengers");
    }
}
