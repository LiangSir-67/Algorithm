package cn.liangyy;

import java.util.Random;

/**
 * 双路快速排序
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-06-07-14:05
 */
public class DoubleWaysQuickSort {
    private DoubleWaysQuickSort() {
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        Random random = new Random();
        sort2ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int partition = partition(arr, l, r, random);
        sort2ways(arr, l, partition - 1, random);
        sort2ways(arr, partition + 1, r, random);

    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 生成[l,r]之间的随机索引  (random.nextInt(r - l + 1))生成的是[0,r]之间的随机索引
        int p = random.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        // arr[l+1...i-1] <= v;arr[j+1...r] >= v
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    // 交换元素位置
    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
