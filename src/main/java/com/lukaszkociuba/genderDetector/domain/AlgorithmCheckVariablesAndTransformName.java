package com.lukaszkociuba.genderDetector.domain;

import java.util.List;

public class AlgorithmCheckVariablesAndTransformName {
    public String[] checkVariablesAndTransformName(String name, List<String> femaleTokens, List<String> maleTokens) {
        if (name == null || femaleTokens == null || maleTokens == null) {
            throw new NullPointerException("Null value given!");
        }

        if (name.equals("") || name.equals(" ")) {
            throw new RuntimeException("Empty name given!");
        }

        GenderDetectionAlgorithmNameToTokenConverter genderDetectionAlgorithmNameToTokenConverter = (name1 -> name1.split("\\s"));
        var tokenedName = genderDetectionAlgorithmNameToTokenConverter.splitNameIntoTokens(name);

        return tokenedName;
    }
}
