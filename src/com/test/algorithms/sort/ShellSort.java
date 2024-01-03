package com.test.algorithms.sort;

import java.util.Arrays;

//希尔排序,对插入排序的改进
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {8,9,1,7,2,3,5,4,6,0};
        shellSortByRemove(nums);
    }
    //用后移法实现的插入排序来完成每个分组的排序
    public static void shellSortByRemove(int[] nums){
        //gap代表步长，从nums.length / 2逐步变到1
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            //对每个分组进行用后移法实现的插入排序，见InsertSort类insertSort方法
            //i代表无序表中的每个数，因此从gap开始，j需要从后向前遍历自己分组的有序表，形成有序表
            for (int i = gap; i < nums.length; i++) {
                int value = nums[i];
                int index = i - gap;
                while (index >= i % gap && value < nums[index]){
                    nums[index + gap] = nums[index];
                    index -= gap;
                }
                //找到正确位置之后，index指向它的前一个位置
                nums[index + gap] = value;
            }
            //System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }
    //用交换法实现的插入排序来完成每个分组的排序
    public static void shellSortBySwap(int[] nums){
        int temp = 0;
        //gap代表步长，从nums.length / 2逐步变到1
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            //对每个分组进行用交换法实现的插入排序，见InsertSort类insertSortBySwap方法
            //j代表无序表中的每个数，因此从gap开始，j需要与自己分组的有序表进行交换，形成有序表
            for (int j = gap; j < nums.length; j++) {
                //对j用遍历交换来插入有序表，k与在自己之前相差一个gap的数比较，就和自己在一个分组中，然后自减gap,继续向前比较
                //j % gap代表自己分组的第一个数，如目前下标为6，步长为5，则分组第一个数下标是1，保证k大于j % gap是为了不越界
                //因为比较时需要有nums[k - gap]
                for (int k = j; k > j % gap; k -= gap) {
                    if(nums[k] < nums[k - gap]){
                        temp = nums[k];
                        nums[k] = nums[k - gap];
                        nums[k - gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
        }

    }
    //使用交换法，一步步地模拟希尔排序的过程
    public static void shellSortStepByStep(int[] nums){
        int temp = 0;
        //第一轮
        for (int i = 5; i < nums.length; i++) {
            //本质上使用不断交换实现的插入排序,用交换实现的插入排序见InsertSort类insertSortBySwap方法
            for (int j = i; j > i % 5; j -= 5) {
                if(nums[j] < nums[j - 5]){
                    temp = nums[j];
                    nums[j] = nums[j - 5];
                    nums[j - 5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        //第二轮
        for (int i = 2; i < nums.length; i++) {
            for (int j = i; j > i % 2; j -= 2) {
                if(nums[j] < nums[j - 2]){
                    temp = nums[j];
                    nums[j] = nums[j - 2];
                    nums[j - 2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        //第三轮
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if(nums[j] < nums[j - 1]){
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
