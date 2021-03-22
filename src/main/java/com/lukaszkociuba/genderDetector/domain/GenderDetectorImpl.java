package com.lukaszkociuba.genderDetector.domain;

public class GenderDetectorImpl implements GenderDetector {
    private SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm();

    private NameToTokenConverter nameToTokenConverter = (name -> name.split("\\s"));
    private String[] tokenedName;

    @Override
    public String getGenderByFirstTokenOnly(String name) {
        if (name == null) {
            throw new NullPointerException("Null value given!");
        }

        tokenedName = nameToTokenConverter.splitNameIntoTokens(name);
        var result = simpleAlgorithm.predictGenderByFirstTokenOnly(tokenedName);

        return result;
    }

    @Override
    public String getGenderByAllTokens(String name) {
        tokenedName = nameToTokenConverter.splitNameIntoTokens(name);

        return null;
    }
}
