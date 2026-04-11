package org.prog.session7.map;

import org.prog.session6.Car;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> anotherMap = new HashMap<>();
//
//        map.put("key1", "value1");
//        map.put("key2", "value2");
//        map.put("key4", "value2");
//
//        anotherMap.put("key1", "value3");
//        anotherMap.put("key2", "value4");
//        anotherMap.put("key3", "value5");
//
//        map.putAll(anotherMap);
//        System.out.println(map.size());
//        System.out.println(map.entrySet());

        Map<MyObject, String> map2 = new HashMap<>();
        map2.put(new MyObject(), "value1");
        map2.put(new MyObject(), "value2");
        System.out.println(map2.size());
        System.out.println(map2.get(new MyObject()));
        System.out.println(map2.containsKey(new MyObject()));

        System.out.println(map2.getOrDefault(new MyObject(), "value3"));
//
//        System.out.println(map.get("key1"));
//        System.out.println(map.get("key2"));
//
//        map.put("key1", "value3");
//        System.out.println(">>>>>>>" + map.get("key1"));
//        map.put(null, "value4");
//        map.put(null, "value5");
//        map.put("key3", null);
//
//        map.replace("key6", "value6");
//        System.out.println(map.get("key6"));
//        map.remove("key1", "value4");
//        System.out.println(map.get("key1"));
//
//        Car car = new Car();
//        car.color = "blue";
//
//        Map<String, Car> carsMap = new HashMap<>();
//        carsMap.put("rental_car_1", car);
//        carsMap.put("rental_car_2", car);
//
//        System.out.println(carsMap.get("rental_car_1").color);
//        System.out.println(carsMap.get("rental_car_2").color);
//
//

//        carsMap.put("John", new Car());
//        carsMap.get("John").color = "red";
//        carsMap.get("John").plateNumber = "00001";
//        System.out.println(carsMap.get("John"));
    }
}
