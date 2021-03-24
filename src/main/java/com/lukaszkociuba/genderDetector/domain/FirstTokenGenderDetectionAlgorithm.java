package com.lukaszkociuba.genderDetector.domain;

import java.util.List;

public class FirstTokenGenderDetectionAlgorithm implements GenderDetectionAlgorithm {

    private AlgorithmCheckVariablesAndTransformName algorithmCheckVariablesAndTransformName =
            new AlgorithmCheckVariablesAndTransformName();

    @Override
    public GenderDetectionAlgorithmResult detectGender(String name, List<String> femaleTokens, List<String> maleTokens) {
        var tokenedName = algorithmCheckVariablesAndTransformName
                .checkVariablesAndTransformName(name, femaleTokens, maleTokens);
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