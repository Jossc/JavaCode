package com.algorithm.quque;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Crazy
 * @date: 2020/3/28 22:34
 */
@Data
public class ListNode {

    private int index;

    private ListNode next;


    public ListNode reverseList(ListNode node) {
        ListNode prevNode = null;
        while (node != null) {
            ListNode current = node;
            node = node.next;
            current.next = prevNode;
            prevNode = current;
        }
        return prevNode;
    }
}

