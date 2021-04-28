package cn.liangyy.recursion;

/**
 * 数组求和（递归实现）
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-28-9:47
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n]这个区间内所有数字的和
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr,int l){
        if (l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr, l+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 7, 4};
        System.out.println(sum(arr));
    }
}
