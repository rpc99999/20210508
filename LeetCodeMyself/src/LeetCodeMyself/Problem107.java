package LeetCodeMyself;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem107 {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	        if(root==null) {
	        	return resultList;
	        }
	        
	        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
	        nodeQueue.offer(root);
	        while(!nodeQueue.isEmpty()) {
	        	List<Integer> numList = new ArrayList<Integer>();
	        	int noOfNode = nodeQueue.size();
	        	for(int i = 0 ; i < noOfNode ; i++) {
	        		if(nodeQueue.peek().left!=null) {
	        			nodeQueue.offer(nodeQueue.peek().left);
	        		}
	        		if(nodeQueue.peek().right!=null) {
	        			nodeQueue.offer(nodeQueue.peek().right);
	        		}
	        		numList.add(nodeQueue.poll().val);
	        	}
	        	resultList.add(0, numList);
	        }
	        return resultList;
	 }
}
