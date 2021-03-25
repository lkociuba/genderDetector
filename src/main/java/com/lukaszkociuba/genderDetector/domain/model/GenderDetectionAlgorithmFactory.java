package com.lukaszkociuba.genderDetector.domain.model;

import com.lukaszkociuba.genderDetector.domain.port.GenderDetectionAlgorithm;

public class GenderDetectionAlgorithmFactory {

    public GenderDetectionAlgorithm getGenderDetectionAlgorithm(GenderDetectionAlgorithmType algorithmType) throws Exception {
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
