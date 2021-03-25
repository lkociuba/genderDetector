package com.lukaszkociuba.genderDetector.infrastructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenderTokensSourceAdapterTest {

    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));
    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));

    @Test
    void shouldReturnFemaleTokenListForFemaleTokenList() {
        var tokenList = "femaleTokens";
        var genderTokensSourceAdapter = new GenderTokensSourceAdapter(tokenList);

        var result = genderTokensSourceAdapter.getTokenList();

        assertThat(result, is(femaleTokens));
    }

    @Test
    void shouldReturnMaleTokenListForMaleTokenList() {
        var tokenList = "maleTokens";
        var genderTokensSourceAdapter = new GenderTokensSourceAdapter(tokenList);

        var result = genderTokensSourceAdapter.getTokenList();

        assertThat(result, is(maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullAlgorithmType() {
        String tokenList = null;

        assertThrows(NullPointerException.class, () ->
                new GenderTokensSourceAdapter(tokenList));
    }

    @Test
    void shouldThrowExceptionForEmptyAlgorithmType() {
        var tokenList = "";

        assertThrows(Exception.class, () ->
                new GenderTokensSourceAdapter(tokenList));
    }

    @Test
    void shouldThrowExceptionForSpaceAlgorithmType() {
        var tokenList = " ";

        assertThrows(Exception.class, () ->
                new GenderTokensSourceAdapter(tokenList));
    }
}