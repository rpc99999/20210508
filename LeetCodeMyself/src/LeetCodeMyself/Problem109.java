package LeetCodeMyself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem109 {
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
        	return null;
        }else {
        	List<Integer> list = new ArrayList<Integer>();
        	ListNode node = head;
        	while(node!=null) {
        		list.add(node.val);
        		node = node.next;
        	}
        	return this.recursive(list, 0, list.size()-1);
        }
    }
	
	public TreeNode recursive(List<Integer> list, int from, int to) {
    	if(from > to) {
    		return null;
    	}
		
		int index = (from+to+1)/2;
    	int median = list.get(index);
    	
    	TreeNode node = new TreeNode(median);
    	
    	node.left = this.recursive(list, from, index-1);
    	node.right = this.recursive(list, index+1, to);
    	
    	return node;
	}
	
	public static void main(String[] args) {
		int[] test = {-10,-3,0,5,9};
		Problem109 testClass = new Problem109();
		
	}
}
