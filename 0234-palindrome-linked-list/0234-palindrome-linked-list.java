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
        if (head.next == null) {
            return true;
        }
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        int mid = size/2;
        temp = head;
        for (int i = 0; i < mid; i++) {
            st.push(temp.val);
            temp = temp.next;
        }
        if (size % 2 != 0){
            temp = temp.next;
        }
        while (temp != null) {
            if (st.pop() != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}