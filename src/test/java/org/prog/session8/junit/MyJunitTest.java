package org.prog.session8.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.Stream;

public class MyJunitTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Open browser my test 1");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Close browser my test 1");
    }

    @Test
    public void myTest1() {
        Random random = new Random();
        int a = random.nextInt(20);
        int b = random.nextInt(20);
        System.out.println(a);
        System.out.println(b);
        Assertions.assertNotEquals(a, b);
    }

    /**
     * Password length >= 8
     * Password length <= 16
     * Password contains special symbols
     * Password must contain numbers
     * Password must contain Upper Case Letter
     * Password must contain Lower Case Letter
     */

    @ParameterizedTest
    @ValueSource(strings = {"password_1", "password_2", "password_3", "password_4"})
    public void myTest2(String password) {
        System.out.println("Testing password " + password);
    }

    @ParameterizedTest
    @MethodSource("source3")
    public void myTest3() {
        System.out.println("Hello JUnit 3!");
    }

    @ParameterizedTest
    @EnumSource(UserRoles.class)
    public void myTest4(UserRoles myEnum) {
        System.out.println("Hello enum " + myEnum.getInternalId());
    }

    @Test
    public void failedTest(){
        throw new RuntimeException("Test failed");
    }

    public static Stream<Arguments> source3() {
        //SQL operation
        //API Calls
        return Stream.of(
                Arguments.of("password_1"),
                Arguments.of("password_2"),
                Arguments.of("password_3"),
                Arguments.of("password_4"),
                Arguments.of("password_5")
        );
    }
}
