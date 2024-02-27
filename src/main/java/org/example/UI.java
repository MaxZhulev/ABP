package org.example;

import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public int getUserID() {
        System.out.print("Введите ваш userID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getDraw() {
        System.out.print("Введите значение Draw: ");
        return scanner.nextLine();
    }

    public void displayErrorMessage(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }
}
