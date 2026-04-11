package org.prog.session7;

import java.util.Objects;

public class Car {

    public String color;
    public String plateNumber;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return Objects.equals(car.color, this.color) &&
                    Objects.equals(car.plateNumber, this.plateNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color + plateNumber);
    }

    @Override
    public String toString() {
        return "Car{" + "color=" + color + ", plateNumber=" + plateNumber + '}';
    }
}
