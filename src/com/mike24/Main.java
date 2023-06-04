package com.mike24;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("what is your username");
        String userName = scanner.nextLine();
        System.out.printf("hi %s, welcome to scuffedjack\n", userName);

        ArrayList<Card> listOfCards = new ArrayList<Card>();
        int total = 0;
        int aceCount = 0;
        int dealCounter = 0;
        int BUST = 21;

        BlackjackMethods blackjackMethods = new BlackjackMethods();

        BlackjackMethods.deckBuilder(listOfCards);

        Collections.shuffle(listOfCards);
        System.out.println(listOfCards);

        int total2 = blackjackMethods.deal(listOfCards, total, dealCounter, aceCount);
        System.out.println(total);
        System.out.println(dealCounter);
        BlackjackMethods.play(listOfCards, total2, dealCounter, BUST, aceCount, scanner);

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
}


