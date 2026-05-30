package org.prog.session15;

import org.testng.annotations.Test;

public class PropsDemo {

    @Test
    public void demo() {
        System.getProperties().forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });

    }
}
