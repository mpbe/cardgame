package com.mike24;

import java.util.Scanner;

public class MenuOptions {





    public static void IntroMessage() {
        System.out.println("Welcome to Card Game");
    }

    public static void GetUsername(Scanner scanner) {
        System.out.println("what is your User Name");
        String userName = scanner.nextLine();
        Player player = new Player(userName);
        System.out.printf("hello, %s\n", player.getPlayerName());


    }

    public static void GameSelection(Scanner scanner) {

        System.out.println("pick from one of the games below");

        //this bit could do with changing, i already know you wont like the manual game number in the enum lol
        //but for now i couldnt be bothered typing blackjack every time i wanted to test it

        for (CardGames cardGames : CardGames.values()) {
            System.out.print(cardGames.gameNumber);
            System.out.println(" " + cardGames);
        }

        String gameSelection;
        int gameNumber;

        while (true) {
            try {
                gameSelection = scanner.nextLine();
                gameNumber = Integer.parseInt(gameSelection);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println("please enter the game number");
            }

        }


        //surely theres a more efficient way than what might become a giant if else statement here but i cant
        //think of anything else right now. ill rework this later maybe

        if (gameNumber == CardGames.BLACKJACK.gameNumber) {
            System.out.println("launching Blackjack");
            new Blackjack().BlackjackGame();

        }


    }

    public static boolean checkIfPlayAgain(Scanner scanner) {

        boolean isPlaying = true;

        while (true) {

            System.out.println("play again? y/n");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("y")) {
                System.out.println("okay then! restarting menu");
                break;
            } else if (decision.equalsIgnoreCase("n")) {
                System.out.println("see ya later!");
                isPlaying = false;
                break;
            } else {
                System.out.println("huh? talk some sense man");
            }
        }


        return isPlaying;
    }
}
