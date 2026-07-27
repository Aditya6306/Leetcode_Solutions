/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) { 
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node pre = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            if(pre == null){
                q.add(null);
                Node curr = q.remove();
                if(curr != null && curr.left!=null) q.add(curr.left);
                if(curr != null && curr.right != null) q.add(curr.right);
                pre=curr;
                continue;
            }
            
            Node curr = q.remove();
            pre.next=curr;
            if(curr != null && curr.left!=null) q.add(curr.left);
            if(curr != null && curr.right != null) q.add(curr.right);
            pre = curr;
        }
        return root;
    }
}