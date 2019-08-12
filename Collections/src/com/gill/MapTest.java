package com.gill;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level");
        languages.put("python","interpreted");
        languages.put("Algol","interpreted");
        languages.put("Basic","interpreted");
        languages.put("LISP","interpreted");

        System.out.println(languages.get("Java"));
        languages.put("Java", "a compiled high level2");
        System.out.println(languages.get("Java"));


    }
}
