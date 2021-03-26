package com.lukaszkociuba.genderDetector.application;

import com.lukaszkociuba.genderDetector.domain.model.GenderDetectionAlgorithmService;
import com.lukaszkociuba.genderDetector.domain.port.GenderTokensSource;
import com.lukaszkociuba.genderDetector.infrastructure.GenderTokensSourceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Validated
public class GenderDetectionController {

    @Autowired
    private GenderDetectionAlgorithmService genderDetectionAlgorithmService;

    @GetMapping("/gender")
    public String detectGender(@RequestParam @NotBlank String name, @RequestParam @NotBlank String algorithmType) throws Exception {
        return genderDetectionAlgorithmService.detectGender(name, algorithmType);
    }

    @GetMapping("/genderList")
    public List<String> detectGender(@RequestParam String tokenListName) {
        GenderTokensSource tokenlist = new GenderTokensSourceAdapter(tokenListName);
        return tokenlist.getTokenList();
    }

}
