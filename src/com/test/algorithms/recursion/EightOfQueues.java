package com.test.algorithms.recursion;

//八皇后问题
public class EightOfQueues {
    //皇后个数
    int max = 8;
    //用于保存八皇后问题的结果,数组中每个数据下标代表结果在第几行，数据的数值代表在第几列
    //如arr = {0,4,7,5,2,6,1,3},代表一种结果，皇后分别在第一行第一个，第二行第五个，第三行第八个等等
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        EightOfQueues eightOfQueues = new EightOfQueues();
        eightOfQueues.put(0);
        System.out.println(count);
    }

    public void put(int n) {
        if (n == max) {
            this.printPosition();
            //有一种解法之后，给解法总数加一
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                put(n + 1);
            }
        }
    }

    /**
     * 判断新放置一个皇后之后，判断是不是与之前的皇后冲突
     *
     * @param n 在下标为n的行放置了皇后,即放置了第n+1个皇后
     * @return 是否与之前冲突，为true代表不冲突
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //放置皇后时已经保证不在同一行，只需判断是否在同一列和同一斜线上
            //n - i == Math.abs(arr[n] - arr[i])  代表当斜率为1时，即在同一斜线上
            if (arr[i] == arr[n] || n - i == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void printPosition() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
