package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class GenderDetectorImplTest {

    private GenderDetectorImpl genderDetector = new GenderDetectorImpl();

    private final String name1 = "Jan Maria Rokita";
    private final String name2 = "Anna Zbigniew Gertruda";

    @Test
    void getGenderByFirstTokenOnly_name1_returnMale() {
        var result = genderDetector.getGenderByFirstTokenOnly(name1);

        assertThat(result, is("MALE"));
    }

    @Test
    void getGenderByFirstTokenOnly_name2_returnFemale() {
        var result = genderDetector.getGenderByFirstTokenOnly(name2);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void getGenderByFirstTokenOnly_null_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                genderDetector.getGenderByFirstTokenOnly(null));
    }

    @Test
    void getGenderByAllTokens_name1_returnInconclusive() {
        var result = genderDetector.getGenderByAllTokens(name1);

        assertThat(result, is("INCONCLUSIVE"));
    }

    @Test
    void getGenderByAllTokens_name2_returnFemale() {
        var result = genderDetector.getGenderByAllTokens(name2);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void getGenderByAllTokens_null_returnNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                genderDetector.getGenderByAllTokens(null));
    }
}