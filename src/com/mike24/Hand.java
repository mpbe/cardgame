package com.mike24;

import java.util.ArrayList;

public class Hand {


    private ArrayList<Card> hand = new ArrayList<Card>();

    public Hand() {

    }



    public void printHand(){
        System.out.println("cards are:");
        System.out.println(hand);

    }

    public int checkHandTotal(){
        int total = 0;
        for (Card card : hand) {
            total = total + card.getCardValue();
        }

        return total;
    }

    public void printHandTotal(){
        int total = 0;
        for (Card card : hand) {
            total = total + card.getCardValue();
        }
        System.out.printf("total is: %d\n", total);

    }

    public void dealCardToHand(Deck deck) {
        Card dealtCard = deck.dealCard();
        hand.add(dealtCard);
        deck.removeCardFromDeck();
    }

   public void clearHand() {
        hand.clear();
   }

}
