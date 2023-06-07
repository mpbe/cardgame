package com.mike24;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MenuOptions.IntroMessage();
        MenuOptions.GetUsername(scanner);
        MenuOptions.GameSelection(scanner);






    }
}


