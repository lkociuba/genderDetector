package com.lukaszkociuba.genderDetector.domain;

public interface GenderDetector {

    String getGenderByFirstTokenOnly(String name);

    String getGenderByAllTokens(String name);
}
