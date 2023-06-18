package com.mike24;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deckOfCards = new ArrayList<Card>();


    public Deck() {



        for(Suits suit : Suits.values()) {

            for (CardName cardName : CardName.values()) {
                deckOfCards.add(new Card(suit, cardName, cardName.cardValue));

            }
        }
    }


    public void shuffle() {
        Collections.shuffle(deckOfCards);
    }



    public Card DealCard() {

        return deckOfCards.get(0);


    }

    public void RemoveCardFromDeck() {

        deckOfCards.remove(0);
    }
}
