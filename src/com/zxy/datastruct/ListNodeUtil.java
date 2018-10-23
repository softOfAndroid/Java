package com.zxy.datastruct;

/**
 * @Auther: zxy
 * @Date: 2018/7/17 16:39
 * @Des: LeetCode 链表相关算法
 */
public class ListNodeUtil {
    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
         ListNode listNode = addTwoListNode();
         while (listNode != null) {
             System.out.println(listNode.value);
             listNode = listNode.next;
         }
    }

    public static ListNode addTwoListNode(){
        ListNode listNode = new ListNode(0);
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(6);
        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(5);
        node2.next.next = new ListNode(7);
        int carry = 0;
        while (node1 != null && node2 != null) {

        }
        return  listNode.next;
    }
}