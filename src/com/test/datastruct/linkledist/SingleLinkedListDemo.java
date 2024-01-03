package com.test.datastruct.linkledist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 单链表演示
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(4, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(9, "吴用", "智多星");
        HeroNode node4 = new HeroNode(6, "林冲", "豹子头");
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node4);
        linkedList.list();
        System.out.println("================================");
        HeroNode node5 = new HeroNode(10, "卢俊义", "玉麒麟");
        HeroNode node6 = new HeroNode(7, "吴用", "智多星");
        HeroNode node7 = new HeroNode(3, "林冲", "豹子头");
        SingleLinkedList linkedList1 = new SingleLinkedList();
        linkedList1.addByOrder(node5);
        linkedList1.addByOrder(node6);
        linkedList1.addByOrder(node7);
        linkedList.MergeSortedLinkedList(linkedList1.head);
        linkedList.list();
    }
}

class SingleLinkedList {
    public HeroNode head;

    public SingleLinkedList() {
        this.head = new HeroNode(0, null, null);
    }

    /**
     * 将节点添加到单链表的末尾
     *
     * @param node 想要添加的节点
     */
    public void add(HeroNode node) {
        //首先需要辅助变量来帮助遍历到链表尾部，便于将新加入的节点插入
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //遍历结束之后temp指向链表的最后一个节点
        temp.next = node;
    }

    /**
     * 按照插入节点的编号顺序插入
     *
     * @param node
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            //说明需要添加的节点应该位于链表的最后，链表为空或者没有比需要添加编号更大的节点，只能添加到最后
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            //插入的节点应该位于temp的后面
            if (temp.next.order > node.order) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            //添加的编号已经存在
            if (temp.next.order == node.order) {
                System.out.println("排名已存在,不能添加");
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int order) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("想要删除的节点不存在");
                break;
            }
            if (temp.next.order == order) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改一个节点
     *
     * @param newHeroNode 参数节点的编号与想要修改的节点一致，按照参数的属性来修改节点
     */
    public void update(HeroNode newHeroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                System.out.printf("没有找到编号为%d的节点", newHeroNode.order);
                return;
            }
            if (temp.order == newHeroNode.order) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 遍历输出整个链表
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //链表不为空
        HeroNode temp = head.next;
        while (true) {
            System.out.println(temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }

    /**
     * @return 返回单链表有效的节点个数
     */
    public int getLength() {
        HeroNode temp = head;
        int count = 0;
        while (true) {
            temp = temp.next;
            if (temp == null) {
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * 查找单链表中的倒数第index个节点
     *
     * @param index 倒数第index个节点
     * @return 返回查找到的节点
     */
    public HeroNode findLastIndexNode(int index) {
        int length = getLength();
        //链表为空或者index不合法
        if (head.next == null || length < index || index <= 0) {
            return null;
        }
        HeroNode temp = head;
        for (int i = 0; i < length - index + 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 翻转一个单链表
     */
    public void reverseList(){
        HeroNode newHead = new HeroNode(0, null, null);
        //head是链表的头节点
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //指向当前的节点
        HeroNode current = head.next;
        //指向当前节点的下一个节点
        HeroNode next = null;
        while (current != null){
            next = current.next;
            current.next = newHead.next;//让当前结点指向新的头部后面的所有节点
            newHead.next = current;//让新的头部指向当前节点
            current = next;
        }
        head.next = newHead.next;
    }

    /**
     * 使用栈逆序打印单链表
     */
    public void reversePrint(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        //将链表中的所有节点压入栈中
        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }
        //逐个取出栈中的节点
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序的单链表，合并之后仍然有序
     * @param newHead 希望合并的另一个链表
     */
    public void MergeSortedLinkedList(HeroNode newHead){
        if(head.next == null && newHead.next == null){
            System.out.println("两个链表都为空，无法合并");
            return;
        }
        HeroNode current = newHead.next;
        HeroNode next = null;
        while (current != null){
            next = current.next;
            this.addByOrder(current);
            current = next;
        }
    }
}
/**
 * SingleLinkedlist的每一个节点
 */
class HeroNode {
    public int order;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int order, String name, String nickName) {
        this.order = order;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "order=" + order +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}