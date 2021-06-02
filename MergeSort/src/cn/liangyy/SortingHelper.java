package cn.liangyy;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-21-11:18
 */
public class SortingHelper {
    private SortingHelper() {
    }

    /**
     * 判断数组是否有序
     *
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {
        long startTime = System.nanoTime();
        if (sortname.equals("InsertionSort")) {
            //InsertionSort.sort(arr);
        } else if (sortname.equals("InsertionSort2")) {
            //InsertionSort.sort2(arr);
        }else if (sortname.equals("MergeSort")) {
            MergeSort.sort(arr);
        }else if (sortname.equals("MergeSort2")) {
            MergeSort_Optimize.sort2(arr);
        }else if (sortname.equals("MergeSort3")) {
            MergeSort_Optimize.sort3(arr);
        }else if (sortname.equals("MergeSort4")) {
            MergeSort_Optimize.sort4(arr);
        }else if (sortname.equals("MergeSortBU")) {
            MergeSort.sortBU(arr);
        }else if (sortname.equals("MergeSortBUOpt")) {
            MergeSort_Optimize.sortBUOpt(arr);
        }

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        // 如果数组是无序的，抛出异常
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + " failed...");
        }
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}
