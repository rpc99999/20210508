package LeetCodeMyself;

public class Problem111 {
	 public int minDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			if(node.left != null && node.right != null) {
				return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
			}else if (node.left!=null) {
				return minDepth(node.left) +1;
			}else if(node.right!=null){
				return minDepth(node.right) +1;
			}else {
				return 1;
			}
		}
	}
}
