package com.test.datastruct.queue;

import java.util.Scanner;

/**
 * 演示一个用数组实现的普通队列的使用
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("\n请输入你想要对队列进行的操作");
            System.out.println("(a)add添加元素");
            System.out.println("(s)show展示队列元素");
            System.out.println("(g)get取出一个队列元素");
            System.out.println("(e)退出程序");
            char key = scanner.next().charAt(0);
            switch (key) {
                //添加元素
                case 'a':
                    System.out.println("请输入想要添加的元素");
                    int element = scanner.nextInt();
                    arrayQueue.addQueue(element);
                    break;
                //展示队列元素
                case 's':
                    arrayQueue.showQueue();
                    break;
                //取出一个队列元素
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.println("取出的数据是" + result);
                    } catch (Exception e) {
                        //如果队列已空，此时再取出元素会抛出异常提示队列已空，将异常信息在此处输出
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;

            }
        }
    }
}

/**
 * 用数组实现的普通队列
 */
class ArrayQueue {
    int maxSize;//表示数组的最大容量
    int front;//表示队列头，但指向的是队列头的前一个位置
    int rear;//表示队列尾，具体指向队列尾部的元素
    int[] array;//表示元素存储的位置

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;//表示指向的是队列头的前一个位置。
        rear = -1;//指向的是队列尾的元素
        array = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //当队列添加元素时，只需要移动尾指针
    public void addQueue(int element) {
        if (isFull()) {
            System.out.println("队列已满，无法加入");
            return;
        }
        rear++;//尾指针后移，尾指针的位置就是尾部元素添加的位置
        array[rear] = element;
    }

    //取出队列中的一个元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能继续出队");
        }
        front++;//头指针后移
        return array[front];
    }

    //遍历队列中所有的元素
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front + 1; i < rear + 1; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }
}
