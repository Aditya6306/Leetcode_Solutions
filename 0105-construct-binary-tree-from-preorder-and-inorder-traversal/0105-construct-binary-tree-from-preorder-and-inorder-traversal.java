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
    public TreeNode build(int[] preOrder, int[] inOrder, int i, int j, int m, int n){
        if(i>j) return null;
        if(i==j || m==n){
            TreeNode node = new TreeNode(preOrder[i]);
            return node;
        }

        TreeNode root = new TreeNode(preOrder[i]);
        int k;
        for(k=m;k<=n;k++){
            if(inOrder[k] == preOrder[i]) break;
        }
        int len = k-m;
        root.left = build(preOrder, inOrder, i+1, i+len, m, k-1);
        root.right = build(preOrder, inOrder, i+len+1, j, k+1, n);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return root;
    }
}