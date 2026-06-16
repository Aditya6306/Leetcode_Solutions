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
    public void bfs(Queue<TreeNode> q, int l, List<List<Integer>> list){
        if(q.isEmpty()) return;

        TreeNode root = q.poll();
        if(list.size() < l+1) {
            ArrayList<Integer> arr = new ArrayList<>();
            list.add(arr);
        }
        list.get(l).add(root.val);

        if(root.left != null) q.add(root.left);
        bfs(q, l+1, list);
        if(root.right != null) q.add(root.right);
        bfs(q, l+1, list);
        

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        List<List<Integer>> list = new ArrayList<>();
        bfs(q, 0, list);
        return list;
    }
}