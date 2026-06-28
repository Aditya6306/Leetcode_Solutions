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
        ListNode curr = null;
        ListNode pre = null;
        ListNode n=head;
        while(head!=null){
            n=head.next;
            head.next=pre;
            pre=head;
            head=n;
        }
        return pre;
    }
}