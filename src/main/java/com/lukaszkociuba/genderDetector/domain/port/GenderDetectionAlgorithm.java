package com.lukaszkociuba.genderDetector.domain.port;

import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmResult;


public interface GenderDetectionAlgorithm {

    GenderDetectionAlgorithmResult detectGender(String name, FileTokenSource femaleTokensSource, FileTokenSource maleTokensSource);
}
