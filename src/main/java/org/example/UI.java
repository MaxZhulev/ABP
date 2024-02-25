package org.example;


import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}