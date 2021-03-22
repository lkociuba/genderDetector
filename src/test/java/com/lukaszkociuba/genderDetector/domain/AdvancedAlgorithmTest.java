package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class AdvancedAlgorithmTest {

    private AdvancedAlgorithm advancedAlgorithm = new AdvancedAlgorithm();

    private final String[] tokenedName1 = {"Jan", "Maria", "Rokita"};
    private final String[] tokenedName2 = {"Anna", "Zgidniew", "Gertruda"};
    private final String[] tokenedName3 = {"Anna", "Olaf", "Jan"};

    @Test
    void predictGenderByAllTokens_tokenedName1_resultInconclusive() {
        var result = advancedAlgorithm.predictGenderByAllTokens(tokenedName1);

        assertThat(result, is("INCONCLUSIVE"));
    }

    @Test
    void predictGenderByAllTokens_tokenedName2_resultFemale() {
        var result = advancedAlgorithm.predictGenderByAllTokens(tokenedName2);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void predictGenderByAllTokens_tokenedName3_resultMale() {
        var result = advancedAlgorithm.predictGenderByAllTokens(tokenedName3);

        assertThat(result, is("MALE"));
    }

    @Test
    void predictGenderByAllTokens_null_resultNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                advancedAlgorithm.predictGenderByAllTokens(null));
    }
}