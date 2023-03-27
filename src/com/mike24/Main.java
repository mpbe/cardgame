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


        Cards cards = new Cards(1, Suits.CLUBS);

        ArrayList<Cards> listOfCards = cards.cardBuilder();

        Collections.shuffle(listOfCards);
        System.out.println(listOfCards);

        int total = cards.deal();

        total = cards.play(total);

        int aiTotal = cards.aiDeal();

        aiTotal = cards.aiPlay(total, aiTotal);

        if ((total > aiTotal) || (aiTotal > 21)) {
            System.out.println("you win!");
        }
        else {
            System.out.println("you lose");
        }
    }
}


