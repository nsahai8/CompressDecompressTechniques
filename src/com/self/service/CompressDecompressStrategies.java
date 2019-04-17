package com.self.service;

import com.self.model.CustomFile;

public interface CompressDecompressStrategies {
	
	public String compressFile(CustomFile file, String outputPath);
	
	public void decompress(CustomFile file, String outputPath, String filename);

	public String compressFolder(String inputPath, String outputPath);

	public void decompressFolder(String inputPath, String outputPath);


}
