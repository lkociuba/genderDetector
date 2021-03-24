package com.lukaszkociuba.genderDetector.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameToTokenConverter {
    public String[] splitToTokens(String name, List<String> femaleTokens, List<String> maleTokens) {
        if (name == null || femaleTokens == null || maleTokens == null) {
            throw new NullPointerException("Null value given!");
        }

        if (name.equals("") || name.equals(" ")) {
            throw new RuntimeException("Empty name given!");
        }

        String[] splitName = Arrays.stream(name.split(" "))
                .map(String::trim)
                .toArray(String[]::new);

        List<String> correctSplitName = new ArrayList<>();
        for (String token : splitName) {
            if (!token.equals("")) {
                correctSplitName.add(token);
            }
        }

        return correctSplitName.toArray(String[]::new);
    }
}
