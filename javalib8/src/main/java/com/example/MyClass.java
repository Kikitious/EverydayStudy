package com.example;

public class MyClass {


    public static void main(String[] args) {
        int number = 20;

        int rounded = number >= 30 ? 30 :
                (rounded = Integer.highestOneBit(number)) != 0 ?
                        (Integer.bitCount(number) > 1) ? rounded << 1 : rounded
                        : 1;

        System.out.println(rounded);

        int round = 0;
        if (number >= 30) {
            round = 30;
        } else {
            round = Integer.highestOneBit(number);//取最高位 比如20 = 0001 0100，最左边的1代表16
            if (round != 0) {
                if (Integer.bitCount(number) > 1) {//取补码，正整数的补码是本身，负整数的补码需要取反加一
                    round = round << 1;
                }
            } else {
                round = 1;
            }
        }
        System.out.println(round);

    }

}
