package org.example;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> tableNames = new HashMap<>();

        tableNames.put(1, "Name 01");
        tableNames.put(2, "Name 02");

        Table table = new Table(tableNames);

        Field[] fields = table.getClass().getDeclaredFields();
        for (Field field: fields){
            if(field.isAnnotationPresent(TableAnnotation.class)){
                String tableName = field.getAnnotation(TableAnnotation.class).tableName();
                System.out.println(tableName);
            }
        }

    }
}