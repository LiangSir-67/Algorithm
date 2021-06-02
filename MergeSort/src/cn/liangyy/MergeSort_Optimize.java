package cn.liangyy;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-05-06-9:59
 */
public class MergeSort_Optimize {
    private MergeSort_Optimize(){}

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
     * sort2为 优化1
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort2(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r){
        if (l >= r){
            return;
        }
        // l + r 有可能会出现超出整型所表示的范围  这里简单优化一下，就是将加法变成减法
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        // 优化1： 在数组有序的情况下 ， 该算法能提升差不多200倍的性能
        if (arr[mid].compareTo(arr[mid + 1]) > 0){
            merge(arr, l, mid, r);
        }
    }

    /**
     * sort3为 优化2
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3(E[] arr){
        sort3(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r){
        //if (l >= r){
        //    return;
        //}

        if (r - l <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }

        // l + r 有可能会出现超出整型所表示的范围  这里简单优化一下，就是将加法变成减法
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort3(arr, l, mid);
        sort3(arr, mid + 1, r);
        // 优化1： 在数组有序的情况下 ， 该算法能提升差不多200倍的性能
        if (arr[mid].compareTo(arr[mid + 1]) > 0){
            merge(arr, l, mid, r);
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


    /**
     * sort4为 优化3
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort4(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);

        sort4(arr, temp , 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort4(E[] arr, E[] temp, int l, int r){
        //if (l >= r){
        //    return;
        //}

        if (r - l <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }

        // l + r 有可能会出现超出整型所表示的范围  这里简单优化一下，就是将加法变成减法
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort4(arr, temp, l, mid);
        sort4(arr, temp, mid + 1, r);
        // 优化1： 在数组有序的情况下 ， 该算法能提升差不多200倍的性能
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
        // 优化3： 内存操作优化
        System.arraycopy(arr, l, temp, l, r - l + 1);
        //E[] temp = Arrays.copyOfRange(arr, l, r+1);

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


    // 自底向上的归并排序
    public static <E extends Comparable<E>> void sortBU(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz){
            // 遍历合并的两个区间的起始位置
            /* 合并[i,i + sz -1]和Math.min(i + sz + sz -1, n - 1) */
            for (int i = 0; i + sz < n; i += sz + sz){
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0){
                    merge2(arr, temp, i, i + sz -1, Math.min(i + sz + sz -1, n - 1));
                }
            }
        }
    }

    // 使用插入排序优化 自底向上的归并排序
    public static <E extends Comparable> void sortBUOpt(E[] arr){

        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 使用插入排序优化
        // 遍历一遍，对所有 arr[i, i + 15] 的区间，使用插入排序法
        for(int i = 0; i < n; i += 16)
            InsertionSort.sort(arr, i, Math.min(n - 1, i + 15));

        // 遍历合并的区间长度
        // 注意，sz 从 16 开始
        for(int sz = 16; sz < n; sz += sz){

            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, i + sz + sz - 1]
            for(int i = 0; i + sz < n; i += sz + sz)
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge2(arr, temp, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
        }
    }

    public static void main(String[] args) {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arrBUOpt = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);
        SortingHelper.sortTest("MergeSort3",arr3);
        SortingHelper.sortTest("MergeSort4",arr4);
        SortingHelper.sortTest("MergeSortBUOpt",arrBUOpt);
    }
}
