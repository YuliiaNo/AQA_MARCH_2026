package org.prog.session6HomeWork;

public class Phone2 {

    String brand;
    String color;

    public Phone2(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {

        if (brand == null || color == null) {
            throw new RuntimeException();
        }

        if (!(obj instanceof Phone2)) {
            return false;
        }

        Phone2 other = (Phone2) obj;

        if (other.brand == null || other.color == null) {
            throw new RuntimeException();
        }

        return brand.equals(other.brand) && color.equals(other.color);
    }

    @Override
    public int hashCode() {

        if (brand == null || color == null) {
            throw new RuntimeException();
        }

        return brand.hashCode() + color.hashCode();
    }
}