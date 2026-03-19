package org.prog.session5.sub;

public class ProtectedDemo {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.defaultValue = "asd";
        parent.value = parent.defaultValue;
    }
}
