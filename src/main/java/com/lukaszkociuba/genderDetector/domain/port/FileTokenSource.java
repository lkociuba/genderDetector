package com.lukaszkociuba.genderDetector.domain.port;

import java.util.stream.Stream;

public interface FileTokenSource {
    Stream<String> stream();
}
