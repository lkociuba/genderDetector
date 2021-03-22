package com.lukaszkociuba.genderDetector.domain;

public class GenderDetectorImpl implements GenderDetector {
    private SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm();
    private AdvancedAlgorithm advancedAlgorithm = new AdvancedAlgorithm();

    private NameToTokenConverter nameToTokenConverter = (name -> name.split("\\s"));
    private String[] tokenedName;

    @Override
    public String getGenderByFirstTokenOnly(String name) {
        if (name == null) {
            throw new NullPointerException("Null value given!");
        }

        tokenedName = nameToTokenConverter.splitNameIntoTokens(name);

        return simpleAlgorithm.predictGenderByFirstTokenOnly(tokenedName);
    }

    @Override
    public String getGenderByAllTokens(String name) {
        if (name == null) {
            throw new NullPointerException("Null value given!");
        }

        tokenedName = nameToTokenConverter.splitNameIntoTokens(name);

        return advancedAlgorithm.predictGenderByAllTokens(tokenedName);
    }
}
