package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
    private RuleContext ctx;
    private Logger logger;
    private int total;
    private List<TreeNode> treeNodes;
    
    /**
     * @param f : byte[] of File whose AST is to be generated
     */
    public ASTGenerator(byte[] f) {
    	this.f = f;
    	this.ctx = null;
    	this.total = 0;
    	this.treeNodes = new ArrayList<>();
    	this.logger = Logger.getLogger(ASTGenerator.class.getName());
    	this.str = new StringBuilder();
    	this.nodes = new TreeMap<>();
    	setIgnoringWrappers(true);
    	parse();
    	exploreString(ctx, 0, null);
    }
    
    /**
	 * @param ignoringWrappers : boolean; to decide whether to ignore wrappers
	 */
    private void setIgnoringWrappers(boolean ignoringWrappers) {
        this.ignoringWrappers = ignoringWrappers;
    }
    
    /**
	 * @description parse the input byte array
	 */
    private void parse() {
        logger.log(Level.INFO, "Parsing file");
        String code = new String(f, Charset.forName("UTF-8"));
        grammerLexer lexer = new grammerLexer(new ANTLRInputStream(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        grammerParser parser = new grammerParser(tokens);
        this.ctx = parser.file_input();
    }
    
    /**
	 * @param ctx : RuleContext reference pointing to the root of AST generated by Antlr
	 * @param indentation : int - defines no of spaces to show indentation for tree view, root node has '0'
	 * @param parent : String representing the name of the parent node of the AST, root's parent is 'null'
	 */
    private void exploreString(RuleContext ctx, int indentation, String parent) {
    	boolean toBeIgnored = false;
    	if (ignoringWrappers && (ctx.getChildCount() == 1) && (ctx.getChild(0) instanceof ParserRuleContext)) {
    		toBeIgnored = true;
    	}
        if (!toBeIgnored && (grammerParser.ruleNames[ctx.getRuleIndex()] != null)) {
            String ruleName = grammerParser.ruleNames[ctx.getRuleIndex()];
            this.total++;
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
            TreeNode temp = new TreeNode();
            temp.ctx = ruleName;
            temp.parent = parent;
            temp.depth = indentation;
            treeNodes.add(temp);
        }
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
            	exploreString((RuleContext)element, indentation + (toBeIgnored ? 0 : 1),
            			grammerParser.ruleNames[ctx.getRuleIndex()]);
            }
        }
    }

    /**
	 * @return String representation of AST
	 */
    public String print() {
    	return str.toString();
    }
    
    /**
     * @return nodes : Map that maintains the ruleName of the AST as key, and list of various depths at which it is found as list
     */
    public Map<String, List<Integer>> getNodes() {
    	return nodes;
    }
    
    /**
     * @return total : count of total number of nodes in the AST generated
     */
    public int getTotalCountOfNodes() {
    	return this.total; 
    }
    
    /**
     * @return treeNodes : List of TreeNodes of AST
     */
    public List<TreeNode> getTreeNodes() {
    	return treeNodes; 
    }

}