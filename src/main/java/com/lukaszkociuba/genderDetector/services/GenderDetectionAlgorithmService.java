package com.lukaszkociuba.genderDetector.services;

public interface GenderDetectionAlgorithmService {

    String detectGender(String name, String algorithmType) throws Exception;
}
