package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;


import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CompareStrategyLevenshteinDist implements CompareStrategy {

    private Logger logger;
    public CompareStrategyLevenshteinDist () {
        logger = Logger.getLogger(CompareStrategyLevenshteinDist.class.getName());
    }


    @Override
    /**
     * @param file1 : byte array
     * @param file2: byte array
     * @return percent similarity with keeping file1 as base, maps how similar is file2 with file1
     */
    public double compareFiles(byte[] file1, byte[] file2) {
        ASTGenerator astPrinter1 = new ASTGenerator(file1);
        int total = astPrinter1.getTotalCountOfNodes();
        if (total == 0) {
            return 0;
        }
        ASTGenerator astPrinter2 = new ASTGenerator(file2);
        String node1 = astPrinter1.print();
        String node2 = astPrinter2.print();
        return compareFilesUsingLD(node1, node2);
    }

    /**
     * This function implements logic to compare two string using
     * Levenshtein Edit distance
     * @param rawfirstString first String
     * @param rawsecondString second String
     * @return Edit distance similarity between rawfirstString and
     * rawsecondString
     */
    public double compareFilesUsingLD(String rawfirstString, String rawsecondString) {
        String firstString = rawfirstString.trim().replaceAll(" +", " ");
        String secondString = rawsecondString.trim().replaceAll(" +", " ");
        int len0 = firstString.length() + 1;
        int len1 = secondString.length() + 1;
        int[] distanceCost = new int[len0];
        int[] new_generated_distanceCost = new int[len0];
        float max_distance;
        float normalised_edit_distance;
        float percentSimilarity;

        if(firstString.length()==0 || secondString.length()==0){
            return 0;
        }

        max_distance=Math.min((len0-1),(len1-1));
        for (int i = 0; i < len0; i++) distanceCost[i] = i;
        for (int j = 1; j < len1; j++) {
            new_generated_distanceCost[0] = j;
            for(int i = 1; i < len0; i++) {
                int match = (firstString.charAt(i - 1) == secondString.charAt(j - 1)) ? 0 : 1;
                int distanceCost_replace = distanceCost[i - 1] + match;
                int distanceCost_insert  = distanceCost[i] + 1;
                int distanceCost_delete  = new_generated_distanceCost[i - 1] + 1;
                new_generated_distanceCost[i] = Math.min(Math.min(distanceCost_insert, distanceCost_delete),
                        distanceCost_replace);
            }
            int[] swap = distanceCost; distanceCost = new_generated_distanceCost; new_generated_distanceCost = swap;
        }
        normalised_edit_distance=(distanceCost[len0 - 1]/max_distance);
        percentSimilarity=(1-normalised_edit_distance)*100;
        if(percentSimilarity<0){
            return 0;
        }
        return (double) percentSimilarity;
    }
}
