package com.self.service;

import com.self.constants.ApplicationConstants;
import com.self.model.CustomFile;

import java.io.File;

public class CompressLogic {

    public String compressFile(String inputPath, String outputPath, int maxSizeMb) {

        CompressDecompressStrategies compressStrategies = CompressStrategyFactory.getCompressStrategyByType(ApplicationConstants.DEFAULT_STRATEGY);
        if (isFolder(inputPath)) {
            return compressStrategies.compressFolder(inputPath, outputPath);
        } else {
            FileParser fp = FileParserFactory.getFileParserByFileType(inputPath);
            CustomFile file = fp.readFileFromGivenPath(inputPath);
            return compressStrategies.compressFile(file, outputPath);
        }

    }

    public boolean isFolder(String inputPath) {
        File folder = new File(inputPath);
        return folder.isDirectory();
    }

    public void decompressFile(String inputPath, String outputPath) {
        CompressDecompressStrategies compressStrategies = CompressStrategyFactory.getCompressStrategyByType(ApplicationConstants.DEFAULT_STRATEGY);

        if (isFolder(inputPath)) {
            compressStrategies.decompressFolder(inputPath, outputPath);
        } else {
            FileParser fp = FileParserFactory.getFileParserByFileType(inputPath);
            CustomFile file = fp.readFileFromGivenPath(inputPath);
            compressStrategies.decompress(file, outputPath, "abcd.log");
        }

    }


}
