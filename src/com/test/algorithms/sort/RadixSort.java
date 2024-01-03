package com.test.algorithms.sort;

import java.util.Arrays;

//基数排序
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {53, 3, 542, 748, 14, 214};
        radixSort(nums);
    }

    public static void radixSort(int[] nums) {
        int[][] bucket = new int[10][nums.length];
        //用于记录各个桶中放入数据的情况，如bucket[2]桶中放了两个数据，则bucketRecord[2]=2
        int[] bucketRecord = new int[10];
        //得到最大数
        int max = nums[0];//最大数
        for (int i = 0; i < nums.length; i++) {
            if(max < nums[i]){
                max = nums[i];
            }
        }
        //得到最大数的位数
        int maxLength = (max + "").length();
        //第一轮先对个位数排序，第二轮对十位数排序，直到最后为最大数的最高位排序，k为最大数的位数
        for (int k = 0; k < maxLength; k++) {
            //遍历原始数组，根据个位的大小依次放进对应的桶中
            for (int i = 0; i < nums.length; i++) {
                //遍历个位数时，digit = nums[i] / 1 % 10,遍历十位数时，digit = nums[i] / 10 % 10,如542/10=544,54%10=4
                int digit = (nums[i] / (int) (Math.pow(10, k)) % 10);
                bucket[digit][bucketRecord[digit]] = nums[i];
                bucketRecord[digit]++;
            }
            int index = 0;
            //遍历桶，将数据依次放进原始数组中
            for (int i = 0; i < 10; i++) {
                //将i桶中的所有数据放入原来数组
                for (int j = 0; j < bucketRecord[i]; j++) {
                    nums[index] = bucket[i][j];
                    index++;
                    //如果桶中的数据都被放入原来的数组，直接退出，不需要继续遍历
                    if (index == nums.length) {
                        break;
                    }
                }
                //当前这个桶输出完毕之后，需要重新覆盖
                bucketRecord[i] = 0;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
