package com.test.algorithms.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,8,10,89,1000,1234};
        System.out.println(binarySearch(nums,1000));
    }
    //普通二分查找算法
    public static int binarySearch(int[] nums, int key){
        int left = 0;
        int right = nums.length - 1;
        int current = (left + right) / 2;
        while (left <= right){
            if(nums[current] < key){
                left = current + 1;
            }else if(nums[current] > key){
                right = current - 1;
            }else {
                return current;
            }
            current = (left + right) / 2;
        }
        return -1;
    }

    //递归实现的二分查找
    public static int binarySearch(int[] nums, int key, int start, int end){
        int mid = (start + end) / 2;
        /*
          start和end不断向一起靠拢，最极端的情况是start和end重合，如果重合后比较num[mid]仍不相等
          则继续移动start或end,则会发生start > end，说明这时数组中不存在
         */
        if (start < end) {
            //start和end不断向一起靠拢，最极端的情况是start和end重合，如果重合后比较num[mid]仍不相等
            //则继续移动start或end,则会发生start > end，说明这时数组中不存在
            if (nums[mid] < key) {//说明要查找的数在mid右边
                return binarySearch(nums, key, mid + 1, end);
            } else if (nums[mid] > key) {//说明要查找的数在mid左边
                return binarySearch(nums, key, start, mid - 1);
            } else {//如果nums[mid]==key
                return mid;
            }
        }
        return -1;
    }

    //当数组中有重复元素时，可以查找重复元素的位置
    public static List<Integer> binarySearchRepeat(int[] nums, int key, int start, int end){
        int mid = (start + end) / 2;
        ArrayList<Integer> list = new ArrayList<>();//用于存放所有查找元素的下标
        if (start < end) {
            //start和end不断向一起靠拢，最极端的情况是start和end重合，如果重合后比较num[mid]仍不相等
            //则继续移动start或end,则会发生start > end，说明这时数组中不存在
            if (nums[mid] < key) {//说明要查找的数在mid右边
                return binarySearchRepeat(nums, key, mid + 1, end);
            } else if (nums[mid] > key) {//说明要查找的数在mid左边
                return binarySearchRepeat(nums, key, start, mid - 1);
            } else {//如果nums[mid]==key
                list.add(mid);
                int temp = mid + 1;
                //向mid的右边扫描，将所有等于key的元素下标加入到集合中
                while (temp <= nums.length - 1 && nums[temp] == key){
                    list.add(temp);
                    temp++;
                }
                temp = mid - 1;
                //向mid的左边扫描，将所有等于key的元素下标加入到集合中
                while (temp >= 0 && nums[temp] == key){
                    list.add(temp);
                    temp--;
                }
            }
        }
        return list;
    }
}
