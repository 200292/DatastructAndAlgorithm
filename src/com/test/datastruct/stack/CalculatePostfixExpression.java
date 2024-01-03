package com.test.datastruct.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//演示逆波兰表达式（后缀表达式）的计算，使用jdk提供的stack
public class CalculatePostfixExpression {
    public static void main(String[] args) {
        String expression = "3 3 * 4 2 / - 1 +";
        System.out.println(expression + "的结果是" + calculate(expression));
    }

    public static List<String> getListString(String expression) {
        ArrayList<String> list = new ArrayList<>();
        String[] s = expression.split(" ");
        for (String element : s) {
            list.add(element);
        }
        return list;
    }


    /**
     * 计算后缀表达式的结果
     * 从左向右扫描后缀表达式，遇到数字时直接入数栈，遇到运算符，则弹出数栈的两个数进行操作，先弹出的为右操作数。
     * @param expression 后缀表达式，用空格分割
     * @return 计算结果
     */
    public static int calculate(String expression) {
        Stack<Integer> numStack = new Stack<>();
        List<String> elementList = getListString(expression);
        for (String item : elementList) {
            //使用正则表达式判断是不是数
            //当前是一个数
            if (item.matches("\\d+")) {//代表多位数
                numStack.push(Integer.parseInt(item));
            } else {//当前是一个操作符
                //先弹出来的是右操作数
                Integer num1 = numStack.pop();
                Integer num2 = numStack.pop();
                int result = 0;
                switch (item) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                //运算之后的结果入栈
                numStack.push(result);
            }
        }
        return numStack.pop();
    }
}
