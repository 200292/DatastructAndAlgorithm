package com.test.algorithms.search;
//插值查找算法
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
        System.out.println(insertValueSearch(nums,78,0,99));
    }
    public static int insertValueSearch(int[] nums,int key,int start,int end){
        System.out.println("hello");
        int mid = start + (key - nums[start]) * (end - start) / (nums[end] - nums[start]);
        //比如增加这些判断，否则会发生越界。如果key过大或者过小，那么在计算nums[mid]时会发生数组越界异常
        //如：key=10000,mid会远远超过end
        if (start > end || key < nums[start] || key > nums[end]) {
            return -1;
        }
        if (nums[mid] < key) {//说明要查找的数在mid右边
            return insertValueSearch(nums, key, mid + 1, end);
        } else if (nums[mid] > key) {//说明要查找的数在mid左边
            return insertValueSearch(nums, key, start, mid - 1);
        } else {//如果nums[mid]==key
            return mid;
        }

    }
}
