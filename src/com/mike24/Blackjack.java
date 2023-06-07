package com.mike24;

import com.sun.tools.jdeprscan.scan.Scan;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {







public static void Blackjack() {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Card> deckOfCards = new ArrayList<Card>();
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> dealerHand = new ArrayList<Card>();

    int total = 0;
    int aceCount = 0;
    int dealCounter = 0;
    int BUST = 21;



    CardGameFunctions.deckBuilder(deckOfCards);
    CardGameFunctions.Shuffle(deckOfCards);
    System.out.println(deckOfCards);

    firstDeal(deckOfCards, playerHand);
    System.out.println("your cards are");
    System.out.println(playerHand);
    String move = playerTurn(scanner);


}



public static void firstDeal(ArrayList<Card> deckOfCards, ArrayList<Card> playerHand) {
    Card dealtCard = CardGameFunctions.DealCard(deckOfCards);
    playerHand.add(dealtCard);
    CardGameFunctions.RemoveCardFromDeck(deckOfCards);
    dealtCard = CardGameFunctions.DealCard(deckOfCards);
    playerHand.add(dealtCard);
    CardGameFunctions.RemoveCardFromDeck(deckOfCards);

}

public static String playerTurn(Scanner scanner) {
    System.out.println("What is your move?");
    System.out.println("HIT    STAND");
    String move = scanner.nextLine();

    while(true) {

        if ((move.equalsIgnoreCase("hit")) || (move.equalsIgnoreCase("stand"))) {
            return move;
        }  else {
            System.out.println("please enter valid move");
        }
    }
}





    public static void play(ArrayList<Card> listOfCards, int total, int dealCounter, int BUST, int aceCount, Scanner scanner) {

        boolean isPlaying = true;

        do {

            // if you are bust but have aces then subtract 10 from total to essentially
            // turn the ace value to 1
            /*while((total > BUST) && (aceCount != 0)) {

                total = total - 10;
                aceCount--;


            }
*/
            // then if bust end program there
            if (total > BUST) {
                System.out.printf("total is %d\n", total);
                System.out.println("busted!");

                System.exit(0);

            }

            /* technically this is overkill as a with bust value of 21 you can only ever have one
               ace that has a value of 11, but you can change the bust value to whatever using this
               and the string builder will print accurately what your values are. to be honest i
               just saw your string builder in currencyConverter and wanted to play around with it lol
             */


            StringBuilder aceTotals = new StringBuilder();
            int aceStringBuild = aceCount;
            int totalStringBuild = total;

            while(aceStringBuild != 0) {
                aceTotals.append(" (or ");
                aceTotals.append(totalStringBuild - 10);
                aceTotals.append(")");
                aceStringBuild--;
                totalStringBuild = totalStringBuild - 10;


        }

        System.out.printf("\ntotal is %d%s\n\n", total);

        System.out.println("What is your move?");
        System.out.println("HIT    STAND");
        String move = scanner.nextLine();

        if (move.equalsIgnoreCase("hit")) {

            System.out.println(listOfCards.get(dealCounter));
            total += listOfCards.get(dealCounter).getCardValue();


            if (listOfCards.get(dealCounter).getCardValue() == 11) {
                aceCount++;
            }
            dealCounter++;


        } else if (move.equalsIgnoreCase("stand")) {
            System.out.println("standing");
            System.out.printf("your total was %d\n\n", total);
            isPlaying = false;
        } else {
            System.out.println("please enter a valid move");
        }

    } while(isPlaying);


}


/*
    public int aiDeal() {



        for (int i = 0; i < 2; i++) {
            aiTotal += listOfCards.get(hitCounter).getValue();
            System.out.println(listOfCards.get(hitCounter));
            hitCounter++;


        }
        System.out.printf("ai score after deal is %d\n", aiTotal);
        return aiTotal;
    }



    public int aiPlay(int total, int aiTotal) {

        while (aiTotal < total) {
            System.out.println("hitting...");
            aiTotal += listOfCards.get(hitCounter).getValue();
            System.out.println(listOfCards.get(hitCounter));
            hitCounter++;
            System.out.printf("ai score is %d\n", aiTotal);
        }

        if (aiTotal > bust) {
            System.out.println("busted!");
        }

        return aiTotal;
    }
    */

        /*
        System.out.println("ai card being dealt");

        int aiTotal = blackjackMethods.aiDeal();

        aiTotal = blackjackMethods.aiPlay(total, aiTotal);

        if ((total > aiTotal) || (aiTotal > blackjackMethods.bust)) {
            System.out.println("you win!");
        }
        else {
            System.out.println("you lose");
        }

         */

}
