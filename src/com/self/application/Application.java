package com.self.application;

import com.self.service.CompressLogic;

public class Application {

    public static void main(String[] args) {
        // compress and decompress files
        //TODO add path for input and output file for compress
        String inputPath = "/Users/nihgupta/Desktop/test.log";
        String outputPath = "/Users/nihgupta/Desktop/"; //TODO add path for output file here
        int maxSizeMb = 10;

        CompressLogic service = new CompressLogic();
        String zipFileName = service.compressFile(inputPath, outputPath, maxSizeMb);

        service.decompressFile(outputPath + zipFileName, outputPath);

        // decompress folders
        // ToDo add output decompressed folder path here
        String inputFolderPath = "/Users/nihgupta/Desktop/testing/test.log";
        String outputFolderPath = "/Users/nihgupta/Desktop/testingZip/";

        service.compressFile(inputFolderPath, outputFolderPath, 0);
        service.decompressFile(outputFolderPath, "/Users/nihgupta/Desktop/testingZip1/");
    }

}
