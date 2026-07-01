package org.example.map.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        map.get(2);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :  " + entry.getValue());
        }
    }

}
