package com.self.service;

public class CompressStrategyFactory {


    public static CompressDecompressStrategies getCompressStrategyByType(String strategyType) {
        if (strategyType.equalsIgnoreCase("Strategy1")) {
            return new CompressDecompressStrategy1();
        }
        return null;
    }

}
