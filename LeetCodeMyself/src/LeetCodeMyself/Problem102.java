package LeetCodeMyself;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
	public  class TreeNode {	      int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
}}
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        if(root==null) {
	        	return new ArrayList<List<Integer>>();
	        }else {
	        	Queue<TreeNode> childQueue = new LinkedList<TreeNode>();
	        	childQueue.add(root);
        		return this.orderTranversal(childQueue, new ArrayList<List<Integer>>());
	        }
	 }
	 
	 public List<List<Integer>> orderTranversal(Queue<TreeNode> nodeQueue, List<List<Integer>> resultList){
		 
		 if(nodeQueue.isEmpty()) {
			 return resultList;
		 }
		 
		 Queue<TreeNode> newStack = new LinkedList<TreeNode>();
		 List<Integer> tmpList = new ArrayList<Integer>();
		 while(!nodeQueue.isEmpty()) {
			 TreeNode tmpNode = nodeQueue.remove();
			 if(tmpNode.left!=null) {
				 newStack.add(tmpNode.left);
			 }
			 if(tmpNode.right!=null) {
				 newStack.add(tmpNode.right);
			 }
			 tmpList.add(tmpNode.val);
		 }
		 resultList.add(tmpList);
		 return orderTranversal(newStack, resultList);
	 }
	 
	 
}
