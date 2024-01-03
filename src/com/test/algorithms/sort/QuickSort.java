package com.test.algorithms.sort;

import java.util.Arrays;

//快速排序，对冒泡排序的改进
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {50,60,70,80,10,20,40};
        quickSort(nums,0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums,int low,int high){
        //当low和high相等时，说明此时是在对一个元素进行划分，此时不需要再进行快排，返回上层。
        /*如10,20,30。此时20是pivot,对20的左侧右侧分别快排。即pos=1,low=0,high=2,执行quickSort(nums,0,1-1)，
        这个函数不会不符合条件退出，直接去执行quickSort(nums,1+1,2),也不符合条件退出，因此整个函数执行完毕，退出
        */
        if (low < high){
            int pos = partition(nums,low,high);
            //得到基准值的位置之后，对它左侧与右侧先后进行快排
            quickSort(nums,low,pos - 1);
            quickSort(nums,pos + 1,high);
        }
    }
    //传入一个数组，以及数组的开始下标和结束下标
    /*
    核心的思路是low不断向右边逼近，high不断向左边逼近，如果high位置的元素小于pivot就换到low的位置，low亦如是
    等到high与low相等时，说明大于pivot的元素都在这个位置右侧，小于的元素都在左侧
    high和low在对方把符合本侧大小的一个元素交换过来之后，就要向前移动，如pivot为20，high指向10，将10交换给num[low]之后
    肯定符合nums[low] < pivot，因此low++。保证pivot所处的位置一定是符合要求的
     */
    public static int partition(int[] nums,int low,int high){

        //将数组的第一个元素作为pivot
        int pivot = nums[low];
        //low与high交替遍历，直到low=high时说明找到pivot应该所处的位置
        while (low < high){
            /*
             *在内层设置一个 while (low < high)的判断是为了解决当high--，或low++的过程中，high=low的情况，说明找到pivot的位置
             * 执行：nums[low] = nums[high];nums[high] = nums[low];实际并未发生有效的交换
             * 最终的nums[low] = pivot;才实际地确定了pivot的位置
             * 如60,70这个数组，pivot=60,low=0,high=1。一开始nums[high] > pivot则high--,high=low=0,说明找到pivot位置
             * 第二次循环不会进去，两次交换都是在与自身交换，直到最后的nums[low] = pivot;确定pivot位置
             */
            while (low < high && nums[high] > pivot){
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < pivot){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        //返回的值是基准值所处的位置
        return low;
    }
}
