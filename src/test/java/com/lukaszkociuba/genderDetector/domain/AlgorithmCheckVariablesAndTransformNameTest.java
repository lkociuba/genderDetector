package com.lukaszkociuba.genderDetector.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AlgorithmCheckVariablesAndTransformNameTest {

    private AlgorithmCheckVariablesAndTransformName algorithmCheckVariablesAndTransformName =
            new AlgorithmCheckVariablesAndTransformName();

    private final List<String> femaleTokens = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));
    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));

    @Test
    void shouldSplitNameFromNamesWithNormalSpaces() {
        var name = "Jan Maria Olaf";

        var result = algorithmCheckVariablesAndTransformName
                .checkVariablesAndTransformName(name, femaleTokens, maleTokens);

        String[] expected = {"Jan", "Maria", "Olaf"};
        assertThat(result, is(expected));
    }

    @Test
    void shouldSplitNameFromNamesWithIrregularSpaces() {
        var name = "Jan    Maria           Olaf";

        var result = algorithmCheckVariablesAndTransformName
                .checkVariablesAndTransformName(name, femaleTokens, maleTokens);

        String[] expected = {"Jan", "Maria", "Olaf"};
        assertThat(result, is(expected));
    }

    @Test
    void shouldSplitNameFromNameWithIrregularSpace() {
        var name = "Jan       ";

        var result = algorithmCheckVariablesAndTransformName
                .checkVariablesAndTransformName(name, femaleTokens, maleTokens);

        String[] expected = {"Jan"};
        assertThat(result, is(expected));
    }

    @Test
    void shouldRuntimeExceptionFromEmptyName() {
        var name = "";

        assertThrows(RuntimeException.class, () ->
                algorithmCheckVariablesAndTransformName.
                        checkVariablesAndTransformName(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldRuntimeExceptionFromSpaceName() {
        var name = " ";

        assertThrows(RuntimeException.class, () ->
                algorithmCheckVariablesAndTransformName.
                        checkVariablesAndTransformName(name, femaleTokens, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullName() {
        assertThrows(NullPointerException.class, () ->
                algorithmCheckVariablesAndTransformName.
                        checkVariablesAndTransformName(null, femaleTokens, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullFemaleTokens() {
        var name = "Anna Zgidniew Gertruda";

        assertThrows(NullPointerException.class, () ->
                algorithmCheckVariablesAndTransformName.
                        checkVariablesAndTransformName(name, null, maleTokens));
    }

    @Test
    void shouldNullPointerExceptionFromNullMaleTokens() {
        var name = "Anna Zgidniew Gertruda";

        assertThrows(NullPointerException.class, () ->
                algorithmCheckVariablesAndTransformName.
                        checkVariablesAndTransformName(name, femaleTokens, null));
    }

}