package LeetCodeMyself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Problem103 {
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
	
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(root==null) {
			 return result;
		 }else {
			 Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
			 nodeQueue.add(root);
			 int nodeLevel = 1;
			 while(!nodeQueue.isEmpty()) {
				 List<Integer> tmpList = new ArrayList<Integer>();
				 int noOfNodeSameLevel = nodeQueue.size();
				 boolean fromLeftToRight = (nodeLevel%2==1);
				 for(int i = 0 ; i < noOfNodeSameLevel; i++) {
					 if(nodeQueue.peek().left!=null) {
						 nodeQueue.offer(nodeQueue.peek().left);
					 }
					 if(nodeQueue.peek().right!=null) {
						 nodeQueue.offer(nodeQueue.peek().right);
					 }
					 tmpList.add(nodeQueue.poll().val);
				 }
				 if(!fromLeftToRight) {
					 Collections.reverse(tmpList);
				 }
				 result.add(tmpList);
				 nodeLevel++;
			 }
			 return result;
		 }
	 }
}
