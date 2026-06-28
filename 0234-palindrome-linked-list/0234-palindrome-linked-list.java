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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        head=head.next;
        while(head!= null){
            sb.append(",");
            sb.append(head.val);
            head=head.next;
        }
        StringBuilder rev = new StringBuilder(sb);
        sb.reverse();
        
        return sb.compareTo(rev)==0;
    }
}