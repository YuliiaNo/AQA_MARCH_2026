package org.prog.session3;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        int[] ints = new int[50];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(100);
            System.out.println(ints[i]);
        }

        // 1. Если мы находимся у первого элемента массива - делаем шаг дальше
        // 2. Если мы дошли до последнего числа в массиве и не меняем его местами, сортировка закончена
        // 3. Если число "перед нами" меньше, чем предыдущеее число - надо поменять их местами, и сделать шаг назад

        /**
         66 -> 2
         61 -> 11
         59 -> 11
         79 -> 28
         41 -> 41
         28 -> 56
         56 -> 59
         11 -> 61
         11 -> 66
         2 ->  79
         */

        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("============================================");

//        for (int i = 1; i < ints.length; i++) {
//            if (i == 0) {
//                i++;
//            }
//
//            if (ints[i] < ints[i - 1]) {
//                int temp = ints[i];
//                ints[i] = ints[i - 1];
//                ints[i - 1] = temp;
//                i = i - 2;
//            }
//
//            if (i == ints.length - 1 && ints[i] >= ints[i - 1]){
//                break;
//            }
//        }

        boolean sorted = false;
        int index = 0;

        while (!sorted) {
            sorted = index == ints.length - 1;

            if (index == 0) {
                index++;
            }

            if (ints[index] < ints[index - 1]) {
                int temp = ints[index];
                ints[index] = ints[index - 1];
                ints[index - 1] = temp;
                index--;
                sorted = false;
            } else {
                index++;
            }

            if (index == ints.length - 1 && sorted) {
                break;
            }
        }


        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        //21 [0] i=0
        //11 [1] i=1
        //3
        //4
        //5
        //6
        //7
        //8
        //9 <-
    }
}
