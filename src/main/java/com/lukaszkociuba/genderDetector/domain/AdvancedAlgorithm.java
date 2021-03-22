package com.lukaszkociuba.genderDetector.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedAlgorithm {

    private final List<String> femaleTokenList = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokenList = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    private int countEqualTokens(String[] tokenedName, List<String> nameList) {
        int equalTokens = 0;
        for (var nameToken : tokenedName) {
            for (var femaleToken : nameList) {
                if (nameToken.equals(femaleToken)) {
                    equalTokens += 1;
                }
            }
        }
        return equalTokens;
    }

    public String predictGenderByAllTokens(String[] tokenedName) {
        if (tokenedName == null) {
            throw new NullPointerException("Null value given!");
        }

        int countFemaleTokens = countEqualTokens(tokenedName, femaleTokenList);
        int countMaleTokens = countEqualTokens(tokenedName, maleTokenList);

        if (countFemaleTokens != 0 && countFemaleTokens > countMaleTokens) {
            return "FEMALE";
        } else if (countMaleTokens != 0 && countMaleTokens > countFemaleTokens) {
            return "MALE";
        } else {
            return "INCONCLUSIVE";
        }
    }
}
