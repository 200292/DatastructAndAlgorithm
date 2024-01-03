package com.test.algorithms.search;
//线性查找算法
public class SequenceSearch {
    public static void main(String[] args) {
        int[] nums = {1,9,11,-1,34,89,};
        System.out.println(sequenceSearch(nums,34));
    }
    public static int sequenceSearch(int[] nums,int key){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key){
                return i;
            }
        }
        return -1;
    }
}
