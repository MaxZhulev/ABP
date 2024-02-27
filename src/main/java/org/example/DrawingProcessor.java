package org.example;

import java.io.IOException;

public class DrawingProcessor {
    public void processDraw(int userID, String draw, Employees employees) {
        try {
            employees.addToHours(userID, draw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
