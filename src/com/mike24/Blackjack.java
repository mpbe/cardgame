package com.mike24;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {


final int BUST = 21;


private Deck deck = new Deck();

ArrayList<Card> playerHand = new ArrayList<Card>();
ArrayList<Card> dealerHand = new ArrayList<Card>();
Scanner scanner = new Scanner(System.in);

public void BlackjackGame() {

    deck.shuffle();
    initialDealToPlayer();
    playersTurn();
    dealersTurn();


}



private void initialDealToPlayer() {

    blackjackDealToPlayer();
    blackjackDealToPlayer();
    printPlayerHand();

}

private void blackjackDealToPlayer() {
    Card dealtCard = deck.DealCard();
    playerHand.add(dealtCard);
    deck.RemoveCardFromDeck();

}

private void playersTurn() {

    boolean isPlaying = true;

    while(isPlaying) {


        String hitOrStand = hitOrStand();


        if (hitOrStand.equalsIgnoreCase("hit")) {

            blackjackDealToPlayer();
            printPlayerHand();
            boolean isBust = checkIfPlayerBust();
            if (isBust) {

                return;
            }


        }
        else {
            System.out.println("standing");
            isPlaying = false;
        }
    }


}

private void printPlayerHand() {
    System.out.println("your cards are");
    System.out.println(playerHand);
    int total = checkPlayerTotal();
    System.out.printf("total is %d\n", total);
}

private String hitOrStand() {



    System.out.println("What is your move?");
    System.out.println("HIT    STAND");


    while(true) {

        String move = scanner.nextLine();
        if ((move.equalsIgnoreCase("hit")) || (move.equalsIgnoreCase("stand"))) {
            return move;
        }  else {
            System.out.println("please enter valid move");
        }
    }
}


private int checkPlayerTotal() {
    int total = 0;

    for (Card card : playerHand) {
        total = total + card.getCardValue();
    }


    return total;


}

private boolean checkIfPlayerBust() {
    boolean isBust = false;
    int total = checkPlayerTotal();
    if (total > BUST) {
        System.out.println("busted!");
        isBust = true;

    }
    return isBust;

}

private void blackjackDealToDealer() {
    Card dealtCard = deck.DealCard();
    dealerHand.add(dealtCard);
    deck.RemoveCardFromDeck();
}

private int checkDealerTotal() {
    int total = 0;
    for (Card card : dealerHand) {
        total = total + card.getCardValue();
    }
    return total;
}

private void printDealerHand(){
    System.out.println("dealer's cards are:");
    System.out.println(dealerHand);
    int total = checkDealerTotal();
    System.out.printf("total is %d\n", total);
    }

private void initialDealToDealer() {
    blackjackDealToDealer();
    blackjackDealToDealer();

}

private boolean compareDealerTotalToPlayer() {

    int playerTotal = checkPlayerTotal();
    int dealerTotal = checkDealerTotal();

    return playerTotal > dealerTotal;



}

private void dealerMove() {


    boolean isPlaying = true;

    while(isPlaying) {
        printDealerHand();

        boolean isBust = checkIfDealerBust();
        if (isBust) {

            return;
        }

        boolean isHitting = compareDealerTotalToPlayer();

        if (isHitting) {
            System.out.println("hitting");
            blackjackDealToDealer();
        } else {
            System.out.println("dealer wins!");
            isPlaying = false;
        }
    }
}

private boolean checkIfDealerBust() {
        boolean isBust = false;
        int total = checkDealerTotal();
        if (total > BUST) {
            System.out.println("busted!");
            System.out.println("player wins!");
            isBust = true;

        }
        return isBust;

    }



private void dealersTurn() {
    initialDealToDealer();

    dealerMove();


}

}


