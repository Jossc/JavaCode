package com.algorithm.tree;

import lombok.Data;

import java.util.Objects;
import java.util.Stack;

/**
 * 二叉树 中序遍历
 *
 * @description:
 * @author: Crazy
 * @date: 2020/3/28 19:06
 */
@Data
public class TwoForkTree {


    public void preOrder(Node node) {
        if (Objects.nonNull(node)) {
            System.out.print(node.getIndex() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(Node node) {
        if (Objects.nonNull(node)) {
            inOrder(node.getLeft());
            System.out.println(node.getIndex());
            inOrder(node.getRight());
        }
    }


    public void preOrderNo(Node node) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (Objects.nonNull(node)) {
                System.out.print(node.getIndex() + "\t");
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            node = node.getRight();
        }
    }

    public static void main(String[] args) {
        Node node10 = new Node(10, null, null);
        Node node8 = new Node(8, null, null);
        Node node9 = new Node(9, null, node10);
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, node8, node9);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        Node node1 = new Node(1, node2, node3);
        TwoForkTree tree = new TwoForkTree();
        //采用递归的方式进行遍历
        System.out.println("-----前序遍历------");
        tree.preOrder(node1);
        System.out.println();
    }


    @Data
    public static class Node {

        private int index;

        private Node right;

        private Node left;


        public Node() {

        }

        public Node(int index, Node right, Node left) {
            this.index = index;
            this.right = right;
            this.left = left;
        }
    }
}
