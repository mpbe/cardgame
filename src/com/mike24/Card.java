package com.mike24;
import java.util.ArrayList;
import java.util.Scanner;


public class Card {


    private Suits suit;
    private CardName cardname;
    private final int cardValue;


    public Card(Suits suit, CardName cardname, int cardValue) {
        this.suit = suit;
        this.cardname = cardname;
        this.cardValue = cardValue;
    }




    public CardName getCardname() {
        return cardname;
    }

    public void setCardname(CardName cardname) {
        this.cardname = cardname;
    }

    public Suits getSuit() {return suit;}

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public int getCardValue() {
        return cardValue;
    }


    @Override
    public String toString() {
        return getCardname() + " OF " + getSuit();
    }


    ArrayList<Card> listOfCards = new ArrayList<Card>();


}