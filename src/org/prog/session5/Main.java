package org.prog.session5;

import org.prog.session5.inheritance.Car;

//TODO: Write interface IPhone that can call() and unlock();
//TODO: Write Android and Apple classes that implement IPhone
//TODO: Android unlocks by fingerprint Apple unlocks by faceId
//TODO: write method that accepts IPhone and executes unlock() and call();


interface IPhone {

    void call();

    void unlock();
}

class Android implements IPhone {

    public void call() {
        System.out.println("Android calling...");
    }

    public void unlock() {
        System.out.println("Android unlocked by fingerprint");
    }
}

class Apple implements IPhone {

    public void call() {
        System.out.println("Apple calling...");
    }

    public void unlock() {
        System.out.println("Apple unlocked by faceId");
    }
}

public class Main {

    public static void main(String[] args) {

        Android android = new Android();
        Apple apple = new Apple();

        phoneActions(android);
        phoneActions(apple);
    }

    public static void phoneActions(IPhone iPhone) {
        iPhone.unlock();
        iPhone.call();
    }
}