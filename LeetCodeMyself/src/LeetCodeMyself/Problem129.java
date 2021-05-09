package LeetCodeMyself;

import java.util.ArrayList;
import java.util.List;

public class Problem129 {
	public int sumNumbers(TreeNode root) {
        if(root==null) {
        	return 0;
        }else {
        	List<Integer> resultList = new ArrayList<Integer>();
        	this.populateLeafNumberList(root, 0, resultList);
        	int total = 0;
        	for(Integer leafNumber : resultList) {
        		total += leafNumber.intValue();
        	}
        	return total;
        }
    }
	
	public void populateLeafNumberList(TreeNode node, int prefixNo, List<Integer> leafNumberList) {
		if(node.left==null && node.right==null) {
			leafNumberList.add(prefixNo*10+node.val);
		}else {
			if(node.left!=null) {
				this.populateLeafNumberList(node.left, prefixNo*10+node.val, leafNumberList);
			}
			if(node.right!=null) {
				this.populateLeafNumberList(node.right, prefixNo*10+node.val, leafNumberList);
			}
		}
	}
}
