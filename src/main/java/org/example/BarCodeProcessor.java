package org.example;

import java.io.IOException;

public class BarCodeProcessor {
    public void processBarCode(UI ui, Employees employees) throws IOException {
        boolean isBarCodeAccepted = false;

        while (!isBarCodeAccepted) {
            String inputBarCode = ui.getInput("Введите BarCode: ");

            if (employees.isValidBarCode(inputBarCode)) {
                employees.addToHoursBarCode(inputBarCode);
                isBarCodeAccepted = true; // Успешно добавлено
            } else {
                // Обработка ошибки связанной с BarCode
                System.out.println("Ошибка с BarCode. Значение не принято. Повторите ввод.");
            }
        }
    }
}
