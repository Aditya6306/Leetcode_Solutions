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
    public ListNode reverse(ListNode head, ListNode pre){
        if(head == null) return pre;

        ListNode curr= new ListNode(head.val);
        head=head.next;
        curr.next=pre;
        pre=curr;
        return reverse(head, pre);
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}