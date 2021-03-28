package com.lukaszkociuba.genderDetector.domain.port;

import java.util.stream.Stream;

public interface TokenSource {
    Stream<String> stream();
}
