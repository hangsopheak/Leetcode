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
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode result = null;
        if (head == null) {
            return result;
        }
        ListNode small = head;
        while (small != null) {
            if (small.val < x) {
                break;
            }
            small = small.next;
        }
        ListNode big = head;
        while (big != null) {
            if (big.val >= x) {
                break;
            }
            big = big.next;
        }
        if (small == null || big == null) {
            return head;
        }
        result = small;
        ListNode bigstart = big;
        while (head != null) {
            if (head.val < x && head != small) {
                small.next = head;
                small = head;
            }
            if (head.val >= x && head != big) {
                big.next = head;
                big = head;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigstart;
        return result;
    }
}
