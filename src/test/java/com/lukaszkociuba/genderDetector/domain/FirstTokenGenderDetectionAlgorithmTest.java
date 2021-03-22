package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class FirstTokenGenderDetectionAlgorithmTest {

    private FirstTokenGenderDetectionAlgorithm firstTokenGenderDetectionAlgorithm = new FirstTokenGenderDetectionAlgorithm();

    private final String name1 = "Jan Maria Rokita";
    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    @Test
    void detectGender_name1_returnMale() {
        var result = firstTokenGenderDetectionAlgorithm.detectGender(name1, femaleTokens, maleTokens);

        assertThat(result, is("MALE"));
    }

    @Test
    void detectGender_name2_returnMale() {
        var name2 = "Anna Zgidniew Gertruda";
        var result = firstTokenGenderDetectionAlgorithm.detectGender(name2, femaleTokens, maleTokens);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void detectGender_name3_returnInconclusive() {
        var name3 = "Krzysztof Bogusław";
        var result = firstTokenGenderDetectionAlgorithm.detectGender(name3, femaleTokens, maleTokens);

        assertThat(result, is("INCONCLUSIVE"));
    }

    @Test
    void detectGender_nullName_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(null, femaleTokens, maleTokens));
    }

    @Test
    void detectGender_nullFemaleTokens_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name1, null, maleTokens));
    }

    @Test
    void detectGender_nullMaleTokens_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                firstTokenGenderDetectionAlgorithm.detectGender(name1, femaleTokens, null));
    }
}