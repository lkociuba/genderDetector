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

        var firstTokenOfName = tokenedName[0];

        for (String femaleToken : femaleTokenList) {
            if (femaleToken.equals(firstTokenOfName)) {
                return "FEMALE";
            }
        }

        for (String maleToken : maleTokenList) {
            if (maleToken.equals(firstTokenOfName)) {
                return "MALE";
            }
        }

        return "INCONCLUSIVE";
    }
}
