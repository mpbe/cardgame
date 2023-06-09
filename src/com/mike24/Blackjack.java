package com.mike24;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {


static int BUST = 21;




public static void BlackjackGame() {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Card> deckOfCards = new ArrayList<Card>();
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> dealerHand = new ArrayList<Card>();




    CardGameFunctions.deckBuilder(deckOfCards);
    CardGameFunctions.Shuffle(deckOfCards);
    System.out.println(deckOfCards);

    initialDeal(deckOfCards, playerHand);

    PlayersTurn(deckOfCards, playerHand);


}



public static void initialDeal(ArrayList<Card> deckOfCards, ArrayList<Card> playerHand) {

    BlackjackDeal(deckOfCards, playerHand);
    BlackjackDeal(deckOfCards, playerHand);
    PrintHand(playerHand);

}

public static void BlackjackDeal(ArrayList<Card> deckOfCards, ArrayList<Card> playerHand) {
    Card dealtCard = CardGameFunctions.DealCard(deckOfCards);
    playerHand.add(dealtCard);
    CardGameFunctions.RemoveCardFromDeck(deckOfCards);

}

public static void PlayersTurn(ArrayList<Card> deckOfCards, ArrayList<Card> playerHand) {

    boolean isPlaying = true;

    while(isPlaying) {


        String hitOrStand = HitOrStand(new Scanner(System.in), playerHand, deckOfCards);


        if (hitOrStand.equalsIgnoreCase("hit")) {

            BlackjackDeal(deckOfCards, playerHand);
            PrintHand(playerHand);
            boolean isBust = CheckIfBust(playerHand, BUST);
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

public static void PrintHand(ArrayList<Card> playerHand) {
    System.out.println("your cards are");
    System.out.println(playerHand);
    int total = CheckTotal(playerHand);
    System.out.printf("total is %d\n", total);
}

public static String HitOrStand(Scanner scanner, ArrayList<Card> playerHand, ArrayList<Card> deckOfCards) {



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


public static int CheckTotal(ArrayList<Card> playerHand) {
    int total = 0;

    for (Card card : playerHand) {
        total = total + card.getCardValue();
    }


    return total;


}

public static boolean CheckIfBust(ArrayList<Card> playerHand, int BUST) {
    boolean isBust = false;
    int total = CheckTotal(playerHand);
    if (total > BUST) {
        System.out.println("busted!");
        isBust = true;

    }
    return isBust;

}





//ignore everything under here its the old code i used, im checking it for reference sometimes
    //but eventually it will be deleted




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
