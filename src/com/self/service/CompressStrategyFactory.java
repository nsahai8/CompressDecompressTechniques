package com.self.service;

public class CompressStrategyFactory {


    public static CompressDecompressStrategies getCompressStrategyByType(String strategyType) {
        return new SimpleCompressDecompressStrategy();
    }

}
