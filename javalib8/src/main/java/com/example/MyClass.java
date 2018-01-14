package com.example;

public class MyClass {
    private static ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
//        test();
//        System.out.println(binarySearch(new int[]{2, 4, 5, 8, 17, 24, 44, 52}, 6, 6));
//        System.out.println(~3);
//        System.out.println(~4);
//        System.out.println(~5);
//
//        System.out.println(Integer.parseInt("0000000000000100", 2));

        mBooleanThreadLocal.set(true);
        System.out.println(mBooleanThreadLocal.get());

        new Thread("Thread2") {
            @Override
            public void run() {
                super.run();
                mBooleanThreadLocal.set(false);
                System.out.println("Thread2 " + mBooleanThreadLocal.get());
            }
        }.start();

        new Thread("Thread3") {
            @Override
            public void run() {
                super.run();
                mBooleanThreadLocal.set(true);
                System.out.println("Thread3 " + mBooleanThreadLocal.get());
            }
        }.start();

    }

    private static int step(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        else return step(n - 1) + step(n - 2);
    }

    private static void test() {
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


    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

}
