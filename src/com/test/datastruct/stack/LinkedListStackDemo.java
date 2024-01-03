package com.test.datastruct.stack;

import java.util.Stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStackByHeadInsertion stack = new LinkedListStackByHeadInsertion();
        stack.push(5);
        stack.push(1);
        stack.push(9);
        stack.push(3);
        stack.list();
        System.out.println("======================");
        System.out.println(stack.pop());
        System.out.println("======================");
        stack.list();
    }
}

/**
 * 使用单向链表实现的栈，尾插法,将新插入的节点插入链表的末尾，插入简单，删除效率低，需要从头遍历到前一个节点
 */
class LinkedListStackByTailInsertion {
    StackNode head = new StackNode();
    StackNode top = head;

    public boolean isEmpty() {
        return top == head;
    }

    public void push(int element) {
        top.next = new StackNode(element);
        top = top.next;
    }

    public StackNode pop() {
        if (isEmpty()){
            System.out.println("栈为空");
            return null;
        }
        //创建临时指针temp，让它指向需要被移除栈顶元素的底部元素
        StackNode temp = head;
        while (temp.next != top) {
            temp = temp.next;
        }
        //返回需要被移除的元素
        StackNode result = temp.next;
        //断开指针
        temp.next = null;
        //让top重新指向栈顶
        top = temp;
        return result;
    }

    //使用jdk提供的栈来逆向遍历使用链表实现的栈
    public void list() {
        Stack<StackNode> stack = new Stack<>();
        StackNode temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            StackNode node = stack.pop();
            System.out.println(node);
        }
    }
}

/**
 * 使用单向链表实现的栈，头插法，将新插入的节点插入头节点的后面，便于遍历和删除
 */
class LinkedListStackByHeadInsertion {
    StackNode head = new StackNode();
    public boolean isEmpty() {
        return head.next == null;
    }
    //直接将新插入的节点加到头结点之后
    public void push(int element){
        StackNode newNode = new StackNode(element);
        newNode.next = head.next;
        head.next = newNode;
    }
    //出栈，直接让头节点指向要移除节点的后一个节点
    public StackNode pop(){
        if(isEmpty()){
            System.out.println("栈已空");
            return null;
        }
        StackNode result = head.next;
        head.next = head.next.next;
        return result;
    }
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        StackNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class StackNode {
    int element;
    StackNode next;

    public StackNode() {

    }

    public StackNode(int element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "element=" + element +
                '}';
    }
}
