package com.lukaszkociuba.genderDetector.domain.port;

import java.util.List;

public interface GenderTokensSource {
    List<String> getTokenList(String tokenList);
}
