package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description compares two ASTs
 */
public class CompareAST {   
    
	/**
	 * @param nodes1 : Map that maintains the ruleName of the AST1 as key, and list of various depths at which it is found as list
	 * @param nodes2 : Map that maintains the ruleName of the AST2 as key, and list of various depths at which it is found as list
	 * @return percent similarity with keeping nodes1 as base, maps how similar is nodes2 with nodes1
	 */
    public double compareAST1withAST2 (Map<String, List<Integer>> nodes1, Map<String, List<Integer>> nodes2) {
    	int total = 0;    	
    	int similarity = 0;
    	for (String s : nodes1.keySet()) {
    		if (nodes2.containsKey(s)) {
    			List<Integer> level1 = new ArrayList<>(nodes1.get(s));
    			total = total + level1.size();
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
    	if (total == 0) {
    		return 0;
    	}
    	return ((double)similarity/(double)total) * 100.0;
    }
}
