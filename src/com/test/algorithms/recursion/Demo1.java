package com.test.algorithms.recursion;

//递归的简单演示，打印问题和阶乘问题
public class Demo1 {
    public static void main(String[] args) {
        //test(10);
        System.out.println(factorial(4));
    }
    //打印问题
    public static void test(int n){
        if(n > 2){
            test(n - 1);
        }
        System.out.println(n);
    }
    //阶乘问题
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else {
            return n * factorial(n - 1);
        }
    }
}
