package com.test.datastruct.linkledist;

/**
 * 双向链表的展示
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(new Node(5));
        linkedList.add(new Node(3));
        linkedList.add(new Node(9));
        linkedList.list();
        //修改
        linkedList.update(new Node(3));
        linkedList.list();
        //删除
        linkedList.delete(9);
        linkedList.list();

        System.out.println("====================");
        DoubleLinkedList linkedList1 = new DoubleLinkedList();
        linkedList1.addByOrder(5);
        linkedList1.addByOrder(3);
        linkedList1.addByOrder(9);

        linkedList1.list();

    }
}

//双向链表
class DoubleLinkedList {
    public Node head;//双向链表的头节点

    public DoubleLinkedList() {
        this.head = new Node(0);
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加到双向链表的末尾
    public void add(Node node) {
        if (node == null) {
            System.out.println("想要添加的链表为空");
            return;
        }
        Node temp = head;
        //遍历让temp指向双向链表的最后一个节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //按照顺序添加到双向链表
    public void addByOrder(int element){
        Node node = new Node(element);
        //如果链表为空，直接添加到末尾
        if(head.next == null){
            head.next = node;
            node.pre = head;
            return;
        }
        //遍历查找到新节点所处的位置
        Node temp = head;
        while (true){
            //遍历到一个符合条件的节点
            if(temp.element >= element){
                node.next = temp;
                temp.pre.next = node;
                node.pre = temp.pre;
                temp.pre = node;
                break;
            }
            //先判断最后一个节点是不是符合要求，不符合条件，则直接加到最后
            if(temp.next==null){
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next;
        }

    }

    //修改元素值等于传入节点的元素值的节点
    public void update(Node node) {
        if (node == null) {
            System.out.println("传入的节点为空");
            return;
        }
        Node temp = head;
        while (temp != null) {
            //将符合条件的所有节点的值设为-1
            if (temp.element == node.element) {
                temp.element = -1;
            }
            temp = temp.next;
        }
    }

    //删除元素值为element的节点
    public void delete(int element) {
        if (head.next == null) {
            System.out.println("链表为空,无法删除");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            //让temp指向需要被删除的节点，自我删除即可
            if (temp.element == element) {
                temp.pre.next = temp.next;
                //如果需要删除的节点时链表的最后一个结点，会出现空指针异常，不需执行这一步操作
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }
}

//双向链表的每一个节点
class Node {
    public int element;
    public Node pre;//指向节点的前一个节点
    public Node next;//指向后一个节点

    public Node(int element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}
