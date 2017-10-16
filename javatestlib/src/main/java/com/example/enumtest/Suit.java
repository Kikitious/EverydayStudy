package com.example.enumtest;


/**
 * Created by du on 17/10/11.
 */

public enum Suit {
    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3),
    SPADES(4);

    private int type;

    Suit(int type) {
        this.type = type;
    }

    public static void main(String args[]) {
        Suit clubs = Suit.CLUBS;
        System.out.println(clubs.compareTo(Suit.SPADES));//-3 注：0减去3
        System.out.println(clubs.equals(Suit.DIAMONDS));//false
        System.out.println(clubs.hashCode());//1360875712 注：不同的人不一样的值
        System.out.println(clubs.getDeclaringClass());//class com.example.enumtext.Suit
        System.out.println(clubs.name());//CLUBS
        System.out.println(clubs.toString());//CLUBS
        System.out.println(clubs.ordinal());//0
        try {
            System.out.println(clubs.clone());
        } catch (CloneNotSupportedException e) {//抛出CloneNotSupportedException异常
            e.printStackTrace();
        }
    }
}

class sub {

        }
