package com.mike24;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // object that represents a card. It will hold the information of the individual card

        // store these ina  collection - 52 cards, suits etc

        // what actions does deck of cards need to do (methods draw card eg)
        // how to show what cards you are dealth before you start dealing

        Cards sixDiamond = new Cards("6D", "diamonds", 6);{
            System.out.println(sixDiamond.cardCheck());
        }

        Cards twoClubs = new Cards("2C", "clubs", 2);{
            System.out.println(twoClubs.cardCheck());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("what is your username");
        String userName = scanner.nextLine();
        System.out.printf("hi %s, welcome to scuffedjack. i will eventually come up with a way to deal you some cards", userName);









    }
}

