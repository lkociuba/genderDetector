package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class SimpleAlgorithmTest {

    private SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm();

    private final String[] tokenedName1 = {"Jan", "Maria", "Rokita"};
    private final String[] tokenedName2 = {"Anna", "Zgidniew", "Gertruda"};
    private final String[] tokenedName3 = {"Krzysztof", "Bogusław"};

    @Test
    void predictGenderByFirstTokenOnly_tokenedName1_resultMale() {
        var result = simpleAlgorithm.predictGenderByFirstTokenOnly(tokenedName1);

        assertThat(result, is("MALE"));
    }

    @Test
    void predictGenderByFirstTokenOnly_tokenedName2_resultFamele() {
        var result = simpleAlgorithm.predictGenderByFirstTokenOnly(tokenedName2);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void predictGenderByFirstTokenOnly_tokenedName3_resultInconclusive() {
        var result = simpleAlgorithm.predictGenderByFirstTokenOnly(tokenedName3);

        assertThat(result, is("INCONCLUSIVE"));
    }

    @Test
    void predictGenderByFirstTokenOnly_null_resultNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                simpleAlgorithm.predictGenderByFirstTokenOnly(null));
    }
}