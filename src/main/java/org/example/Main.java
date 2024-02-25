package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            UI ui = new UI();
            BarCodeProcessor barCodeProcessor = new BarCodeProcessor();
            DrawingProcessor drawingProcessor = new DrawingProcessor();
            Employees employees = new Employees("C:\\Java\\ExcelFile.xlsm");

            while (true) {
                // Проверка и обработка BarCode
                barCodeProcessor.processBarCode(ui, employees);

                // Затем получаем Drawing
                String inputDrawing = ui.getInput("Введите Drawing: ");
                // Проверка и обработка Drawing
                drawingProcessor.processDrawing(inputDrawing, employees);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
