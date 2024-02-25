package org.example;

// Класс для обработки ошибок
public class ErrorProcessor {
    // Метод для обработки ошибок при невалидном BarCode
    public void handleInvalidBarCode() {
        System.out.println("Invalid BarCode. Please try again.");
    }

    // Метод для обработки ошибок при невалидном Drawing
    public void handleInvalidDrawing() {
        System.out.println("Invalid Drawing. Please try again.");
    }
}
