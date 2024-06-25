package com.cloudicia.java22.localeDependent;


import java.text.ListFormat;
import java.util.List;
import java.util.Locale;

public class localeDependent {
    public static void main(String[] args) {
        List<String> list = List.of("Earth", "Wind", "Fire");
        ListFormat formatter = ListFormat.getInstance(Locale.US, ListFormat.Type.STANDARD, ListFormat.Style.FULL);
        System.out.println(formatter.format(list));
    }
}
