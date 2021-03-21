package com.lukaszkociuba.genderDetector.domain;

@FunctionalInterface
public interface NameToTokenConverter {

    String[] splitNameIntoTokens(String name);
}
