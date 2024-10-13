package com.self.service;

import com.self.model.CustomFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class SimpleCompressDecompressStrategy implements CompressDecompressStrategies {


    @Override
    public String compressFile(CustomFile file, String outputPath) {
        String filename = "abc.zip";
        //Assign the original file : file to
        //FileInputStream for reading data 
        FileInputStream fis = file.getFile();

        //Assign compressed file:file2 to FileOutputStream 
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(outputPath + filename);

            //Assign FileOutputStream to DeflaterOutputStream
            DeflaterOutputStream dos = new DeflaterOutputStream(fos);

            //read data from FileInputStream and write it into DeflaterOutputStream
            int data;
            while ((data = fis.read()) != -1) {
                dos.write(data);
            }

            //close the file
            fis.close();
            dos.close();
            return filename;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void decompress(CustomFile file, String outputPath, String filename) {

        FileInputStream fis = file.getFile();

        //assign output file: file3 to FileOutputStream for reading the data 
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(outputPath + filename);

            //assign inflaterInputStream to FileInputStream for uncompressing the data
            InflaterInputStream iis = new InflaterInputStream(fis);

            //read data from inflaterInputStream and write it into FileOutputStream
            int data;
            while ((data = iis.read()) != -1) {
                fos.write(data);
            }

            //close the files
            fos.close();
            iis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public String compressFolder(String inputPath, String outputPath) {
        File folder = new File(inputPath);
        for (String fileName : Objects.requireNonNull(folder.list())) {
            FileParser fp = FileParserFactory.getFileParserByFileType(inputPath + "/" + fileName);
            assert fp != null;
            CustomFile file = fp.readFileFromGivenPath(inputPath);
            compressFile(file, outputPath);
        }
        return outputPath;
    }

    @Override
    public void decompressFolder(String inputPath, String outputPath) {
        File folder = new File(inputPath);
        for (String fileName : Objects.requireNonNull(folder.list())) {
            if (isFolder(inputPath + fileName)) {
                decompressFolder(inputPath + fileName, outputPath + fileName);
                continue;
            }
            if (!fileName.contains(".zip")) {
                continue;
            }
            FileParser fp = FileParserFactory.getFileParserByFileType(inputPath + fileName);
            assert fp != null;
            CustomFile file = fp.readFileFromGivenPath(inputPath + fileName);
            if (file != null) {
                decompress(file, outputPath, fileName.replace(".zip", "") + ".log");
            }

        }

    }

    private boolean isFolder(String inputPath) {
        File folder = new File(inputPath);
        if (folder.isDirectory()) {
            return true;
        }
        return false;
    }

}
