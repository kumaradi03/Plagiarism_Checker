package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerParser;

/**
 * @version 1.0
 * @description to print the generated AST for view
 * @note this file is a reference from 'https://github.com/ftomassetti/python-ast'
 */
public class ASTPrinter {

    private boolean ignoringWrappers;
    private StringBuilder str;
    private Map<String, List<Integer>> nodes;
    private RuleContext ctx = null;
    
    /**
     * @param ctx : RuleContext reference
     */
    public ASTPrinter(RuleContext ctx) {
    	this.ctx = ctx;
    	str = new StringBuilder();
    	nodes = new TreeMap<>();
    	ignoringWrappers = true;
    }
    
    /**
	 * @param ignoringWrappers : boolean; to decide whether to ignore wrappers
	 */
    public void setIgnoringWrappers(boolean ignoringWrappers) {
        this.ignoringWrappers = ignoringWrappers;
    }

    /**
	 * @param ctx : RuleContext reference
	 */
    public String print() {
        return exploreString(ctx,0);
    }
    
    /**
	 * @param ctx : RuleContext reference
	 * @param indentation : int - defines no of spaces to show indentation for tree view, root node has '0'
	 * @return String representation of AST
	 */
    private String exploreString(RuleContext ctx, int indentation) {
    	boolean toBeIgnored = false;
    	if (ignoringWrappers && (ctx.getChildCount() == 1) && (ctx.getChild(0) instanceof ParserRuleContext)) {
    		toBeIgnored = true;
    	}
        if (!toBeIgnored) {
        	if (grammerParser.ruleNames[ctx.getRuleIndex()] != null) {
        		String ruleName = grammerParser.ruleNames[ctx.getRuleIndex()];
                for (int i = 0; i < indentation; i++) {
                	str.append(" ");
                }
                str.append(ruleName);
                List<Integer> level = new ArrayList<>();
                if (nodes.containsKey(ruleName)) {
                	level.addAll(nodes.get(ruleName));
                }
                level.add(indentation);
                nodes.put(ruleName, level);
        	}
        }
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
            	exploreString((RuleContext)element, indentation + (toBeIgnored ? 0 : 1));
            }
        }
		return str.toString();
    }
    
    /**
     * @return nodes : Map that maintains the ruleName of the AST as key, and list of various depths at which it is found as list
     */
    public Map<String, List<Integer>> getNodes() {
    	return nodes;
    }

}