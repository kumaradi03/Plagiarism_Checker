package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerLexer;
import com.northeastern.msd.team102.plagiarismchecker.antlr.grammer.grammerParser;

/**
 * @version 1.0
 * @description to print the generated AST for view
 * @note this file is a reference from 'https://github.com/ftomassetti/python-ast'
 */
public class ASTGenerator {

    private boolean ignoringWrappers;
    private StringBuilder str;
    private Map<String, List<Integer>> nodes;
    private byte[] f;
    private RuleContext ctx = null;
    private Logger logger;
    
    /**
     * @param f : byte[] of File whose AST is to be generated
     */
    public ASTGenerator(byte[] f) {
    	this.f = f;
    	logger = Logger.getLogger(ASTGenerator.class.getName());
    	str = new StringBuilder();
    	nodes = new TreeMap<>();
    	setIgnoringWrappers(true);
    	try {
			parse();
		} catch (IOException e) {
			logger.log(Level.INFO, "IO Exception: {0}",e);
		}
    	exploreString(ctx,0);
    }
    
    /**
	 * @param ignoringWrappers : boolean; to decide whether to ignore wrappers
	 */
    private void setIgnoringWrappers(boolean ignoringWrappers) {
        this.ignoringWrappers = ignoringWrappers;
    }

    /**
	 * @return String representation of AST
	 */
    public String print() {
    	return str.toString();
    }
    
    /**
	 * @param ctx : RuleContext reference
	 * @param indentation : int - defines no of spaces to show indentation for tree view, root node has '0'
	 * @return String representation of AST
	 */
    private void exploreString(RuleContext ctx, int indentation) {
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
    }
    
    /**
     * @return nodes : Map that maintains the ruleName of the AST as key, and list of various depths at which it is found as list
     */
    public Map<String, List<Integer>> getNodes() {
    	return nodes;
    }

	/**
	 * @return parsed python file of type 'RuleContext'
	 * @throws IOException
	 */
    private void parse() throws IOException {
        String code = new String(f, Charset.forName("UTF-8"));
        grammerLexer lexer = new grammerLexer(new ANTLRInputStream(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammerParser parser = new grammerParser(tokens);
        this.ctx = parser.file_input();
    }
}