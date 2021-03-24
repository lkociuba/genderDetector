package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class FirstTokenGenderDetectionAlgorithmTest {

    private FirstTokenGenderDetectionAlgorithm firstTokenGenderDetectionAlgorithm =
            new FirstTokenGenderDetectionAlgorithm();

    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    @Test
    void shouldFemaleGenderFromFemaleName() {
        var name = "Anna";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldMaleGenderFromMaleName() {
        var name = "Jan";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldInconclusiveGenderFromIncorrectFemaleName() {
        var name = "Julia";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldInconclusiveGenderFromIncorrectMaleName() {
        var name = "Krzysztof";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldFemaleGenderFromNamesWithFirstFemaleName() {
        var name = "Anna Jan Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldMaleGenderFromNamesWithFirstMaleName() {
        var name = "Jan Anna Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldInconclusiveGenderFromNamesWithFirstIncorrectFemaleName() {
        var name = "Julia Anna Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldInconclusiveGenderFromNamesWithFirstIncorrectMaleName() {
        var name = "Krzysztof Anna Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldInconclusiveGenderFromEmptyName() {
        var name = "";

        assertThrows(RuntimeException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldInconclusiveGenderFromSpaceName() {
        var name = " ";

        assertThrows(RuntimeException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }


    @Test
    void shouldNullPointerExceptionFromNullName() {
        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(null, femaleTokens, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullFemaleTokens() {
        var name = "Jan";

        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, null, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullMaleTokens() {
        var name = "Jan";

        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, null));
    }
}