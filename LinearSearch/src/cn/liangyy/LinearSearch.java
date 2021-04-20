package cn.liangyy;

/**
 * 线性查找
 *
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-19-16:45
 */
public class LinearSearch {
    // 将构造器私有化，使用户在外部无法创建该类对象
    private LinearSearch(){}

    // 方法用static修饰，方便用户通过 类名.方法名 去调用
    public static <E> int search(E[] data, E target){
        for (int i = 0; i < data.length; i++) {
            // 判断类对象是否相等，不能使用 == （它判断的是引用是否相等）
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            // 因为Java泛型是不支持基本数据类型的，只支持类对象，所以我们这里需要使用int的包装类Integer
            Integer[] data = ArrayGenerator.generateOrderdArray(n);
            long startTime = System.nanoTime();
            for (int k = 0;k < 100;k++) {
                LinearSearch.search(data,n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ",100 runs : " + time + "s");
        }

    }
}
