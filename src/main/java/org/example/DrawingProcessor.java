package org.example;
import java.io.IOException;

public class DrawingProcessor {
    public void processDrawing(String inputDrawing, Employees employees) throws IOException {
        if (!employees.isValidBarCode(inputDrawing)) {
            employees.addToHoursDrawing(inputDrawing);
        } else {
            // Обработка ошибки связанной с Drawing
            System.out.println("Ошибка с Drawing. Значение не принято.");
        }
    }
}