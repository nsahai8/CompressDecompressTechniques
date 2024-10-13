package com.self.model;

import java.io.FileInputStream;

public class CustomFile {
    private final String inputPath;
    private final FileInputStream file;
    private String outputPath;

    public CustomFile(String path, FileInputStream file) {
        inputPath = path;
        this.file = file;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public FileInputStream getFile() {
        return file;
    }


}
