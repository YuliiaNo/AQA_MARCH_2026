package org.prog.session4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

    private CarService carService = new CarService();

    @Test
    public void testCarPaint(){
        Car car = new Car("asdasd");
        carService.paintCar("black", car);
        Assertions.assertEquals("black", car.color);
    }
}
