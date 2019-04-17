package com.self.service;

import java.io.FileInputStream;

import com.self.model.CustomFile;

public interface FileParser {
	
	CustomFile readFileFromGivenPath(String path) ;
	
}
