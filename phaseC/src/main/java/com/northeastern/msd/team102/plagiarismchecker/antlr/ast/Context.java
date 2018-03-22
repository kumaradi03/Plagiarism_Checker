package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

public class Context {
    private CompareStrategy strategy;

    public Context(CompareStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy (byte[] file1, byte[] file2){
        return strategy.compareFiles(file1, file1);
    }
}
