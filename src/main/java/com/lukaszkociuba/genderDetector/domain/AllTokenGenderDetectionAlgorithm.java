package com.lukaszkociuba.genderDetector.domain;

import java.util.List;

public class AllTokenGenderDetectionAlgorithm implements GenderDetectionAlgorithm {

    private int countEqualTokens(String[] tokenedName, List<String> nameTokens) {
        int equalTokens = 0;
        for (var nameToken : tokenedName) {
            for (var femaleToken : nameTokens) {
                if (nameToken.equals(femaleToken)) {
                    equalTokens += 1;
                }
            }
        }
        return equalTokens;
    }

    @Override
    public String detectGender(String name, List<String> femaleTokens, List<String> maleTokens) {
        if (name == null || femaleTokens == null || maleTokens == null) {
            throw new NullPointerException("Null value given!");
        }

        GenderDetectionAlgorithmNameToTokenConverter genderDetectionAlgorithmNameToTokenConverter = (name1 -> name1.split("\\s"));
        var tokenedName = genderDetectionAlgorithmNameToTokenConverter.splitNameIntoTokens(name);

        int countFemaleTokens = countEqualTokens(tokenedName, femaleTokens);
        int countMaleTokens = countEqualTokens(tokenedName, maleTokens);

        if (countFemaleTokens != 0 && countFemaleTokens > countMaleTokens) {
            return "FEMALE";
        } else if (countMaleTokens != 0 && countMaleTokens > countFemaleTokens) {
            return "MALE";
        } else {
            return "INCONCLUSIVE";
        }
    }
}
