package com.lukaszkociuba.genderDetector.domain.model;

import com.lukaszkociuba.genderDetector.domain.port.GenderDetectionAlgorithm;

import java.util.List;

public class FirstTokenGenderDetectionAlgorithm implements GenderDetectionAlgorithm {

    private NameToTokenConverter nameToTokenConverter =
            new NameToTokenConverter();

    @Override
    public GenderDetectionAlgorithmResult detectGender(String name, List<String> femaleTokens, List<String> maleTokens) {
        var tokenedName = nameToTokenConverter
                .splitToTokens(name, femaleTokens, maleTokens);
        var firstTokenOfName = tokenedName[0];

        for (var femaleToken : femaleTokens) {
            if (femaleToken.equals(firstTokenOfName)) {
                return GenderDetectionAlgorithmResult.FEMALE;
            }
        }

        for (var maleToken : maleTokens) {
            if (maleToken.equals(firstTokenOfName)) {
                return GenderDetectionAlgorithmResult.MALE;
            }
        }

        return GenderDetectionAlgorithmResult.INCONCLUSIVE;
    }
}