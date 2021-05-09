package LeetCodeMyself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem114 {
	public void flatten(TreeNode root) {
        List<Integer> numList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) {
        	return;
        }else {
        	queue.offer(root);
        }
        while(!queue.isEmpty()) {
        	TreeNode tmpNode = queue.poll();
        	numList.add(tmpNode.val);
        	if(tmpNode.left!=null) {
        		queue.offer(tmpNode.left);
        	}
        	if(tmpNode.right!=null) {
        		queue.offer(tmpNode.right);
        	}
        }
        Collections.sort(numList);
        TreeNode tmpNode;
        TreeNode prevNode = null;
        for(Integer num : numList) {
        	tmpNode = new TreeNode(num);
        	if(prevNode!=null) {
        		prevNode.right = tmpNode;
        	}else {
        		root = tmpNode;
        	}
        }
        
    }
}
