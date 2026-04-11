package org.prog.session5.poly;

public class Ford implements ICar {

    public void goTo(String destination) {
        goTo(destination, "current place");
    }

    public void goTo(String destination, String from) {
        goTo(destination, from, "nowhere");
    }

    public void goTo(String destination, String from, String through) {
        System.out.println("Going from " + from + " to " + destination + " stopping at " + through);
    }

    @Override
    public void turnLeft() {
        System.out.println("Ford turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("Ford turning right");
    }
}
