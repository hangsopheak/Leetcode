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
public class SortList {

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tmp.next = head1;
                tmp = tmp.next;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                tmp = tmp.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            tmp.next = head2;
        } else {
            tmp.next = head1;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }
}
