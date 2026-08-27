/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode reverseList(ListNode head) {
        ListNode t1=head;
        ListNode t2=null;
        while(t1 != null){
            ListNode temp = t1;
            t1=t1.next;
            temp.next=t2;
            t2=temp;
        }
        return t2;
    }
}