/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
		if(root != null){
			depth++;
			//暂时使用这个最简单的方法
			depth += max(maxDepth(root.left),maxDepth(root.right));		
		}
		return depth;
    }
	
	public static int max(int a, int b){
		return a>b?a:b;
	}
}