package com.lukaszkociuba.genderDetector.domain;

import java.util.List;

public interface GenderDetectionAlgorithm {

    GenderDetectionAlgorithmResult detectGender(String name, List<String> femaleTokens, List<String> maleTokens);
}
