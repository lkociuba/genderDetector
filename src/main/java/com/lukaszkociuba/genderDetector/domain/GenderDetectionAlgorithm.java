package com.lukaszkociuba.genderDetector.domain;

import java.util.List;

public interface GenderDetectionAlgorithm {

    String detectGender(String name, List<String> femaleTokens, List<String> maleTokens);
}
