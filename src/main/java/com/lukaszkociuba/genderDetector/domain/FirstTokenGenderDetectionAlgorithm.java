package com.lukaszkociuba.genderDetector.domain;

import java.util.List;

public class FirstTokenGenderDetectionAlgorithm implements GenderDetectionAlgorithm {

    @Override
    public String detectGender(String name, List<String> femaleTokens, List<String> maleTokens) {
        if (name == null || femaleTokens == null || maleTokens == null) {
            throw new NullPointerException("Null value given!");
        }

        NameToTokenConverter nameToTokenConverter = (name1 -> name1.split("\\s"));
        var tokenedName = nameToTokenConverter.splitNameIntoTokens(name);
        var firstTokenOfName = tokenedName[0];

        for (var femaleToken : femaleTokens) {
            if (femaleToken.equals(firstTokenOfName)) {
                return "FEMALE";
            }
        }

        for (var maleToken : maleTokens) {
            if (maleToken.equals(firstTokenOfName)) {
                return "MALE";
            }
        }

        return "INCONCLUSIVE";
    }
}