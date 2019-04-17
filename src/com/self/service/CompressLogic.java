package com.self.service;

import java.io.File;

import com.self.model.CustomFile;

public class CompressLogic {

	public String compressFile(String inputPath, String outputPath, int maxSizeinMb) {
		
		CompressDecompressStrategies compressStrategies = CompressStrategyFactory.getCompressStrategyByType("Strategy1");
		if(isFolder(inputPath)) {
			String path = compressStrategies.compressFolder(inputPath,outputPath);
			return path;
		}else {
			FileParser fp = FileParserFactory.getFileParserByFileType(inputPath);
			CustomFile file = fp.readFileFromGivenPath(inputPath);
			String filename = compressStrategies.compressFile(file, outputPath);
			return filename;
		}
		
	}

	public boolean isFolder(String inputPath) {
		File folder = new File(inputPath);
	    if (folder.isDirectory()) {
	    	return true;
	    }
		return false;
	}

	public void decompressFile(String inputPath, String outputPath) {
		CompressDecompressStrategies compressStrategies = CompressStrategyFactory.getCompressStrategyByType("Strategy1");
		
		if(isFolder(inputPath)) {
			compressStrategies.decompressFolder(inputPath,outputPath);
		}else {
			FileParser fp = FileParserFactory.getFileParserByFileType(inputPath);
			CustomFile file = fp.readFileFromGivenPath(inputPath);
			compressStrategies.decompress(file, outputPath,"abcd.log");
		}
		
	}
	
	
}
