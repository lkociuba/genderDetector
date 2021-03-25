package com.lukaszkociuba.genderDetector.infrastructure;

import com.lukaszkociuba.genderDetector.domain.port.GenderTokensSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenderTokensSourceAdapter implements GenderTokensSource {

    @Override
    public List<String> getTokenList(String tokenList) {

        return null;
    }
}
