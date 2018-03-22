package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @description compares 2 python files using Hashmap strategy
 */
public class CompareStrategyHashMap implements CompareStrategy {

	private Logger logger;
	public CompareStrategyHashMap () {
		logger = Logger.getLogger(CompareStrategyHashMap.class.getName());
	}
	
	@Override
	/**
	 * @param file1 : byte array
	 * @param file2 : byte array
	 * @return percent similarity with keeping file1 as base, maps how similar is file2 with file1
	 * 			i.e it tells how much portion of code in file1 is present in file2
	 */
	public double compareFiles(byte[] file1, byte[] file2) {
		ASTGenerator astPrinter1 = new ASTGenerator(file1);
		int total = astPrinter1.getTotalCountOfNodes();
		if (total == 0) {
			return 0;
		}
		ASTGenerator astPrinter2 = new ASTGenerator(file2);	    
	    Map<String, List<Integer>> node1 = astPrinter1.getNodes();
	    Map<String, List<Integer>> node2 = astPrinter2.getNodes();
	    
	    WeighComparators w = new WeighComparators("src/main/resources/TrainingData.csv");
	    return w.getFinalPredictedOutput(compareAST1withAST2(node1, node2, total), 1);
	}
	
	/**
	 * @param nodes1 : Map that maintains the ruleName of the AST1 as key, and list of various depths at which it is found as list
	 * @param nodes2 : Map that maintains the ruleName of the AST2 as key, and list of various depths at which it is found as list
	 * @return percent similarity with keeping nodes1 as base, maps how similar is nodes2 with nodes1
	 */
    private double compareAST1withAST2 (Map<String, List<Integer>> nodes1, Map<String, List<Integer>> nodes2, int total) {    	
    	int similarity = 0;
    	for (Entry<String, List<Integer>> entry : nodes1.entrySet()) {
    		String s = entry.getKey();
    		if (nodes2.containsKey(s)) {
    			List<Integer> level1 = new ArrayList<>(nodes1.get(s));
        		List<Integer> level2 = new ArrayList<>(nodes2.get(s));
        		Collections.sort(level1);
        		Collections.sort(level2);
        		for (int i : level1) {
        			if (level2.contains(i)) {
        				int idx = level2.lastIndexOf(i);
        				level2.remove(idx);
        				similarity++;
        			}
        		}
    		}
    	}
    	return ((double)similarity/(double)total) * 100.0;
    }

}
