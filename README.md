# Compress Decompress Techniques

The project compresses files and folders into a set of compressed files such that of each
compressed file doesn’t exceed a maximum size. The same program can be used for
decompressing the files that it has generated earlier. The output of the decompression is 
identical to the original input of the compression process.
When compression is needed, the program takes 3 parameters:
1. Path to Input directory. This directory will contain some files and folders.
2. Path to Output directory, where the program should write the compressed files to.
3. Maximum compressed size per file expressed in MB.

When decompression is needed, the program takes 2 parameters:
1. Path to Input directory containing the compressed files generated by the same program.
2. Path to Output directory.

[Application.java](https://github.com/nsahai8/CompressDecompressTechniques/blob/master/src/com/self/application/Application.java) is a demo class to explain the procedure.

The project uses Strategy Design Pattern to solve this problem.
Currently, have used a basic technique to solve the problem. But in future we can add more strategies to achieve the same result.