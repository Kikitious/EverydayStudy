package com.example.enumtest;

/**
 * Created by du on 17/10/11.
 */

class Base {
    private void amethod(int iBase) {
        System.out.println("Base.amethod");
    }
}


class Over extends Base {
    public static void main(String args[]) {
        Over o = new Over();
        int iBase = 0 ;
        o.amethod(iBase) ;

        int i = 9 ;
        switch(i) {
            default:
                System.out.println("default");
            case 0 :
                System.out.println("zero");
                break ;
            case 1 : System.out.println("one");
            case 2 : System.out.println("two");
        }
    }
    public void amethod(int iOver) {
        System.out.println("Over.amethod");
    }
}

 class MyClass {
    public static void main(String arguments[])     {
        amethod(arguments);
    }
    public static void amethod(String[] arguments){
        System.out.println(arguments);
        System.out.println(arguments[1]);
    }
}
