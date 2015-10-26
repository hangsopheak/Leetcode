/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SONGSONG
 */
public class InsertionSortList {

    public static ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        ListNode tmp = helper;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        tmp = helper;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        return helper.next;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        ListNode start = head.next;
        while (start != null) {
            ListNode post = start.next;
            head = dummy;
            while (start.val > head.next.val && start != head.next) {
                head = head.next;
            }
            if (start != head.next && start.val <= head.next.val) {
                start.next = head.next;
                head.next = start;
                pre.next = post;
            } else {
                pre = start;
            }
            start = post;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        insertionSortList2(l1);
    }
}
