package com.northeastern.msd.team102.plagiarismchecker.antlr.parser;

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

    private boolean ignoringWrappers = true;

    /**
	 * @param ignoringWrappers : boolean; to decide whether to ignore wrappers
	 */
    public void setIgnoringWrappers(boolean ignoringWrappers) {
        this.ignoringWrappers = ignoringWrappers;
    }

    /**
	 * @param ctx : RuleContext reference
	 */
    public String print(RuleContext ctx) {
        return exploreString(ctx,0);
    }

    /**
	 * @param ctx : RuleContext reference
	 * @param indentation : int; defines no of spaces to show indentation for tree view, root node has '0'
	 */
    private void explore(RuleContext ctx, int indentation) {
        boolean toBeIgnored = ignoringWrappers
                && ctx.getChildCount() == 1
                && ctx.getChild(0) instanceof ParserRuleContext;
        if (!toBeIgnored) {
            String ruleName = grammerParser.ruleNames[ctx.getRuleIndex()];
            for (int i = 0; i < indentation; i++) {
                System.out.print("  ");
            }
            System.out.println(ruleName);
        }
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                explore((RuleContext)element, indentation + (toBeIgnored ? 0 : 1));
            }
        }
    }
    
    /**
	 * @param ctx : RuleContext reference
	 * @param indentation : int; defines no of spaces to show indentation for tree view, root node has '0'
	 */
    private String exploreString(RuleContext ctx, int indentation) {
    	boolean toBeIgnored = false;
    	if (ignoringWrappers && (ctx.getChildCount() == 1) && (ctx.getChild(0) instanceof ParserRuleContext)) {
    		toBeIgnored = true;
    	}
        StringBuilder str = new StringBuilder();
        if (!toBeIgnored) {
        	if (grammerParser.ruleNames[ctx.getRuleIndex()] != null) {
        		String ruleName = grammerParser.ruleNames[ctx.getRuleIndex()];
                System.out.println("ruleName = "+ruleName);
                for (int i = 0; i < indentation; i++) {
                	str.append("  ");
                }
                str.append(ruleName);
        	}
        }
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                explore((RuleContext)element, indentation + (toBeIgnored ? 0 : 1));
            }
        }
		return str.toString();
    }

}