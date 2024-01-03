package com.test.algorithms.recursion;

//迷宫问题
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组，模拟迷宫
        int[][] map = new int[8][7];//包括墙壁
        //使用1代表墙
        //将第一行、最后一行全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //将第一列、最后一列全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //将第四行第二个，第四行第三个格子也设为墙壁
        map[3][1] = 1;
        map[3][2] = 1;

        findWay(map,1,1);
        //输出地图情况
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * 使用递归回溯来寻找小球出迷宫的路径
     * i,j表示开始的位置，从（1,1）到达（6,5）结束
     * map[i][j]为0时代表此处还未走过，1代表为墙壁;2代表是通路，能到达终点;3代表改点走过，走不通
     * 按照下-右-上-左的策略寻路
     * @param map 地图
     * @param i 开始位置横坐标
     * @param j 开始位置纵坐标
     * @return 是否找到路径
     */
    public static boolean findWay(int[][] map,int i,int j){
        if(map[6][5] == 2){//说明该路径可以走到终点
            return true;
        }else {
            if (map[i][j] == 0) {//如果当前点还未有人走过
                map[i][j] = 2;//假设当前需要探测的点走得通
                if (findWay(map, i + 1, j)) {//向下
                    return true;
                } else if (findWay(map, i, j + 1)) {//向右
                    return true;
                } else if (findWay(map, i - 1, j)) {//向上
                    return true;
                } else if (findWay(map, i, j - 1)) {//向左
                    return true;
                } else {
                    map[i][j] = 3;//如果上下左右都走不通之后，说明这个点走不通，设为3
                    return false;
                }
            } else {//如果map[i][j] ！= 0，即为1,2,3,代表需要探测的这个点是墙壁、走不通、已被探测过。则该点走不通
                return false;
            }
        }
    }
}
