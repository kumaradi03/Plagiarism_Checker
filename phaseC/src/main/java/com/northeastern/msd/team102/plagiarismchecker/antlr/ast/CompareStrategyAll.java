package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import org.apache.log4j.Logger;

/**
 * @version 1.0
 * @description compares 2 python files
 */
public class CompareStrategyAll implements CompareStrategy {

	private Logger logger;
	public CompareStrategyAll () {
		logger = Logger.getLogger(CompareStrategyAll.class.getName());
	}
	
	/**
	 * @param file1 : byte array
	 * @param file2 : byte array
	 * @return percent similarity with keeping file1 as base, maps how similar is file2 with file1
	 * 			i.e it tells how much portion of code in file1 is present in file2
	 */
	public double compareFiles(byte[] file1, byte[] file2) {
		double[] total = new double[3];
		CompareStrategy c1 = new CompareStrategyHashMap();
		total[0] = c1.compareFiles(file1, file2);		
		CompareStrategy c2 = new CompareStrategyLevenshteinDist();
		total[1] = c2.compareFiles(file1, file2);		
		CompareStrategy c3 = new CompareStrategyTrees();
		total[2] = c3.compareFiles(file1, file2);		
		WeighComparators w = new WeighComparators("src/main/resources/TrainingData.csv");
	    return w.getFinalPredictedOutputAll(total);
	}
}

