package com.lukaszkociuba.genderDetector.domain;

import com.lukaszkociuba.genderDetector.domain.model.AllTokenGenderDetectionAlgorithm;
import com.lukaszkociuba.genderDetector.domain.model.FirstTokenGenderDetectionAlgorithm;
import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmFactory;
import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmType;
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