package com.lukaszkociuba.genderDetector.domain.port;

import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmResult;

import java.util.stream.Stream;

public interface GenderDetectionAlgorithm {

    GenderDetectionAlgorithmResult detectGender(String name, FileTokenSource femaleTokens, FileTokenSource maleTokens);
}
