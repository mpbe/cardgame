package com.mike24;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackMethods {



    public static void deckBuilder(ArrayList<Card> listOfCards) {

        for(Suits suit : Suits.values()) {

            for (CardName cardName : CardName.values()) {
                listOfCards.add(new Card(suit, cardName, cardName.cardValue));

            }
        }

    }





    public static int deal(ArrayList<Card> listOfCards, int dealCounter, int total, int aceCount) {

        System.out.println("your cards are:");


        for (int i = 0; i < 2; i++) {

            System.out.println(listOfCards.get(i));
            total += listOfCards.get(i).getCardValue();

            if (listOfCards.get(i).getCardValue() == 11) {
                aceCount++;
            }
            dealCounter++;
        }
        System.out.println(total);
        System.out.println(dealCounter);
        return total;
    }

    int aiTotal = 0;






    Scanner scanner = new Scanner(System.in);








    public static void play(ArrayList<Card> listOfCards, int total, int dealCounter, int BUST, int aceCount, Scanner scanner) {

        boolean isPlaying = true;

        do {

            // if you are bust but have aces then subtract 10 from total to essentially
            // turn the ace value to 1
            while((total > BUST) && (aceCount != 0)) {

                total = total - 10;
                aceCount--;


            }

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

            System.out.printf("\ntotal is %d%s\n\n", total, aceTotals);

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


}
