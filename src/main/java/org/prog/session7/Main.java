package org.prog.session7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO: Write collection where each unique phone may have any number of non-unique contact names

public class Main {

    public static void main(String[] args) {
        //One person may own any number of unique cars
        Map<String, Set<Car>> carOwners = new HashMap<>();
        carOwners.put("John", new HashSet<>());
        carOwners.put("Bob", new HashSet<>());

        carOwners.get("John").add(generateCar("red", "00001"));
        carOwners.get("John").add(generateCar("blue", "00002"));

        carOwners.get("Bob").add(generateCar("green", "00003"));
        carOwners.get("Bob").add(generateCar("yellow", "00004"));
    }

    public static Car generateCar(String color, String plateNumber) {
        Car car = new Car();
        car.color = color;
        car.plateNumber = plateNumber;
        return car;
    }
}
