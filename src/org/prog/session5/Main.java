package org.prog.session5;

import org.prog.session5.inheritance.Car;

//TODO: Write interface IPhone that can call() and unlock();
//TODO: Write Android and Apple classes that implement IPhone
//TODO: Android unlocks by fingerprint Apple unlocks by faceId
//TODO: write method that accepts IPhone and executes unlock() and call();

public class Main {

    /**
     * #############################
     * #############################
     * ###########(String.s)########
     * #############################
     * #############################
     * #########[ints]##############
     * #############################
     * ###############1#############
     */

    private static final String s = "s";
    private static final int i = 1;
    private static final int[] ints = new int[3];
    private static final Car car = new Car("");

    public static void main(String[] args) {
        ints[0] = 10;
        ints[1] = 20;
        ints[2] = 30;
        ints[0] = -100;

        car.color = "asd";
    }
}
