package com.lukaszkociuba.genderDetector.domain.model;

import com.lukaszkociuba.genderDetector.domain.port.FileTokenSource;
import com.lukaszkociuba.genderDetector.domain.port.GenderDetectionAlgorithm;

import java.util.List;

public class FirstTokenGenderDetectionAlgorithm implements GenderDetectionAlgorithm {

    @Override
    public GenderDetectionAlgorithmResult detectGender(String name, FileTokenSource femaleTokensSource, FileTokenSource maleTokensSource) {

        boolean isFemale = femaleTokensSource.stream()
                .anyMatch(name::startsWith);
        if (isFemale) {
            return GenderDetectionAlgorithmResult.FEMALE;
        }

        boolean isMale = maleTokensSource.stream()
                .anyMatch(name::startsWith);

        if (isMale) {
            return GenderDetectionAlgorithmResult.MALE;
        } else {
            return GenderDetectionAlgorithmResult.INCONCLUSIVE;
        }
    }
}