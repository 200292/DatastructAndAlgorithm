package com.test.algorithms.sort;

import java.util.Arrays;
//简单插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 9, 13, 7, 5, 2, 7};
        insertSortBySwap(nums);
        System.out.println(Arrays.toString(nums));
    }
    //使用后移法实现的插入排序
    public static void insertSort(int[] nums){
        //初始情况下有序表只有第一个元素，后面的元素都属于无序表。则需要进行nums.length - 1轮插入
        for (int i = 1; i < nums.length; i++) {
            //每次选取无序表的第一个元素来插入
            int insertValue = nums[i];
            //index是有序表中的元素下标
            int index = i - 1;
            //从后向前遍历有序表，查找应该插入的位置。
            while (index >= 0 && insertValue < nums[index]){
                //如果不符合要求，则向后挪一位，为找到正确位置后腾出空间
                nums[index + 1] = nums[index];
                index--;
            }
            //index是符合要求的位置的前一个位置，如从小到大排序，nums[index]会小于insertValue,则应该插在它的后面
            if(index + 1 == i){//如果无序表的第一个元素位置就是它应当插入的位置
                continue;
            }
            nums[index + 1] = insertValue;
        }
    }
    //使用交换法实现的插入排序
    public static void insertSortBySwap(int[] nums){
        //插入排序刚开始的时候，默认第一个数就是有序表，后面是无序表，从无序表中第一个数插入有序表中，因此i从1开始，
        for (int i = 1; i < nums.length; i++) {
            //使用不断交换来实现插入排序，每次从无序表中读取一个数，不断向前遍历，交换，直到遇到正确的位置
            //j是指无序表的第一个数，从j向有序表往前遍历，为了保证j到达正确的位置，j需要大于有序表的第一个位置，每次减一次步长
            for (int j = i; j > 0; j--) {
                //如果有序表中的这个数大于无序表中的数，则需要交换
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
