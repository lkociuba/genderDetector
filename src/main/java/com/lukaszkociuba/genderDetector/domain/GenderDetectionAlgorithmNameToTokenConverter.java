package com.lukaszkociuba.genderDetector.domain;

@FunctionalInterface
public interface GenderDetectionAlgorithmNameToTokenConverter {

    String[] splitNameIntoTokens(String name);
}
