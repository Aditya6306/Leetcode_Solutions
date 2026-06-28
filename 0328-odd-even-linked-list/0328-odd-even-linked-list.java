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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = null;
        ListNode even = null;
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode next=null;
        int i=1;
        while(head!=null){
            next = head.next;
            head.next=null;
            if(i % 2==0){
                if(even == null) {
                    even = head;
                    evenHead=head;
                }
                else{
                    even.next=head;
                    even = head;
                }
            }
            else{
                if(odd == null) {
                    odd = head;
                    oddHead=head;
                }
                else{
                    odd.next=head;
                    odd = head;
                }
            }
            i++;
            head = next;
        }
        odd.next=evenHead;
        return oddHead;
    }
}