package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

/**
 * @version 1.0
 * @description Interface for comparing files using Strategy design pattern
 */
public interface CompareStrategy {
	double compareFiles(byte[] file1, byte[] file2);
}
