package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderDetectionAlgorithmFactoryTest {

    private static final GenderDetectionAlgorithmType firstToken = GenderDetectionAlgorithmType.FIRST_TOKEN;
    private static final GenderDetectionAlgorithmType allTokens = GenderDetectionAlgorithmType.ALL_TOKENS;
    private GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();

    @Test
    void genderDetectionAlgorithm_firstToken_resultNewInstanceOfFirstTokenGenderDetectionAlgorithmFactory() throws Exception {
        var result = genderDetectionAlgorithmFactory.genderDetectionAlgorithm(firstToken);

        assertTrue(result instanceof FirstTokenGenderDetectionAlgorithm);
    }

    @Test
    void genderDetectionAlgorithm_allTokens_resultNewInstanceOfAllTokenGenderDetectionAlgorithmFactory() throws Exception {
        var result = genderDetectionAlgorithmFactory.genderDetectionAlgorithm(allTokens);

        assertTrue(result instanceof AllTokenGenderDetectionAlgorithm);
    }

    @Test
    void genderDetectionAlgorithm_null_resultException() {
        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmFactory.genderDetectionAlgorithm(null));
    }
}