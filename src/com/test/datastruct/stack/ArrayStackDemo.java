package com.test.datastruct.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(10);
//        arrayStack.push(5);
//        arrayStack.push(4);
//        arrayStack.push(8);
//        arrayStack.push(1);
//        arrayStack.list();
//        System.out.println("=============================");
//        arrayStack.pop();
//        arrayStack.list();
//        System.out.println("=============================");
//        arrayStack.pop();
//        arrayStack.list();
//        System.out.println("=============================");
//        arrayStack.pop();
//        arrayStack.list();
//        System.out.println("=============================");
//        arrayStack.pop();
//        arrayStack.list();

    }
}

/**
 * 使用数组实现的栈
 */
class ArrayStack {
    int maxSize;//栈的最大容量
    int top = -1;//代表栈顶,没有数据时初始值为-1
    int[] stack;//使用数组来储存栈的数据

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     * @param element 需要添加的元素
     */
    public void push(int element){
        //先判断栈是否已满
        if(isFull()){
            System.out.println("栈已满，不能继续添加");
            return;
        }
        top++;
        stack[top] = element;
    }

    /**
     * 出栈，返回栈顶的元素
     * @return 栈顶的元素
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空，无法出站");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        int temp = top;
        while (temp != -1){
            System.out.printf("stack[%d]:%d\n",temp,stack[temp]);
            temp--;
        }
        System.out.println("遍历完成");
    }
}
