package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AllTokenGenderDetectionAlgorithmTest {

    private AllTokenGenderDetectionAlgorithm allTokenGenderDetectionAlgorithm = new AllTokenGenderDetectionAlgorithm();

    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    @Test
    void shouldFemaleGenderFromFemaleName() {
        var name = "Anna";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldMaleGenderFromMaleName() {
        var name = "Jan";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldInconclusiveGenderFromIncorrectFemaleName() {
        var name = "Julia";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldInconclusiveGenderFromIncorrectMaleName() {
        var name = "Krzysztof";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldFemaleGenderFromNamesWithFemaleMajority() {
        var name = "Anna Zgidniew Gertruda";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldMaleGenderFromNamesWithMaleMajority() {
        var name = "Anna Olaf Jan";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldInconclusiveGenderFromNamesWithEqualsMaleAndFemale() {
        var name = "Anna Olaf Jan Maria";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldInconclusiveGenderFromNamesWithEqualsMaleAndFemalePlusIncorrectFemaleName() {
        var name = "Anna Olaf Jan Maria Julia";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldInconclusiveGenderFromNamesWithEqualsMaleAndFemalePlusIncorrectMaleName() {
        var name = "Anna Olaf Jan Maria Krzysztof";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldRuntimeExceptionFromEmptyName() {
        var name = "";

        assertThrows(RuntimeException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldRuntimeExceptionFromSpaceName() {
        var name = " ";

        assertThrows(RuntimeException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullName() {
        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(null, femaleTokens, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullFemaleTokens() {
        var name = "Anna Zgidniew Gertruda";

        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, null, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullMaleTokens() {
        var name = "Anna Zgidniew Gertruda";

        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, null));
    }

    @Test
    void shouldFemaleGenderFromNamesWithFemaleMajorityAndIrregularSpaces() {
        var name = "Anna      Zgidniew        Gertruda";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldMaleGenderFromNamesWithMaleMajorityAndIrregularSpaces() {
        var name = "Anna      Olaf      Jan";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldInconclusiveGenderFromNamesWithEqualsMaleAndFemaleAndIrregularSpaces() {
        var name = "Anna       Olaf  Jan Maria";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }
}