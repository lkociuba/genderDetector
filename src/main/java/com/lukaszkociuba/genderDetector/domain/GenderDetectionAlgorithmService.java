package com.lukaszkociuba.genderDetector.domain;

public interface GenderDetectionAlgorithmService {

    String detectGender(String name, String algorithmType) throws Exception;
}
