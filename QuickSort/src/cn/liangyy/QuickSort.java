package cn.liangyy;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-06-03-15:04
 */
public class QuickSort {

    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int partition = partition(arr, l, r);
        sort(arr, l, partition - 1);
        sort(arr, partition + 1, r);

    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r){
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
