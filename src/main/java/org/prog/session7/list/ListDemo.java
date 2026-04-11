package org.prog.session7.list;

import org.prog.session6.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> arrayList2 = new LinkedList<>();

        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("f");

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");

        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        linkedList.add("g");

        for (String s : arrayList) {
            System.out.println(s);
        }

//        arrayList.addAll(linkedList);
//        arrayList.removeAll(linkedList);
//        System.out.println(arrayList.contains("a"));
//        System.out.println("contains all: " + arrayList.containsAll(arrayList2));
//        System.out.println("contains all: " + arrayList.containsAll(linkedList));
//
//        System.out.println(arrayList.size());

//        System.out.println(arrayList.retainAll(arrayList2));
//        System.out.println(arrayList.size());
//        List<String> subList = arrayList.subList(1, 3);
//        System.out.println(subList.size());
//        arrayList.add(1, "d");
//        arrayList.set(2, "e");
//        arrayList.remove("a");
//        arrayList.remove(0);


//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

        //arrayList[0] = "a"
        //arrayList[1] = "b"
        //arrayList[2] = "c"
        //arrayList[3] = "f"
        //arrayList[3+1] = "d"
        //arrayList[4+1] = "e"

        //linkedList -> "a" [start_of_list]-["a"]-["b"]
        //linkedList -> "b" ["a"]-["b"]-["c"]
        //linkedList -> "c" ["b"]-["c"]-["f"]
        //linkedList -> "f" ["c"]-["f"]-["d"]
        //linkedList -> "d" ["f"]-["d"]-["e"]
        //linkedList -> "e" ["d"]-["e"]-[end_of_list]

    }
}
