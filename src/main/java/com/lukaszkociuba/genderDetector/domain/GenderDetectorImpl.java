package com.lukaszkociuba.genderDetector.domain;

public class GenderDetectorImpl implements GenderDetector {

    private NameToTokenConverter nameToTokenConverter = (name -> name.split("\\s"));
    private String[] tokenedName;

    @Override
    public String getGenderByFirstTokenOnly(String name) {
        tokenedName = nameToTokenConverter.splitNameIntoTokens(name);
        return null;
    }

    @Override
    public String getGenderByAllTokens(String name) {
        tokenedName = nameToTokenConverter.splitNameIntoTokens(name);
        return null;
    }
}
