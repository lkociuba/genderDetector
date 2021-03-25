package com.lukaszkociuba.genderDetector.infrastructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenderTokensSourceAdapterTest {

    private GenderTokensSourceAdapter genderTokensSourceAdapter = new GenderTokensSourceAdapter();

    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));
    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));

    @Test
    void shouldReturnFemaleTokenListForFemaleAlgorithmType() {
        var tokenList = "femaleTokens";

        var result = genderTokensSourceAdapter.getTokenList(tokenList);

        assertThat(result, is(femaleTokens));
    }

    @Test
    void shouldReturnMaleTokenListForMaleAlgorithmType() {
        var tokenList = "maleTokens";

        var result = genderTokensSourceAdapter.getTokenList(tokenList);

        assertThat(result, is(maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullAlgorithmType() {
        String tokenList = null;

        assertThrows(NullPointerException.class, () ->
                genderTokensSourceAdapter.getTokenList(tokenList));
    }

    @Test
    void shouldThrowExceptionForEmptyAlgorithmType() {
        var tokenList = "";

        assertThrows(Exception.class, () ->
                genderTokensSourceAdapter.getTokenList(tokenList));
    }

    @Test
    void shouldThrowExceptionForSpaceAlgorithmType() {
        var tokenList = " ";

        assertThrows(Exception.class, () ->
                genderTokensSourceAdapter.getTokenList(tokenList));
    }

    @Test
    void shouldThrowExceptionForIncorrectFemaleAlgorithmType() {
        var tokenList = "female Tokens";

        assertThrows(Exception.class, () ->
                genderTokensSourceAdapter.getTokenList(tokenList));
    }

    @Test
    void shouldThrowExceptionForIncorrectMaleAlgorithmType() {
        var tokenList = "male Token";

        assertThrows(Exception.class, () ->
                genderTokensSourceAdapter.getTokenList(tokenList));
    }

}