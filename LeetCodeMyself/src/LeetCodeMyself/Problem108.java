package LeetCodeMyself;

import java.util.ArrayList;
import java.util.List;

public class Problem108 {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		List<Integer> numsList = new ArrayList<Integer>();
		for(int i : nums) {
			numsList.add(i);
		}
		return this.sortedArrayToBST(numsList);
	}
	
    public TreeNode sortedArrayToBST(List<Integer> nums) {
        //take the median
    	if(nums == null || nums.size() <=0) {
    		return null;
    	}else {
    		int index = nums.size()/2;
    		int median = nums.get(index);
    		
    		List<Integer> leftNodeList = new ArrayList<Integer>();
    		List<Integer> rightNodeList = new ArrayList<Integer>();
    		for(int i = 0 ; i < index; i++) {
    			leftNodeList.add(nums.get(i));
    		}
    		for(int i = index+1 ; i < nums.size(); i++) {
    			rightNodeList.add(nums.get(i));
    		}
    		
    		TreeNode node = new TreeNode(median);
    		node.left = this.sortedArrayToBST(leftNodeList);
    		node.right = this.sortedArrayToBST(rightNodeList);
    		
    		return node;
    	}
    }
}
