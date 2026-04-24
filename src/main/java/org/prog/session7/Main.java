// package org.prog.session7;

// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;

//public class Main {

//    public static void main(String[] args) {
        //One person may own any number of unique cars
 //       Map<String, Set<Car>> carOwners = new HashMap<>();
 //       carOwners.put("John", new HashSet<>());
 //       carOwners.put("Bob", new HashSet<>());

//     carOwners.get("John").add(generateCar("red", "00001"));
//      carOwners.get("John").add(generateCar("blue", "00002"));

//      carOwners.get("Bob").add(generateCar("green", "00003"));
//      carOwners.get("Bob").add(generateCar("yellow", "00004"));
//  }

//  public static Car generateCar(String color, String plateNumber) {
//      Car car = new Car();
//       car.color = color;
//       car.plateNumber = plateNumber;
//       return car;
//   }
// }

//TODO: Write collection where each unique phone may have any number of non-unique contact names

package org.prog.session7;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, ArrayList<String>> phoneContacts = new HashMap<>();

        phoneContacts.put("+123456789", new ArrayList<>());
        phoneContacts.put("+987654321", new ArrayList<>());

        phoneContacts.get("+123456789").add(generateName("John"));
        phoneContacts.get("+123456789").add(generateName("John")); // duplicates OK
        phoneContacts.get("+123456789").add(generateName("Alice"));

        phoneContacts.get("+987654321").add(generateName("Bob"));
        phoneContacts.get("+987654321").add(generateName("Bob"));
        phoneContacts.get("+987654321").add(generateName("Jack"));
    }

    private static String generateName(String name) {
        return name;
            }
}
