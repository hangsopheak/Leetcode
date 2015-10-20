/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author SONGSONG
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode current = head.next;
        ListNode tmp = current.next;
        ListNode postnNode = tmp;
        for (int i = m; i < n; i++) {
            postnNode = postnNode.next;
            tmp.next = current;
            current = tmp;
            tmp = postnNode;
        }
        System.out.print(head.val);
        head.next.next = tmp;
        head.next = current;
        return dummy.next;
    }
}
