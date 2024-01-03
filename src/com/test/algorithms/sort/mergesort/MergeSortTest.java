package com.test.algorithms.sort.mergesort;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] nums = {8,4,5,7,1,3,6,2};
        mergeSort(nums,0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void mergeSort(int[] nums,int left,int right){
    //直到left=right时就会停止递归，如nums[0]，nums[1]两个数分解，left=0,right=1,会直接执行到merge(nums,left,mid,right,temp);因此发生合并
    //因此在left=0,right=3的那个栈里，mergeSort(nums,0,1, temp)执行完毕，开始执行mergeSort(nums,2,3,temp)，这一步里执行合并之后
    //left=0,right=3的栈里执行merge(nums,0,1,3,temp);进行合并
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid + 1,right);
            merge(nums,left,right);
        }
    }
    public static void merge(int[] nums,int left,int right){
        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int t = 0;
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
        while (i <= mid){
            temp[t] = nums[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = nums[j];
            t++;
            j++;
        }
        for (int k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }
}
