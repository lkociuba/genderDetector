package com.lukaszkociuba.genderDetector.application;

import com.lukaszkociuba.genderDetector.domain.GenderDetectionAlgorithmService;
import com.lukaszkociuba.genderDetector.services.GenderDetectionAlgorithmServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
public class GenderDetectionController {

    @Autowired
    private GenderDetectionAlgorithmService genderDetectionAlgorithmService;

    @GetMapping("/gender")
    public String detectGender(@RequestParam @NotBlank String name, @RequestParam @NotBlank String algorithmType) throws Exception {
        return genderDetectionAlgorithmService.detectGender(name, algorithmType);
    }

}
