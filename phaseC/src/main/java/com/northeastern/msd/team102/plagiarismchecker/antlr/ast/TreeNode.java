package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;

/**
 * @version 1.0
 * @description TreeNode type to store AST nodes
 */
public class TreeNode implements Comparable<TreeNode>{
	String ctx = null;
	String parent = null;
	int depth = -1;
	
	/**
	 * @param o : Object
	 * @return true if o has same name, parent name and depth as the current object; else false
	 */
	@Override
	public boolean equals(Object o) {
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		TreeNode t = (TreeNode) o;
		return (this.ctx!=null && t.ctx!=null && this.parent!=null && t.parent!=null && 
				this.ctx.equals(t.ctx) && this.parent.equals(t.parent) && this.depth==t.depth);
	}

	/**
	 * @param t : TreeNode
	 * @return 0 if t and current object are same
	 */
	@Override
	public int compareTo(TreeNode t) {
		return (this.ctx!=null && t.ctx!=null && this.parent!=null && t.parent!=null && 
				 this.parent.equals(t.parent) && this.depth==t.depth) ? this.ctx.compareTo(t.ctx) : -1;
	}
	
	/**
	 * @return unique code for the current object
	 */
	@Override
	  public int hashCode() {
	    return this.ctx.length() + this.parent.length() + this.depth;
	  }

}
