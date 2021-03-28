package com.lukaszkociuba.genderDetector.infrastructure;

import com.lukaszkociuba.genderDetector.domain.port.FileTokenSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileTokenSourceAdapter implements FileTokenSource {

    private String filePath;

    public FileTokenSourceAdapter(String filePath) {
        if (filePath == null) {
            throw new NullPointerException("Null filePath value given!");
        }
        if (filePath.equals("") || filePath.equals(" ")) {
            throw new RuntimeException("Empty filePath value given!");
        }
        this.filePath = "src/main/resources/" + filePath + ".txt";
    }

    @Override
    public Stream<String> stream() {
        try {
            return Files.lines(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return null;
    }
}
