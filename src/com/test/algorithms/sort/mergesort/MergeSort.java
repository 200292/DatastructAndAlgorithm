package com.test.algorithms.sort.mergesort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {8,4,5,7,1,3,6,2};
        int[] temp = new int[nums.length];
        mergeSort(nums,0, nums.length - 1,temp);
        System.out.println(Arrays.toString(nums));
    }
    public static void mergeSort(int[] nums,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(nums, left, mid, temp);
            //向右递归
            mergeSort(nums, mid + 1, right, temp);
            merge(nums,left,mid,right,temp);
        }
    }
    /**
     * 分解之后合并排序的方法
     * @param nums 待排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid 右边有序序列第一个数的前一个索引,左边序列的最后一个索引
     * @param right 右序列的最后一个数的索引
     * @param temp 保存排序后中间值的数组，最后将值赋给原始数组
     */
    public static void merge(int[] nums, int left, int mid, int right, int[] temp){
        System.out.println(left + " " + right);
        int i = left;
        int j = mid + 1;
        int t = 0;//代表temp数组当前的索引
        //阶段一：i，j分别向后移动，将较小的填入temp数组，直到左右两个序列中一个序列遍历完毕
        while (i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[t] = nums[i];
                t++;
                i++;
            }else {
                temp[t] = nums[j];
                t++;
                j++;
            }
        }
        //阶段二：左右其中一个序列遍历完毕，将另一个剩余的序列全部填入到temp数组中
        while (i <= mid){//左边剩余
            temp[t] = nums[i];
            t++;
            i++;
        }
        while (j <= right){//右边剩余
            temp[t] = nums[j];
            t++;
            j++;
        }
        //阶段三：将temp数组的值赋给原始数组
        //并不是每次都将temp数组的值全部赋完，如左右序列共2个数，left=2,right=3,只需要赋两个数即可
        for (int k = 0; k <= right - left; k++) {
            nums[left + k] = temp[k];
        }
    }
}
