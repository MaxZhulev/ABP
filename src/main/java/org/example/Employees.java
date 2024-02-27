package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Employees {
    private final String filePath;

    public Employees(String filePath) {
        this.filePath = filePath;
    }

    public boolean isValidUserID(int userID) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Employees");

            for (Row row : sheet) {
                Cell cell = row.getCell(1); // Первый столбец (индекс 0)
                if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC) {
                    if (cell.getNumericCellValue() == userID) {
                        return true; // userID найден, возвращаем true
                    }
                }
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return false; // userID не найден, возвращаем false
    }

    public void addToHours(int userID, String draw) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet hoursSheet = workbook.getSheet("Hours");

            int lastRow = hoursSheet.getLastRowNum();
            Row row = hoursSheet.createRow(lastRow + 1);

            // Устанавливаем значение userID
            Cell userIDCell = row.createCell(0, CellType.NUMERIC);
            userIDCell.setCellValue(userID);

            // Устанавливаем значение draw
            Cell drawCell = row.createCell(1, CellType.STRING);
            drawCell.setCellValue(draw);

            // Устанавливаем значение времени и даты
            Cell timeCell = row.createCell(2, CellType.STRING);
            timeCell.setCellValue(getCurrentDateTime());

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
    private String getCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
