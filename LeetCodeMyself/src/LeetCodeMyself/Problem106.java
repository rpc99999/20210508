package LeetCodeMyself;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length == 0 && inorder.length == 0) {
        	return null;
        }else {
        	Stack<Integer> preOrderStack = new Stack<Integer>();
        	for(int i = 0 ; i < postorder.length; i++) {
        		preOrderStack.push(postorder[i]);
        	}
        	
        	List<Integer> inorderList = new ArrayList<Integer>();
        	for(int i = 0 ; i < inorder.length ; i++) {
        		inorderList.add(inorder[i]);
        	}
        	
        	return buildTree(preOrderStack, inorderList);
        }
    }
	
	public TreeNode buildTree(Stack<Integer> preOrderStack, List<Integer> inOrderList) {
		if(inOrderList.size()<=0) {
			return null;
		}else {
			int val = preOrderStack.pop();
			TreeNode node = new TreeNode(val);
			
			List<Integer> leftInOrderList = new ArrayList<Integer>();
			List<Integer> rightInOrderList = new ArrayList<Integer>();
			
			int index = inOrderList.indexOf(val);
			for(int i = 0 ; i < index ; i++) {
				leftInOrderList.add(inOrderList.get(i));
			}
			for(int i = index+1 ; i < inOrderList.size() ; i++) {
				rightInOrderList.add(inOrderList.get(i));
			}
			
			node.right = this.buildTree(preOrderStack, rightInOrderList);
			node.left = this.buildTree(preOrderStack, leftInOrderList);
			
			return node;
		}
	}
}
