package com.lukaszkociuba.genderDetector.application;

import com.lukaszkociuba.genderDetector.domain.GenderDetectionAlgorithmService;
import com.lukaszkociuba.genderDetector.domain.GenderDetectionAlgorithmServiceV1;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
public class GenderDetectionController {

    private final GenderDetectionAlgorithmService genderDetectionAlgorithmService =
            new GenderDetectionAlgorithmServiceV1();

    @GetMapping("/gender")
    public String detectGender(@RequestParam @NotBlank String name, @RequestParam @NotBlank String algorithmType) throws Exception {
        return genderDetectionAlgorithmService.detectGender(name, algorithmType);
    }

}
