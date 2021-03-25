package com.lukaszkociuba.genderDetector.domain;

import com.lukaszkociuba.genderDetector.domain.model.AllTokenGenderDetectionAlgorithm;
import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmResult;
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
    void shouldReturnFemaleGenderForFemaleName() {
        var name = "Anna";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldReturnMaleGenderForMaleName() {
        var name = "Jan";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldReturnInconclusiveGenderForIncorrectFemaleName() {
        var name = "Julia";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnInconclusiveGenderForIncorrectMaleName() {
        var name = "Krzysztof";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnFemaleGenderForNamesWithFemaleMajority() {
        var name = "Anna Zgidniew Gertruda";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldReturnMaleGenderForNamesWithMaleMajority() {
        var name = "Anna Olaf Jan";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithEqualsMaleAndFemale() {
        var name = "Anna Olaf Jan Maria";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithEqualsMaleAndFemalePlusIncorrectFemaleName() {
        var name = "Anna Olaf Jan Maria Julia";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithEqualsMaleAndFemalePlusIncorrectMaleName() {
        var name = "Anna Olaf Jan Maria Krzysztof";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldThrowRuntimeExceptionForEmptyName() {
        var name = "";

        assertThrows(RuntimeException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldThrowRuntimeExceptionForSpaceName() {
        var name = " ";

        assertThrows(RuntimeException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullName() {
        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(null, femaleTokens, maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullFemaleTokens() {
        var name = "Anna Zgidniew Gertruda";

        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, null, maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullMaleTokens() {
        var name = "Anna Zgidniew Gertruda";

        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, null));
    }

    @Test
    void shouldReturnFemaleGenderForNamesWithFemaleMajorityAndIrregularSpaces() {
        var name = "Anna      Zgidniew        Gertruda";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldReturnwMaleGenderForNamesWithMaleMajorityAndIrregularSpaces() {
        var name = "Anna      Olaf      Jan";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithEqualsMaleAndFemaleAndIrregularSpaces() {
        var name = "Anna       Olaf  Jan Maria";

        var result = allTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }
}