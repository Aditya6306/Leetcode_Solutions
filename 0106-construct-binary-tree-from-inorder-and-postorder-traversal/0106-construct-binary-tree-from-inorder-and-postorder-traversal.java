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
    public TreeNode build(int[] inorder, int[] postorder, int i, int j, int m, int n){
        if(i>j) return null;
        if(i==j || m==n){
            TreeNode root = new TreeNode(postorder[j]);
            return root;
        } 
        TreeNode root = new TreeNode(postorder[j]);
        int k;
        for(k=m;k<=n;k++){
            if(inorder[k] == postorder[j]) break;
        }
        int len = k-m;
        root.left = build(inorder, postorder, i, i+len-1, m, k-1);
        root.right = build(inorder, postorder, i+len, j-1, k+1, n);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        TreeNode root = build(inorder, postorder, 0, n-1, 0, n-1);
        return root;
    }
}