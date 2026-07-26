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
    public TreeNode invert(TreeNode root){
        if(root == null) return root;
        TreeNode temp = root.right;
        root.right=root.left;
        root.left=temp;
        invert(root.left);
        invert(root.right);
        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val ) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null )return true;
        TreeNode rightTree = invert(root.right);
        if(isSameTree(rightTree, root.left)) return true;
        return false;
    }
}