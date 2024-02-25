package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class Employees {

    private final String filePath;

    public Employees(String filePath) {
        this.filePath = filePath;
    }

    public boolean isValidBarCode(String inputBarCode) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet("Employees");

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell = row.getCell(1); // Второй столбец (индекс 1)
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    if (cell.getStringCellValue().equals(inputBarCode)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addToHoursBarCode(String inputBarCode) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet hoursSheet = workbook.getSheet("Hours");

            // Проверяем, что введенный BarCode существует в листе Employees
            if (!isValidBarCode(inputBarCode)) {
                System.out.println("Ошибка с BarCode. Значение не принято.");
                return;
            }

            // Находим последнюю строку в столбце BarCode листа "Hours"
            int lastRow = hoursSheet.getLastRowNum();
            Row row = hoursSheet.createRow(lastRow + 1); // Создаем новую строку

            // Создаем ячейку во втором столбце (индекс 1) и устанавливаем значение BarCode
            Cell cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(inputBarCode);

            // Записываем изменения в файл
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }
}
