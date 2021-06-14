package cn.liangyy;

import java.util.Random;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-06-03-15:04
 */
public class QuickSort {

    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r,Random random){
        if (l >= r){
            return;
        }
        int partition = partition(arr, l, r, random);
        sort(arr, l, partition - 1, random);
        sort(arr, partition + 1, r, random);

    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random){
        // 生成[l,r]之间的随机索引  (random.nextInt(r - l + 1))生成的是[0,r]之间的随机索引
        int p = random.nextInt(r - l + 1) + l;
        swap(arr, l , p);

        // arr[l+1...j] < v;arr[j+1...i] > v
        int j = l;
        for (int i = l + 1; i <= r ; i++) {
            if (arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr, i ,j);
            }
        }
        // 此时 j 为基准点的索引
        swap(arr, l , j);
        return j;
    }

    // 交换元素位置
    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
