package com.self.service;

public class FileParserFactory {
	
	public  static FileParser getFileParserByFileType( String path) {
		String fileType = "log";//from path
		if(fileType.equalsIgnoreCase("log")) {
			return new LogFileParser();
		}
		return null;
	}

}
