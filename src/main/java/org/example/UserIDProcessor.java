package org.example;

import java.io.IOException;

public class UserIDProcessor {
    public boolean isValidUserID(int userID, Employees employees) {
        try {
            return employees.isValidUserID(userID);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
