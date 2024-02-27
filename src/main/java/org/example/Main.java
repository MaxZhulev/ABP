package org.example;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        Employees employees = new Employees("C:\\Java\\ExcelFile.xlsx");
        DrawingProcessor drawingProcessor = new DrawingProcessor();
        UserIDProcessor userIDProcessor = new UserIDProcessor();

        int userID = ui.getUserID();
        String draw = ui.getDraw();

        if (userIDProcessor.isValidUserID(userID, employees)) {
            drawingProcessor.processDraw(userID, draw, employees);
        } else {
            ErrorProcessor errorProcessor = new ErrorProcessor();
            errorProcessor.handleInvalidUserID();
        }
    }
}
