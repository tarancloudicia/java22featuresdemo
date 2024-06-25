package com.cloudicia.java22.unamed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnnamedVariablesDemo {
    public static void main(String[] args) {
        unnamedInException();
        unnamedInList();
        unnamedInString();
        unnamedInMap();
    }

    private static void unnamedInException() {
        System.out.println("Java 22 Unnamed Variables Feature Demo");
        String str = "demoString";
        try {
            int _ = Integer.parseInt(str);
        } catch (NumberFormatException _) {
            System.err.printf("%s is not a number%n", str);
        }
    }

    private static void unnamedInList() {
        List<String> names = List.of("t1", "t2", "t3", "t4");

        for(String _: names) {
            System.out.println("here is loop");
        }
    }

    private static void unnamedInString() {
        String _ = "manoj";
        System.out.println("This is main class");
    }

    private static void unnamedInMap() {
        Map<String, String> map = new HashMap<>();
        map.put("t1", "t1");
        map.forEach((_, _) -> System.out.println("Using unnamed Parameters"));
    }
}
