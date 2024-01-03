package com.test.datastruct.array;

import java.io.*;

/*
稀疏数组的示范
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //定义原始的二维数组
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        //将普通的二维数组转变为稀疏数组
        int sum = 0;
        //遍历，得到棋盘中不为0的总数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j] != 0){
                    sum++;
                }
            }
        }
        //根据得到的总数创建稀疏数组
        int[][] spareArray = new int[sum + 1][3];
        spareArray[0][0] = 11;
        spareArray[0][1] = 11;
        spareArray[0][2] = sum;
        int count = 1;
        //遍历，将每一个不为0的数放入稀疏数组，count用于指示是哪一个数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j] != 0){
                    spareArray[count][0] = i;
                    spareArray[count][1] = j;
                    spareArray[count][2] = chessArray[i][j];
                    count++;
                }
            }
        }
        //将稀疏数组写入文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\map.data"));
        for (int[] rows :spareArray) {
            for (int i :rows) {
                System.out.printf("%d\t",i);
                oos.writeInt(i);
            }
            System.out.println();
        }
        oos.close();//只有在close中才代表对文件的写入完毕，才能真正的写入文件

        //将文件中的稀疏数组读取出来
        System.out.println("====================");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\map.data"));
        for (int i = 0; i < spareArray.length; i++) {
            for (int j = 0; j < spareArray[0].length; j++) {
                System.out.printf("%d\t",ois.readInt());
            }
            System.out.println();
        }

        //将稀疏数组转为普通的二维数组
        int row = spareArray[0][0];
        int column = spareArray[0][1];
        int[][] chessArray2 = new int[row][column];
        //需要放入的数据个数存在spareArray[0][2]中
        for (int i = 0; i < spareArray[0][2]; i++) {
            chessArray2[spareArray[i + 1][0]][spareArray[i + 1][1]] = spareArray[i + 1][2];
        }


    }
}
