package com.example.enumtest;

import javax.swing.text.View;

/**
 * Created by du on 17/10/11.
 */

class Test {

    public static void main(String args[]) {
        test();
    }

    public static int test() {
        try {
            System.out.println("try");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 0;
        } finally {
            System.out.println("finally");
        }
    }


}



