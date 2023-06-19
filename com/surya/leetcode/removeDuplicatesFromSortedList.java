package com.surya.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode temp = head; // make a copy of head which will be used to iterate through.
        // Bcoz we are making a copy of user dfined type, it will be still pointing to
        // the original data structure. Any changes made to temp will impact head.
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next; // this will not impact head as we are reinitiating temp value to temp.next
                // We aren't changing the properties of temp [ like modifying temp.val /
                // temp.next]
            }
        }
        return head;
    }
}
