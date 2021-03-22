package com.lukaszkociuba.genderDetector.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleAlgorithm {

    private final List<String> femaleTokenList = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokenList = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    public String predictGenderByFirstTokenOnly(String[] tokenedName) {
        if (tokenedName == null) {
            throw new NullPointerException("Null value given!");
        }

        String result;
        var firstTokenOfName = tokenedName[0];

        for (String fameleToken : femaleTokenList) {
            if (fameleToken.equals(firstTokenOfName)) {
                result = "FEMALE";
                return result;
            }
        }

        for (String maleToken : maleTokenList) {
            if (maleToken.equals(firstTokenOfName)) {
                result = "MALE";
                return result;
            }
        }

        result = "INCONCLUSIVE";
        return result;
    }
}
