package com.lukaszkociuba.genderDetector.infrastructure;

import com.lukaszkociuba.genderDetector.domain.port.GenderTokensSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenderTokensSourceAdapter implements GenderTokensSource {

    private String filePath;

    public GenderTokensSourceAdapter(String filePath) {
        if (filePath == null) {
            throw new NullPointerException("Null filePath value given!");
        }
        if (filePath.equals("") || filePath.equals(" ")) {
            throw new RuntimeException("Empty filePath value given!");
        }
        String path = "src/main/resources/" + filePath + ".txt";
        this.filePath = path;
    }

    @Override
    public List<String> getTokenList() {
        try (Stream<String> lines = Files.lines(Paths.get(this.filePath))) {
            return lines
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Unable to read tokenList!");
        }
        return null;
    }
}
