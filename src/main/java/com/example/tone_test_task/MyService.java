package com.example.tone_test_task;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/*
* Service with one method accepts string and returns hashmap of element frequency
* */
@Service
class MyService {

    public Map<Character, Integer> getFrequencyMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        if (string.isEmpty()) {
            return map;
        } else if (string.length() == 1) {
            map.put(string.charAt(0), 1);
            return map;
        }
        int len = 1;
        char curr = string.charAt(0);

        for (int i = 1; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c != curr) {
                if (!map.containsKey(curr)) {
                    map.put(curr, len);
                } else {
                    map.put(curr, Math.max(map.get(curr), len));
                }
                len = 1;
                curr = c;
            } else {
                len++;
            }
        }
        if (!map.containsKey(curr)) {
            map.put(curr, len);
        } else {
            map.put(curr, Math.max(map.get(curr), len));
        }
        return map;
    }
}
