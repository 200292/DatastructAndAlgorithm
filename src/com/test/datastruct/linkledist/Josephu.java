package com.test.datastruct.linkledist;

/**
 * 约瑟夫问题的演示
 */
public class Josephu {
    public static void main(String[] args) {
        SingleCircleLinkedList linkedList = new SingleCircleLinkedList();
        linkedList.batchAdd(5);
        linkedList.countOrder(1,2,5);
    }
}

/**
 * 单向环形链表类
 */
class SingleCircleLinkedList {

    private Boy first;//first时刻指向链表的第一个节点。作用是添加了一个新节点之后让它知道如何指向第一个节点来完成环形
    private Boy current;//current时刻指向最后一个节点，作用是说明在哪一个节点后添加

    public Boy getFirst() {
        return first;
    }

    public void setFirst(Boy first) {
        this.first = first;
    }

    public Boy getCurrent() {
        return current;
    }

    public void setCurrent(Boy current) {
        this.current = current;
    }

    /**
     * 批量添加，调用单独添加的方法
     * @param nums 需要添加的个数
     */
    public void batchAdd(int nums){
        if(nums < 1){
            System.out.println("数据不合法");
            return;
        }
        for (int i = 1; i <= nums; i++) {
            add(i);
        }

    }

    //逐个添加到单向环形链表
    public void add(int no) {
        Boy boy = new Boy(no);
        if (first == null) {
            first = boy;
            boy.next = first;
            current = first;//current时刻指向链表的最后一个节点
        } else {
            current.next = boy;
            boy.next = first;
            current = boy;
        }
    }

    //遍历
    public void list(){
        if(first == null){
            System.out.println("链表为空,无法遍历");
            return;
        }
        Boy temp = first;
        while (true){
            System.out.println(temp);
            //说明已经遍历完毕
            if(temp.next == first){
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 执行报数并出队
     * @param startNumber 开始报数的小孩
     * @param countNumber 数几个数后出列
     * @param sum 表示初始情况共有多少人在圈中
     */
    public void countOrder(int startNumber,int countNumber,int sum) {
        if(first == null){
            System.out.println("链表为空,无法报数");
            return;
        }
        if(startNumber < 1 || startNumber > sum){
            System.out.println("开始报数的人的编号不合理");
            return;
        }
        //移动first,current,让first指向第一个开始报数的人，current在它的后面
        for (int i = 0; i < startNumber - 1; i++) {
            first = first.next;
            current = current.next;
        }
        while (true){
            //移动让first指向被删除的节点，current指向它的前一个节点
            for (int i = 0; i < countNumber - 1; i++) {
                first = first.next;
                current = current.next;
            }
            //输出节点信息
            System.out.println(first);
            //删除该节点
            first = first.next;
            current.next = first;
            //如果链表中只有一个节点，输出该节点信息后退出。
            if(current == first){
                System.out.println(first);
                break;
            }
        }
    }

    public void remove(Boy helper) {
        helper.next = helper.next.next;
    }

}

class Boy {
    public int no;//编号
    public Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
