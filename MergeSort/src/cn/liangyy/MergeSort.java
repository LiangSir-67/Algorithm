package cn.liangyy;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-05-06-9:59
 */
public class MergeSort {
    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if (l >= r){
            return;
        }
        // l + r 有可能会出现超出整型所表示的范围  这里简单优化一下，就是将加法变成减法
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 合并两个有序的区间 arr[l,mid],arr[mid+1,r]
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
        E[] temp = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l;k <= r; k ++){
            if (i > mid){
                arr[k] = temp[j - l];
                j ++;
            }else if (j > r){
                arr[k] = temp[i - l];
                i ++;
            }else if (temp[i - l].compareTo(temp[j - l]) <= 0){
                arr[k] = temp[i - l];
                i ++;
            }else {
                arr[k] = temp[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        //Integer[] arr = new Integer[]{5, 8, 9, 4, 1, 3, 10, 11};
        SortingHelper.sortTest("MergeSort",arr);
    }
}
