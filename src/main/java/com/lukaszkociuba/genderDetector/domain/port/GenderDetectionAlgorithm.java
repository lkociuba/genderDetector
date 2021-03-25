package com.lukaszkociuba.genderDetector.domain.port;

import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmResult;

import java.util.List;

public interface GenderDetectionAlgorithm {

    GenderDetectionAlgorithmResult detectGender(String name, List<String> femaleTokens, List<String> maleTokens);
}
