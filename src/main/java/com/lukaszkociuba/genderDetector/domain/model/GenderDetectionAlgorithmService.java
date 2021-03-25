package com.lukaszkociuba.genderDetector.domain.model;

public interface GenderDetectionAlgorithmService {

    String detectGender(String name, String algorithmType) throws Exception;
}
