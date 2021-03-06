package com.lukaszkociuba.genderDetector.domain.model;

import com.lukaszkociuba.genderDetector.domain.port.GenderDetectionAlgorithm;

import java.util.List;

public class AllTokenGenderDetectionAlgorithm implements GenderDetectionAlgorithm {

    private NameToTokenConverter nameToTokenConverter =
            new NameToTokenConverter();


    @Override
    public GenderDetectionAlgorithmResult detectGender(String name, List<String> femaleTokens, List<String> maleTokens) {
        var tokenedName = nameToTokenConverter
                .splitToTokens(name, femaleTokens, maleTokens);

        int countFemaleTokens = countEqualTokens(tokenedName, femaleTokens);
        int countMaleTokens = countEqualTokens(tokenedName, maleTokens);

        if (countFemaleTokens != 0 && countFemaleTokens > countMaleTokens) {
            return GenderDetectionAlgorithmResult.FEMALE;
        } else if (countMaleTokens != 0 && countMaleTokens > countFemaleTokens) {
            return GenderDetectionAlgorithmResult.MALE;
        } else {
            return GenderDetectionAlgorithmResult.INCONCLUSIVE;
        }
    }

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
}
