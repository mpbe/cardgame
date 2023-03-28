package com.mike24;
import java.util.ArrayList;
import java.util.Scanner;


public class Cards {

    final public int value;
    Suits suit;

    public Cards(int value, Suits suit) {
        this.value = value;
        this.suit = suit;


    }

    //not sure what i would use a getter for here? is there any use for it?
    public int getValue() {

        return value;
    }

    @Override
    public String toString() {
        return value + " OF " + suit;
    }

    //create a list of cards using the i to populate - push and pop in lists/collection
    ArrayList<Cards> listOfCards = new ArrayList<Cards>();

    public ArrayList<Cards> cardBuilder() {

        for (Suits suit : Suits.values()) {
            /* ive done an enhanced for loop here but how would i write this as a
            regular for loop? i ask cos the syntax of enums kinda confuses mee
             */
            for (int i = 0; i < 10; i++) {
                Cards cards = new Cards(i + 2, suit);

                listOfCards.add(cards);
                if (i == 8) {
                    for (int j = 0; j < 3; j++) {
                        listOfCards.add(cards);
                        /*ive done this because i couldnt think of another way to make
                        // the face cards have the same value of 10
                         ace is done in the final i loop. */



                        /* a problem i have though is i want to assign names to the cards
                         (and then use that in the toString method instead of int value)
                         but not sure the best way to do this? was thinking of making a
                         separate enum for names but then it gets messy with how to assign
                         them and suit together. as i said i find enum syntax confusing

                         */

                    }
                }
            }

        }


        return (listOfCards);
    }

    int total = 0;
    int aceCount = 0;

    int deal() {
        System.out.println("your cards are:");


        for (int i = 0; i < 2; i++) {

            System.out.println(listOfCards.get(i));
            total += listOfCards.get(i).value;

            if (listOfCards.get(i).value == 11) {
                aceCount++;
            }

        }
        return total;
    }

    int aiTotal = 0;
    boolean isPlaying = true;

    int bust = 21;



    Scanner scanner = new Scanner(System.in);
    int hitCounter = 2;


    public int play(int total) {


        do {


            while((total > bust) && (aceCount != 0)) {

                total = total - 10;
                aceCount--;


            }
            if (total > bust) {
                System.out.printf("total is %d\n", total);
                System.out.println("busted!");

                System.exit(0);

            }
            StringBuilder aceTotals = new StringBuilder();
            int aceStringBuild = aceCount;
            int totalStringBuild = total;

            while(aceStringBuild != 0) {
                aceTotals.append(" (or ");
                aceTotals.append(totalStringBuild - 10);
                aceTotals.append(")");
                aceStringBuild--;
                totalStringBuild = totalStringBuild - 10;

                /* i realise i dont need this string builder at all now as you can never have more
                 than one ace counting as 11.. but im gonna leave it in cos it was fun and i can
                 edit the bust value for fun later!

                 */
            }

            System.out.printf("total is %d%s\n", total, aceTotals);

            System.out.println("What is your move?");
            System.out.println("HIT    STAND");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("hit")) {

                System.out.println(listOfCards.get(hitCounter));
                total += listOfCards.get(hitCounter).value;


                if (listOfCards.get(hitCounter).value == 11) {
                    aceCount++;
                }
                hitCounter++;


            } else if (move.equalsIgnoreCase("stand")) {
                System.out.println("standing");
                System.out.printf("your total was %d\n", total);
                isPlaying = false;
            } else {
                System.out.println("please enter a valid move");
            }

        } while(isPlaying);

        return total;
    }



    public int aiDeal() {

        for (int i = 0; i < 2; i++) {
            aiTotal += listOfCards.get(hitCounter).value;
            hitCounter++;


        }
        System.out.printf("ai score after deal is %d\n", aiTotal);
        return aiTotal;
    }



    public int aiPlay(int total, int aiTotal) {

        while (aiTotal < total) {
            System.out.println("hitting...");
            aiTotal += listOfCards.get(hitCounter).value;
            hitCounter++;
            System.out.printf("ai score is %d\n", aiTotal);
        }

        if (aiTotal > bust) {
            System.out.println("busted!");
        }

        return aiTotal;
    }
}