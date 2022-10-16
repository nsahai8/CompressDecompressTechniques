package com.self.service;

import com.self.model.CustomFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LogFileParser implements FileParser {

    @Override
    public CustomFile readFileFromGivenPath(String path) {
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(path);
            CustomFile file = new CustomFile(path, inputFile);
            return file;
        } catch (FileNotFoundException e) {
            // TODO add error logs
//			e.printStackTrace();
        }
        return null;
    }


}
