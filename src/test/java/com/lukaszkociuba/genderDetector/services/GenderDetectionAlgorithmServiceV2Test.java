package com.lukaszkociuba.genderDetector.services;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenderDetectionAlgorithmServiceV2Test {

    private GenderDetectionAlgorithmServiceV2 genderDetectionAlgorithmService = new GenderDetectionAlgorithmServiceV2();

    private final String name1 = "Jan Maria Gertruda";

    @Test
    void shouldReturnMaleGenderForFirstTokenAlgorithmType() throws Exception {
        var algorithmType = "firstToken";

        var result = genderDetectionAlgorithmService.detectGender(name1, algorithmType);

        assertThat(result, is("MALE"));
    }

    @Test
    void shouldReturnFemaleGenderForAllTokensAlgorithmType() throws Exception {
        var algorithmType = "allTokens";

        var result = genderDetectionAlgorithmService.detectGender(name1, algorithmType);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void shouldThrowExceptionForWrongAlgorithmType() {
        var algorithmType = "wrongType";

        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmService.detectGender(name1, algorithmType));
    }

    @Test
    void shouldThrowExceptionForEmptyAlgorithmType() {
        var algorithmType = "";

        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmService.detectGender(name1, algorithmType));
    }

    @Test
    void shouldThrowExceptionForSpaceAlgorithmType() {
        var algorithmType = "";

        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmService.detectGender(name1, algorithmType));
    }

    @Test
    void shouldThrowExceptionForNullAlgorithmType() {
        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmService.detectGender(name1, null));
    }
}