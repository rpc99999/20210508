package LeetCodeMyself;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0) {
        	return null;
        }else {
        	Queue<Integer> preOrderQueue = new LinkedList<Integer>();
        	for(int i = 0 ; i < preorder.length; i++) {
        		preOrderQueue.offer(preorder[i]);
        	}
        	
        	List<Integer> inorderList = new ArrayList<Integer>();
        	for(int i = 0 ; i < inorder.length ; i++) {
        		inorderList.add(inorder[i]);
        	}
        	
        	return buildTree(preOrderQueue, inorderList);
        }
    }
	
	public TreeNode buildTree(Queue<Integer> preOrderQueue, List<Integer> inorder) {
		if(inorder.size()<=0) {
			return null;
		}else {
			int val = preOrderQueue.poll();
			TreeNode node = new TreeNode(val);
			
			List<Integer> leftInOrderList = new ArrayList<Integer>();
			List<Integer> rightInOrderList = new ArrayList<Integer>();
			
			int index = inorder.indexOf(val);
			for(int i = 0 ; i < index ; i++) {
				leftInOrderList.add(inorder.get(i));
			}
			for(int i = index+1 ; i < inorder.size() ; i++) {
				rightInOrderList.add(inorder.get(i));
			}
			
			node.left = this.buildTree(preOrderQueue, leftInOrderList);
			node.right = this.buildTree(preOrderQueue, rightInOrderList);
			
			return node;
		}
	}
}
