package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.io.File;

/**
 * @version 1.0
 * @description Interface for comparing files using Strategy design pattern
 */
public interface CompareStrategy {
	public double compareFiles(File file1, File file2);
}
