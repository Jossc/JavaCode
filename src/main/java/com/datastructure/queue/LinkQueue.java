package com.datastructure.queue;

/**
 * 链表队列
 *
 * @ClassName LinkQueue
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/15 8:52 下午
 **/
public class LinkQueue<T> {

    private Node<T> head = null;

    private Node<T> tail = null;

    public void enqueue(String value) {
        if (tail == null) {
            Node<T> newNode = new Node<T>(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node<T>(value, null);
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }


    private static class Node<T> {

        private String data;

        private Node<T> next;

        public Node(String data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        LinkQueue<String> linkQueue =new LinkQueue<>();
        linkQueue.enqueue("hhhh");
        linkQueue.enqueue("hhhh1");
        linkQueue.enqueue("hhhh2");
        linkQueue.enqueue("hhhh3");
        linkQueue.dequeue();
    }

}


