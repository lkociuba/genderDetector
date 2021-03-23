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

    private final String name1 = "Jan Maria Rokita";
    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    @Test
    void detectGender_name1_resultInconclusive() {
        var result = allTokenGenderDetectionAlgorithm.detectGender(name1, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.INCONCLUSIVE));
    }

    @Test
    void detectGender_name2_resultFemale() {
        var name2 = "Anna Zgidniew Gertruda";
        var result = allTokenGenderDetectionAlgorithm.detectGender(name2, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.FEMALE));
    }

    @Test
    void detectGender_name3_resultMale() {
        var name3 = "Anna Olaf Jan";
        var result = allTokenGenderDetectionAlgorithm.detectGender(name3, femaleTokens, maleTokens);

        assertThat(result, is(GenderDetectionAlgorithmResult.MALE));
    }

    @Test
    void detectGender_nullName_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(null, femaleTokens, maleTokens));
    }

    @Test
    void detectGender_nullFemaleTokens_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name1, null, maleTokens));
    }

    @Test
    void detectGender_nullMaleTokens_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                allTokenGenderDetectionAlgorithm.detectGender(name1, femaleTokens, null));
    }
}