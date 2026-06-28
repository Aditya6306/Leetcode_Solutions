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
        ListNode temp=head;
        while(temp!=null){
            curr = new ListNode(temp.val);
            temp=temp.next;
            curr.next=pre;
            pre=curr;
        }
        return curr;
    }
}