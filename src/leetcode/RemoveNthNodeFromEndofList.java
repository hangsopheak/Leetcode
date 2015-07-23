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
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        if (n == count) {
            return result.next;
        }
        ListNode tmp = result;
        for (int i = 0; i < count - n - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return result;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode addstart = new ListNode(0);
        addstart.next = head;
        ListNode slow = addstart;
        ListNode fast = addstart;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return addstart.next;
    }
}
