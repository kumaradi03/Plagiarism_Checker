package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.net.URISyntaxException;

public class Context {
    private CompareStrategy strategy;

    public Context(CompareStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy (byte[] file1, byte[] file2) throws URISyntaxException {
        return strategy.compareFiles(file1, file2);
    }
}
