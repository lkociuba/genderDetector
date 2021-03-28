package com.lukaszkociuba.genderDetector.services;

import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmFactory;
import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmResult;
import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmType;
import com.lukaszkociuba.genderDetector.domain.port.FileTokenSource;
import com.lukaszkociuba.genderDetector.domain.port.GenderDetectionAlgorithm;
import com.lukaszkociuba.genderDetector.domain.port.GenderTokensSource;
import com.lukaszkociuba.genderDetector.infrastructure.FileTokenSourceAdapter;
import com.lukaszkociuba.genderDetector.infrastructure.GenderTokensSourceAdapter;

public class GenderDetectionAlgorithmServiceV2 implements GenderDetectionAlgorithmService {

    private FileTokenSource maleTokensSource = new FileTokenSourceAdapter("maleTokens");
    private FileTokenSource femaleTokensSource = new FileTokenSourceAdapter("femaleTokens");

    @Override
    public String detectGender(String name, String algorithmType) throws Exception {
        var givenAlgorithmType = this.getAlgorithmType(algorithmType);

        GenderDetectionAlgorithmFactory genderDetectionAlgorithmFactory = new GenderDetectionAlgorithmFactory();
        GenderDetectionAlgorithm algorithm = genderDetectionAlgorithmFactory.getGenderDetectionAlgorithm(givenAlgorithmType);

        var result = algorithm.detectGender(name, maleTokensSource, femaleTokensSource);
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

    private String convertAlgorithmResultToString(GenderDetectionAlgorithmResult algorithmResult) throws Exception {
        switch (algorithmResult) {
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
