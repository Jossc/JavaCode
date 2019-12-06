package com.datastructure.queue;

/**
 * Lru Base Linked list
 *
 * @ClassName LRUBaseLinkedList
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019/12/5 1:19 下午
 **/
public class LruBaseLinkedList<T> {

    /**
     * 默认长度
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node<T> headNode;

    /**
     * 长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LruBaseLinkedList() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LruBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 添加元素
     *
     * @param data 元素
     */
    public void add(T data) {

    }

    private class Node<T> {

        private T element;

        private Node next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
