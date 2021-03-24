package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderDetectionAlgorithmFactoryTest {

    private GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();

    @Test
    void shouldReturnNewInstanceOfFirstTokenGenderDetectionAlgorithmFactoryForFirstTokenAlgorithmType() throws Exception {
        var result = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(GenderDetectionAlgorithmType.FIRST_TOKEN);

        assertTrue(result instanceof FirstTokenGenderDetectionAlgorithm);
    }

    @Test
    void shouldReturnNewInstanceOfAllTokenGenderDetectionAlgorithmFactoryForAllTokensAlgorithmType() throws Exception {
        var result = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(GenderDetectionAlgorithmType.ALL_TOKENS);

        assertTrue(result instanceof AllTokenGenderDetectionAlgorithm);
    }

    @Test
    void shouldThrowExceptionForNullAlgorithmType() {
        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(null));
    }
}