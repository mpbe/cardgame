package com.mike24;

import java.util.Scanner;

public class Blackjack {


final int BUST = 21;


private Deck deck = new Deck();

private Hand playerHand = new Hand();
private Hand dealerHand = new Hand();


Scanner scanner = new Scanner(System.in);


public void blackjackGame() {

    deck.shuffle();
    playersTurn();
    dealersTurn();


}



private void initialDealToPlayer() {

    Card dealtCard = deck.dealCard();
    playerHand.dealCardToHand(dealtCard);
    dealtCard = deck.dealCard();
    playerHand.dealCardToHand(dealtCard);
    playerHand.printHand();
    playerHand.printHandTotal();

}


private void playersTurn() {

    initialDealToPlayer();

    boolean isPlaying = true;

    while(isPlaying) {


        String hitOrStand = hitOrStand();


        if (hitOrStand.equalsIgnoreCase("hit")) {

            Card dealtCard = deck.dealCard();
            playerHand.dealCardToHand(dealtCard);
            playerHand.printHand();
            playerHand.printHandTotal();
            boolean isBust = checkIfPlayerBust();
            if (isBust) {
                System.out.println("busted!");
                return;
            }


        }
        else {
            System.out.println("standing");
            isPlaying = false;
        }
    }


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


private boolean checkIfPlayerBust() {
    boolean isBust = false;
    int total = playerHand.checkHandTotal();
    if (total > BUST) {

        isBust = true;

    }
    return isBust;

}




// now on to the dealer code





private void initialDealToDealer() {
    Card dealtCard = deck.dealCard();
    dealerHand.dealCardToHand(dealtCard);
    dealtCard = deck.dealCard();
    dealerHand.dealCardToHand(dealtCard);
    dealerHand.printHand();
    dealerHand.printHandTotal();

}

private boolean compareDealerTotalToPlayer() {

    int playerTotal = playerHand.checkHandTotal();
    int dealerTotal = dealerHand.checkHandTotal();

    return playerTotal > dealerTotal;



}

private void dealerMove() {


    boolean isPlaying = true;

    while(isPlaying) {


        boolean isBust = checkIfDealerBust();
        if (isBust) {

            return;
        }

        boolean isHitting = compareDealerTotalToPlayer();

        if (isHitting) {
            System.out.println("hitting");
            Card dealtCard = deck.dealCard();
            dealerHand.dealCardToHand(dealtCard);
            dealerHand.printHand();
            dealerHand.printHandTotal();
        } else {
            System.out.println("dealer wins!");
            isPlaying = false;
        }
    }
}

private boolean checkIfDealerBust() {
        boolean isBust = false;
        int total = dealerHand.checkHandTotal();
        if (total > BUST) {
            System.out.println("busted!");
            System.out.println("player wins!");
            isBust = true;

        }
        return isBust;

    }



private void dealersTurn() {

    boolean isBust = checkIfPlayerBust();
    if (isBust) {
        System.out.println("dealer wins!");
        return;
    }

    initialDealToDealer();

    dealerMove();


}

}


