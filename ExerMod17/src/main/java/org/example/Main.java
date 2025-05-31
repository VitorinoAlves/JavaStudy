package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        @TableAnnotation(tableName = "Test table name")
        Map<Integer, String> tableNames = new HashMap<>();
    }
}