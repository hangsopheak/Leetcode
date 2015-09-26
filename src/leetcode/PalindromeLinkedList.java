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
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            count++;
            tmp = tmp.next;
        }
        int i = count / 2;
        tmp = head;
        for (; i > 0; i--) {
            tmp = tmp.next;
        }
        tmp = reverseList(tmp);
        while (head != null && tmp != null) {
            if (head.val != tmp.val) {
                return false;
            }
            head = head.next;
            tmp = tmp.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = null;
        ListNode newhead = reverseList(tmp);
        tmp.next = head;
        return newhead;
    }
}
