package LeetCodeMyself;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        pathSum(root, sum, new ArrayList<Integer>(), pathList);
        return pathList;
    }
	
	public void pathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> pathList) {
		if(node==null) {
			 return;
		 }
		
		 path.add(node.val);
		 
		 if(node.left==null && node.right==null) {
			 if(node.val==sum) {
				 List<Integer> newPath = new ArrayList<Integer>();
				 newPath.addAll(path);
				 pathList.add(newPath);
			 }
			 path.remove(path.size()-1);
			 return;
		 }

		 pathSum(node.left, sum-node.val, path, pathList);
		 pathSum(node.right, sum-node.val, path, pathList);
		 path.remove(path.size()-1);
	}
}
