package com.test.algorithms.sort;

import java.util.Arrays;
//选择排序
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 9, 13, 7, 5, 2, 7};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void selectSort(int[] nums){
        //每一轮排序得到一个数的正确位置，则总共需要nums.length - 1轮排序，i代表乱序序列的开始索引
        for (int i = 0; i < nums.length - 1; i++) {
            //假定乱序序列的第一个数是最小数
            int min = nums[i];
            int index = i;
            //与乱序序列中的每一个数进行比较，得到最小数
            //不需要与自身进行比较,因此直接从i + 1开始
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            //说明乱序序列的第一个就是最小值，此时不需要交换，直接下一轮循环
            if(index == i){
                continue;
            }
            //进行交换，得到的最小数与乱序序列的第一个数进行交换
            nums[index] = nums[i];
            nums[i] = min;

        }
    }
}
