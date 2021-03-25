package com.lukaszkociuba.genderDetector.services;

import com.lukaszkociuba.genderDetector.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GenderDetectionAlgorithmServiceV1 implements GenderDetectionAlgorithmService {

    private final List<String> maleTokens = new ArrayList<>(Arrays.asList("Jan", "Andrzej", "Olaf"));
    private final List<String> femaleTokes = new ArrayList<>(Arrays.asList("Maria", "Anna", "Gertruda"));

    @Override
    public String detectGender(String name, String algorithmType) throws Exception {
        var givenAlgorithmType = this.getAlgorithmType(algorithmType);

        GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();
        GenderDetectionAlgorithm algorithm = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(givenAlgorithmType);

        var result = algorithm.detectGender(name, femaleTokes, maleTokens);
        return this.convertAlgorithmResultToString(result);
    }

    private GenderDetectionAlgorithmType getAlgorithmType(String algorithmType) throws Exception {
        switch (algorithmType) {
            case "firstToken":
                return GenderDetectionAlgorithmType.FIRST_TOKEN;

            case "allTokens":
                return GenderDetectionAlgorithmType.ALL_TOKENS;

            default:
                throw new Exception("Invalid algorithm name given!");
        }
    }

    private String convertAlgorithmResultToString (GenderDetectionAlgorithmResult algorithmResult) throws Exception {
        switch (algorithmResult){
            case FEMALE:
                return "FEMALE";

            case MALE:
                return "MALE";

            case INCONCLUSIVE:
                return "INCONCLUSIVE";

            default:
                throw new Exception("Invalid algorithm result given!");
        }
    }

}
