package org.prog.session7.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("value1");
        set.add("value2");
        set.add("value3");
        set.add("value4");
        set.add("value5");

//        for (String s : set) {
//            System.out.println(s);
//        }

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
