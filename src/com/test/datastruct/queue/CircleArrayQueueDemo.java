package com.test.datastruct.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
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

class CircleArrayQueue {
    int maxSize;
    int front;//头指针，指向队列的头元素，随着元素的移除而变动
    int rear;//尾指针，指向队列最后一个元素的后方，随着元素的加入而变动
    int[] array;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        array = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //rear指针本身就指向队列最后一个元素的后一个位置
        array[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    //取出队列中的一个元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能继续出队");
        }
        int pos = front;
        front = (front + 1) % maxSize;
        return array[pos];
    }

    //遍历队列中所有的元素
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //有效元素的个数(rear - front + maxSize) % maxSize
        for (int i = front, number = 0; number < ((rear - front + maxSize) % maxSize); i++, number++) {
            int pos = i % maxSize;//i代表队列头元素的位置，不断+1可能会发生越界，需要取模
            System.out.printf("array[%d]=%d\n", pos, array[pos]);
        }
    }
}
