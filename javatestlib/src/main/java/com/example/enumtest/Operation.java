package com.example.enumtest;

/**
 * Created by du on 17/10/11.
 */

public enum Operation {
    PLUS {
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDED_BY {
        @Override
        double eval(double x, double y) {
            return x / y;
        }
    };

    abstract double eval(double x, double y);

    double getValue() {
        return 2.0;
    }

    public static void main(String args[]) {
        double x = 2.0;
        double y = 4.0;
        for (Operation o : Operation.values()) {
            System.out.println(x + " " + o + " " + y + " = " + o.eval(x, y));
        }
    }




}
