package org.example;

import java.util.HashMap;
import java.util.Map;

public class Table {
    @TableAnnotation(tableName = "Test table name")
    Map<Integer, String> tableNames = new HashMap<>();

    public Table(Map<Integer, String> tableNames) {
        this.tableNames = tableNames;
    }
}
