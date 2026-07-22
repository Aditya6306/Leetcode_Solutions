/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum;
    public int calculate(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            sum++;
            return root.val;
        }

        int leftMax = calculate(root.left);
        int rightMax = calculate(root.right);

        if(root.val >= leftMax && root.val >= rightMax) sum++;
        return Math.max(root.val, Math.max(leftMax, rightMax));

    }
    public int countDominantNodes(TreeNode root) {
        sum=0;
        calculate(root);
        return sum;
    }
}