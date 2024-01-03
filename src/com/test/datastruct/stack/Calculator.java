package com.test.datastruct.stack;
//实现表达式的计算
public class Calculator {
    public static void main(String[] args) {
        String expression = "3*3-4/2+1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        char currentChar = 0;
        int num1;
        int num2;
        int oper;
        int result = 0;
        while (index != expression.length()){
            currentChar = expression.charAt(index);
            //判断currentChar是否为一个运算符
            if(ArrayStack2.isOper(currentChar)){
                //是运算符,先判断运算符栈是否为空
                if(operStack.isEmpty()){
                    //为空直接入栈
                    operStack.push(currentChar);
                }else {
                    //运算符栈不为空时判断优先级
                    if(ArrayStack2.priority(currentChar) >= ArrayStack2.priority((char) operStack.peek())){
                        //如果当前的操作符优先级大于等于栈中的优先级，直接入栈
                        operStack.push(currentChar);
                    }else {
                        //如果当前的操作符优先级小于等于栈中的优先级，从数栈中弹出两个数与栈中的数进行计算，之后再入栈
                        num1 = numStack.pop();//先出栈的数
                        num2 = numStack.pop();//后出栈的数
                        oper = operStack.pop();
                        result = ArrayStack2.calculate(num1, num2, oper);
                        //计算结果入数栈
                        numStack.push(result);
                        //当前运算符入符号栈
                        operStack.push(currentChar);
                    }
                }
            }else {
                //是数字，直接入数栈
                //如果当前位是数字，还需要确定有几位数
                int endIndex = index;
                while (endIndex + 1 != expression.length() && !ArrayStack2.isOper(expression.charAt(endIndex + 1))) {
                    endIndex++;
                }
                //substring的原则是左取右不取，需要给endIndex加1
                String number = expression.substring(index,endIndex + 1);
                numStack.push(Integer.parseInt(number));
                index = endIndex;
                }
            index++;
        }
        //扫描完成之后，从数栈和符号栈pop出对应的数和符号，数栈中最后剩下的元素就是结果
        while (!operStack.isEmpty()){
            //最后运算结束时,符号栈为空
            num1 = numStack.pop();//先出栈的数
            num2 = numStack.pop();//后出栈的数
            oper = operStack.pop();
            result = ArrayStack2.calculate(num1, num2, oper);
            //计算结果入数栈
            numStack.push(result);
        }
        //最终结果保存在数栈中，数栈中只有唯一的结果
        System.out.println(numStack.peek());
    }
}
//拓展自ArrayStack
class ArrayStack2 {
    int maxSize;//栈的最大容量
    int top = -1;//代表栈顶,没有数据时初始值为-1
    int[] stack;//使用数组来储存栈的数据

    public ArrayStack2(int maxSize) {
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
    //遍历栈中的元素
    public void list(){
        int temp = top;
        while (temp != -1){
            System.out.printf("stack[%d]:%d\n",temp,stack[temp]);
            temp--;
        }
        System.out.println("遍历完成");
    }
    //返回运算符的优先级,返回值越大代表优先级越高
    public static int priority(char oper){
        //目前表达式中只有+-*/四种运算符
        if(oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    //判断是不是一个操作符
    public static boolean isOper(char value){
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    /**
     *
     * @param num1 先出栈的数，右操作数
     * @param num2 后出栈的数，左操作数
     * @param oper 操作符
     * @return 计算结果
     */
    public static int calculate(int num1,int num2,int oper){
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;//先弹出的数作为右操作数
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    //查看栈顶当前的元素，但并不真正的让它出栈
    public int peek(){
        return stack[top];
    }
}
