package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderDetectionAlgorithmFactoryTest {

    private static final GenderDetectionAlgorithmType firstToken = GenderDetectionAlgorithmType.FIRST_TOKEN;
    private static final GenderDetectionAlgorithmType allTokens = GenderDetectionAlgorithmType.ALL_TOKENS;
    private GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();

    @Test
    void getGenderDetectionAlgorithm_firstToken_resultNewInstanceOfFirstTokenGenderDetectionAlgorithmFactory() throws Exception {
        var result = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(firstToken);

        assertTrue(result instanceof FirstTokenGenderDetectionAlgorithm);
    }

    @Test
    void getGenderDetectionAlgorithm_allTokens_resultNewInstanceOfAllTokenGenderDetectionAlgorithmFactory() throws Exception {
        var result = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(allTokens);

        assertTrue(result instanceof AllTokenGenderDetectionAlgorithm);
    }

    @Test
    void getGenderDetectionAlgorithm_null_resultException() {
        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(null));
    }
}