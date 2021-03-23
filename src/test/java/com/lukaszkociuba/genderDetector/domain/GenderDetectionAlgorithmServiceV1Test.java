package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenderDetectionAlgorithmServiceV1Test {

    private GenderDetectionAlgorithmServiceV1 genderDetectionAlgorithmService = new GenderDetectionAlgorithmServiceV1();

    private final String firstToken = "firstToken";
    private final String allTokens = "allTokens";

    private final String name1 = "Jan Maria Rokita";
    private final String name2 = "Anna Zgidniew Gertruda";

    @Test
    void detectGender_name1FirstToken_resultMale() throws Exception {
        var result = genderDetectionAlgorithmService.detectGender(name1, firstToken);

        assertThat(result, is("MALE"));
    }

    @Test
    void detectGender_name2FirstToken_resultMale() throws Exception {
        var result = genderDetectionAlgorithmService.detectGender(name2, firstToken);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void detectGender_name3FirstToken_resultInconclusive() throws Exception {
        var name3 = "Krzysztof Bogusław";
        var result = genderDetectionAlgorithmService.detectGender(name3, firstToken);

        assertThat(result, is("INCONCLUSIVE"));
    }

    @Test
    void detectGender_nullNameFirstToken_resultNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                genderDetectionAlgorithmService.detectGender(null, firstToken));
    }

    @Test
    void detectGender_name1NullAlgorithmType_resultException() {
        assertThrows(Exception.class, () ->
                genderDetectionAlgorithmService.detectGender(name1, null));
    }

    @Test
    void detectGender_name1AllTokens_resultInconclusive() throws Exception {
        var result = genderDetectionAlgorithmService.detectGender(name1, allTokens);

        assertThat(result, is("INCONCLUSIVE"));
    }

    @Test
    void detectGender_name2AllTokens_resultFemale() throws Exception {
        var result = genderDetectionAlgorithmService.detectGender(name2, allTokens);

        assertThat(result, is("FEMALE"));
    }

    @Test
    void detectGender_name4AllTokens_resulMale() throws Exception {
        var name4 = "Anna Olaf Jan";
        var result = genderDetectionAlgorithmService.detectGender(name4, allTokens);

        assertThat(result, is("MALE"));
    }
}