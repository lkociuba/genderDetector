package com.lukaszkociuba.genderDetector.domain;

public class GenderDetectionAlgorithmFactory {

    public GenderDetectionAlgorithm genderDetectionAlgorithm(GenderDetectionAlgorithmType algorithmType) throws Exception {
        switch (algorithmType) {
            case FIRST_TOKEN:
                return new FirstTokenGenderDetectionAlgorithm();

            case ALL_TOKENS:
                return new AllTokenGenderDetectionAlgorithm();

            default:
                throw new Exception("Invalid algorithm type given!");
        }
    }
}
