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
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            } else {
                head = head.next;
            }
        }
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
