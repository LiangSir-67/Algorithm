package cn.liangyy;

import java.util.Arrays;

/**
 * 归并排序(其中包括两种方法：自顶向下、自底向上)
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-05-06-9:59
 */
public class MergeSort {
    private MergeSort() {
    }

    // 自顶向下的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, temp, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, E[] temp, int l, int r) {
        if (l >= r) {
            return;
        }

        // l + r 有可能会出现超出整型所表示的范围  这里简单优化一下，就是将加法变成减法
        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        sort(arr, temp, l, mid);
        sort(arr, temp, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, temp, l, mid, r);
        }
    }

    // 自底向上的归并排序
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {
            // 遍历合并的两个区间的起始位置
            /* 合并[i,i + sz -1]和Math.min(i + sz + sz -1, n - 1) */
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, temp, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                }
            }
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
    private static <E extends Comparable<E>> void merge(E[] arr, E[] temp, int l, int mid, int r) {
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
