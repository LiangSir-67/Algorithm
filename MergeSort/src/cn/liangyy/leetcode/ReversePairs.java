package cn.liangyy.leetcode;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-06-02-10:15
 */
public class ReversePairs {
    // 1.暴露破解（超时，性能差）
    public int reversePairsViolence(int[] nums) {
        int res = 0;
        for (int i = 0;i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    res++;
                }
            }
        }
        return res;
    }


    // 2.使用归并排序
    public int reversePairs(int[] nums){
        int[] temp = new int[nums.length];
        return sort(nums, temp, 0, nums.length - 1);
    }


    private int sort(int[] arr, int[] temp, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mergeRes = 0;
        int mid = l + (r - l) / 2;
        mergeRes += sort(arr, temp, l, mid);
        mergeRes += sort(arr, temp, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            mergeRes += merge(arr, temp, l, mid, r);
        }
        return mergeRes;
    }

    private int merge(int[] arr, int[] temp, int l, int mid, int r) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int res = 0;

        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
        return res;
    }
}
