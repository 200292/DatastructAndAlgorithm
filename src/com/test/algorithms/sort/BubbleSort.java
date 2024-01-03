package com.test.algorithms.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        //产生一个8万个数的数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 80000);//random方法产生0-1之间的小数，最终数组范围是0-800000
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间" + time1);
        //bubbleSort(nums);
        //SelectSort.selectSort(nums);
        InsertSort.insertSort(nums);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println("排序前时间" + time2);

    }
    public static void bubbleSort(int[] nums){
        //只需要进行总数-1趟的交换，最后一个数自然是排好序的
        for (int i = 0; i < nums.length - 1; i++) {
            int flag = 0;
            //从头向后进行一趟交换，直到最大的元素到达末尾
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = 1;
                }
            }
            //如果一趟比较下来没有发生交换，说明已经有序，则直接退出
            if(flag == 0){
                break;
            }
        }
    }
}
