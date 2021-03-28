package com.lukaszkociuba.genderDetector.infrastructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileTokenSourceAdapterTest {

    @Test
    void shouldReturnFirst3TokensFromMaleTokensListForMaleTokensFilePath() {
        var maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));
        var filePath = "maleTokens";

        FileTokenSourceAdapter fileTokenSourceAdapter = new FileTokenSourceAdapter(filePath);
        var result = fileTokenSourceAdapter.stream()
                .skip(0)
                .limit(3)
                .collect(Collectors.toList());

        assertThat(result, is(maleTokens));
    }

    @Test
    void shouldReturnFirst3TokensFromFemaleTokensListForFemaleTokensFilePath() {
        var maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));
        var filePath = "maleTokens";

        FileTokenSourceAdapter fileTokenSourceAdapter = new FileTokenSourceAdapter(filePath);
        var result = fileTokenSourceAdapter.stream()
                .skip(0)
                .limit(3)
                .collect(Collectors.toList());

        assertThat(result, is(maleTokens));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullFilePath() {
        String filePath = null;

        assertThrows(NullPointerException.class, () ->
                new FileTokenSourceAdapter(filePath));
    }

    @Test
    void shouldThrowExceptionForEmptyFilePath() {
        var filePath = "";

        assertThrows(RuntimeException.class, () ->
                new FileTokenSourceAdapter(filePath));
    }

    @Test
    void shouldThrowExceptionForSpaceFilePath() {
        var filePath = " ";

        assertThrows(RuntimeException.class, () ->
                new FileTokenSourceAdapter(filePath));
    }
}
