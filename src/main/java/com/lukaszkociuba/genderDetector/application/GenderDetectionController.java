package com.lukaszkociuba.genderDetector.application;

import com.lukaszkociuba.genderDetector.domain.GenderDetectionAlgorithmService;
import com.lukaszkociuba.genderDetector.domain.GenderDetectionAlgorithmServiceV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderDetectionController {

    private final GenderDetectionAlgorithmService genderDetectionAlgorithmService =
            new GenderDetectionAlgorithmServiceV1();

    @GetMapping("/gender/{name}/{algorithmType}")
    public String detectGender(@PathVariable String name, @PathVariable String algorithmType) throws Exception {
        return genderDetectionAlgorithmService.detectGender(name, algorithmType);
    }

}
