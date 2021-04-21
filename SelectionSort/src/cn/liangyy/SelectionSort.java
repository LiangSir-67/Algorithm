package cn.liangyy;

/**
 * 选择排序
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-21-10:39
 */
public class SelectionSort {
    private SelectionSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        // arr[0...i]是有序的 arr[i...n]是无序的
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i...n]中的最小值索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    /**
     * 交换两个元素的位置
     * @param arr
     * @param i
     * @param minIndex
     */
    private static <E> void swap(E[] arr, int i, int minIndex) {
        E t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort",arr);
        }


        System.out.println();

        /**
         * 通过实现Comparable接口来排序类对象
         * 对应的Student类必须实现Comparable接口，并实现抽象方法compareTo（比较规则）
         */
        Student[] students = {
                new Student("Alice",86),
                new Student("LiangSir",98),
                new Student("CoderTh",79)
        };
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
