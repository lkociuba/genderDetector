package com.lukaszkociuba.genderDetector.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenderDetectionAlgorithmServiceV1 implements GenderDetectionAlgorithmService {

    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));
    private final List<String> femaleTokes = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));

    @Override
    public String detectGender(String name, String algorithmType) throws Exception {
        var givenAlgorithmType = this.getAlgorithmType(algorithmType);

        GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();
        GenderDetectionAlgorithm algorithm = genderDetectionAlgorithmFactory.genderDetectionAlgorithm(givenAlgorithmType);

        return algorithm.detectGender(name, femaleTokes, maleTokens);
    }

    private GenderDetectionAlgorithmType getAlgorithmType(String algorithmType) throws Exception {
        switch (algorithmType) {
            case "firstToken":
                return GenderDetectionAlgorithmType.FIRST_TOKEN;

            case "allTokens":
                return GenderDetectionAlgorithmType.ALL_TOKENS;

            default:
                throw new Exception("Invalid algorithm name given!");
        }
    }

}
