package com.test.datastruct.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//将中缀表达式转为后缀表达式的演示
public class InfixToPostfixConverter {
    public static void main(String[] args) {
        String infixExpression = "1+((2+3)*4)-50";//中缀表达式
        System.out.println(Converter("1+((2+3)*4)-50"));//输出转换后的后缀表达式
        System.out.println(CalculatePostfixExpression.calculate(Converter("1+((2+3)*4)-50")));//计算结果
    }

    public static List<String> getList(String infixExpression) {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        //循环遍历中缀表达式，储存在arraylist中
        while (index < infixExpression.length()) {
            char c = infixExpression.charAt(index);
            if (c < '0' || c > '9') {//当前字符不是数字时
                list.add(c + "");//将符号添加进集合
                index++;
            } else {//当前字符是数字时
                int endIndex = index;
                //当前字符是数字时,向后遍历，如果后续仍然是数字则进行拼接
                while (endIndex < infixExpression.length() && (c = infixExpression.charAt(endIndex)) >= '0' && c <= '9') {
                    endIndex++;
                }
                list.add(infixExpression.substring(index,endIndex));
                index = endIndex;
            }
        }
        return list;
    }

    /**
     * 将中缀表达式转为后缀表达式
     * @param infixExpression 字符串形式的中缀表达式
     * @return 后缀表达式的字符串形式,中间用空格分割
     */
    public static String Converter(String infixExpression){
        List<String> list = getList(infixExpression);
        Stack<String> operaStack = new Stack<>();//符号栈
        ArrayList<String> fixExpressionList = new ArrayList<>();//后缀表达式栈不需要出栈，而且需要逆序，可直接用arraylist
        for (String item : list) {
            if(item.matches("\\d+")){//操作数
                //如果是一个数，则直接加入后缀表达式
                fixExpressionList.add(item);
            }else if(item.equals("(")){
                //如果当前符号是左括号，直接加入符号栈
                operaStack.push(item);
            }else if(item.equals(")")){
                //如果是右括号，则依次弹出符号栈的运算符加入后缀表达式，直到遇到左括号，则这一对括号废弃
                while (!operaStack.peek().equals("(")){
                    fixExpressionList.add(operaStack.pop());
                }
                //左括号之前的操作符都被加入后缀表达式后，移除左括号
                operaStack.pop();
            }else{
                //如果当前符号是运算符
                if(operaStack.isEmpty() || operaStack.peek().equals("(")){
                    //如果符号栈为空或者栈顶为（,直接加入符号栈
                    operaStack.push(item);
                }else {
                    //如果当前符号优先级不大于栈顶符号优先级，不断弹出栈顶符号到后缀表达式中
                    while (operationPriority(item) <= operationPriority(operaStack.peek())){
                        fixExpressionList.add(operaStack.pop());
                        //每次弹出栈顶符号之后，判断是否为空或者栈顶为左括号
                        if(operaStack.isEmpty() || operaStack.peek().equals("(")){
                            break;
                        }
                    }
                    //如果当前符号优先级大于栈顶元素的优先级，直接加入符号栈
                    operaStack.push(item);
                }
            }
        }
        while (!operaStack.isEmpty()){
            fixExpressionList.add(operaStack.pop());
        }
        //得到后缀表达式，用空格分隔
        return String.join(" ", fixExpressionList);
    }


    //返回运算符的优先级,返回值越大代表优先级越高
    public static int operationPriority(String oper){
        //目前表达式中只有+-*/四种运算符
        if(oper.equals("*") || oper.equals("/")){
            return 1;
        }else if (oper.equals("+") || oper.equals("-")){
            return 0;
        }else {
            return -1;
        }
    }
}
