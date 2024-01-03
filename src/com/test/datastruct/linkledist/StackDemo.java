package com.test.datastruct.linkledist;

import java.util.Stack;

//演示栈的使用
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        while (stack.size() > 0){
            System.out.println(stack.pop());//取出栈顶的元素
        }
    }
}
