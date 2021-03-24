package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderDetectionAlgorithmFactoryTest {

    private GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();

    @Test
    void shouldNewInstanceOfFirstTokenGenderDetectionAlgorithmFactoryFromFirstTokenAlgorithmType() throws Exception {
        var result = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(GenderDetectionAlgorithmType.FIRST_TOKEN);

        assertTrue(result instanceof FirstTokenGenderDetectionAlgorithm);
    }

    @Test
    void shouldNewInstanceOfAllTokenGenderDetectionAlgorithmFactoryFromAllTokensAlgorithmType() throws Exception {
        var result = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(GenderDetectionAlgorithmType.ALL_TOKENS);

        assertTrue(result instanceof AllTokenGenderDetectionAlgorithm);
    }

    @Test
    void shouldThrowExceptionFromNullAlgorithmType() {
        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(null));
    }
}