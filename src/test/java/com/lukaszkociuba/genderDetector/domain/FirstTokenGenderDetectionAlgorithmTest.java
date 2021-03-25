package com.lukaszkociuba.genderDetector.domain;

import com.lukaszkociuba.genderDetector.domain.model.FirstTokenGenderDetectionAlgorithm;
import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmResult;
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
    void shouldReturnFemaleGenderForFemaleName() {
        var name = "Anna";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldReturnMaleGenderForMaleName() {
        var name = "Jan";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldReturnInconclusiveGenderForIncorrectFemaleName() {
        var name = "Julia";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnInconclusiveGenderForIncorrectMaleName() {
        var name = "Krzysztof";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnFemaleGenderForNamesWithFirstFemaleName() {
        var name = "Anna Jan Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldReturnMaleGenderForNamesWithFirstMaleName() {
        var name = "Jan Anna Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithFirstIncorrectFemaleName() {
        var name = "Julia Anna Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithFirstIncorrectMaleName() {
        var name = "Krzysztof Anna Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldThrowRuntimeExceptionForEmptyName() {
        var name = "";

        assertThrows(RuntimeException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldThrowRuntimeExceptionForSpaceName() {
        var name = " ";

        assertThrows(RuntimeException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens));
    }


    @Test
    void shouldThrowNullPointerExceptionForNullName() {
        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(null, femaleTokens, maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullFemaleTokens() {
        var name = "Jan";

        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, null, maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullMaleTokens() {
        var name = "Jan";

        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, null));
    }

    @Test
    void shouldReturnFemaleGenderForNamesWithFirstFemaleNameAndIrregularSpaces() {
        var name = "Anna    Jan    Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void shouldReturnMaleGenderForNamesWithFirstMaleNameAndIrregularSpaces() {
        var name = "Jan    Anna     Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithFirstIncorrectFemaleNameAndIrregularSpaces() {
        var name = "Julia    Anna    Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void shouldReturnInconclusiveGenderForNamesWithFirstIncorrectMaleNameAndIrregularSpaces() {
        var name = "Krzysztof Anna      Olaf";

        var result = firstTokenGenderDetectionAlgorithm.detectGender(name, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

}