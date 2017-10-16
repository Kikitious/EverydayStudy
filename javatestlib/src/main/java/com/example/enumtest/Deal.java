package com.example.enumtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by du on 17/10/11.
 */

public class Deal {

    public static void main(String args[]) {
        int numHands = 4;
        int cardsPerHand = 5;
        List<Card> deck = Card.newDeck();
        Collections.shuffle(deck);
        for (int i = 0; i < numHands; i++) {
            System.out.println(deck);
            System.out.println(deck.size());
            System.out.println(dealHand(deck, cardsPerHand));
        }
    }

    /**
     * Returns a new ArrayList consisting of the last n elements of deck, which are removed from deck.
     * The returned list is sorted using the elements’ natural ordering.
     */
    public static <E extends Comparable<E>> ArrayList<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        ArrayList<E> hand = new ArrayList<E>(handView);
        handView.clear();
        Collections.sort(hand);
        return hand;
    }
}
