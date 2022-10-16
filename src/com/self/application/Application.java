package com.self.application;

import com.self.service.CompressLogic;

public class Application {

    public static void main(String[] args) {
        // compress and decompress files
        String inputPath = "/Users/nihgupta/Desktop/test.log";
        String outputPath = "/Users/nihgupta/Desktop/";
        int maxSizeinMb = 10;

        CompressLogic service = new CompressLogic();
        String zipfileName = service.compressFile(inputPath, outputPath, maxSizeinMb);

        service.decompressFile(outputPath + zipfileName, outputPath);

        //compress and decompress folders
        String inputFolderPath = "/Users/nihgupta/Desktop/testing/test.log";
        String outputFolderPath = "/Users/nihgupta/Desktop/testingZip/";

        service.compressFile(inputFolderPath, outputFolderPath, 0);
        service.decompressFile(outputFolderPath, "/Users/nihgupta/Desktop/testingZip1/");
    }

}
