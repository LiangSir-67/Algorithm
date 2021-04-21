package cn.liangyy;

import java.util.Random;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-20-17:20
 */
public class ArrayGenerator {
    private ArrayGenerator(){}

    public static Integer[] generateOrderdArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个长度为 n 的随机数组，每个数字的范围是[0,bound)
     * @param n 数组大小
     * @param bound 随机数的上界
     * @return
     */
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new  Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}