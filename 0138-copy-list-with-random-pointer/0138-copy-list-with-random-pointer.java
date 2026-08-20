/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Integer> map = new HashMap<>();
        int i=1;
        Node temp = head;
        while(temp != null){
            map.put(temp, i++);
            temp=temp.next;
        }

        temp=head;
        Node pre = null;
        i=1;
        Node newHead=null;
        HashMap< Integer, Node> map2 = new HashMap<>();
        while(temp != null){
            Node t = new Node(temp.val);
            map2.put(i++, t);
            if(pre==null) {
                pre=t;
                newHead = t;
            }
            else{
                pre.next=t;
                pre=t;
            }
            temp=temp.next;
        }

        temp = head;
        Node temp2=newHead;
        while(temp!=null){
            if(temp.random == null){
                temp2.random = null;
            }
            else{
                Node rnd = temp.random;
                int pointingTo = map.get(rnd);
                Node ref = map2.get(pointingTo);
                temp2.random = ref;
            }
            
            temp=temp.next;
            temp2=temp2.next;
        }
        return newHead;
    }
}