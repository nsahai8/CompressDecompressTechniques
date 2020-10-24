package com.self.service;

import com.self.model.CustomFile;

public interface FileParser {

    CustomFile readFileFromGivenPath(String path);

}
