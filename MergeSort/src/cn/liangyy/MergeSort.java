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
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, temp , 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, E[] temp, int l, int r){
        if (l >= r){
            return;
        }

        // l + r 有可能会出现超出整型所表示的范围  这里简单优化一下，就是将加法变成减法
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort(arr, temp, l, mid);
        sort(arr, temp, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0){
            merge2(arr, temp, l, mid, r);
        }
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
    private static <E extends Comparable<E>> void merge2(E[] arr, E[] temp, int l, int mid, int r){
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l;k <= r; k ++){
            if (i > mid){
                arr[k] = temp[j];
                j ++;
            }else if (j > r){
                arr[k] = temp[i];
                i ++;
            }else if (temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i];
                i ++;
            }else {
                arr[k] = temp[j];
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
