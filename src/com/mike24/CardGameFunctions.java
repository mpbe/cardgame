package com.mike24;

import java.util.ArrayList;
import java.util.Collections;


public class CardGameFunctions {





    public static void deckBuilder(ArrayList<Card> deckOfCards) {

        deckOfCards.clear();
        for(Suits suit : Suits.values()) {

            for (CardName cardName : CardName.values()) {
                deckOfCards.add(new Card(suit, cardName, cardName.cardValue));

            }
        }

    }

    public static void Shuffle(ArrayList<Card> deckOfCards) {
        Collections.shuffle(deckOfCards);
    }



    public static Card DealCard(ArrayList<Card> deckOfCards) {

    return deckOfCards.get(0);


    }

    public static void RemoveCardFromDeck(ArrayList<Card> deckOfCards) {

        deckOfCards.remove(0);
    }


















}
