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
        // 因为Java泛型是不支持基本数据类型的，只支持类对象，所以我们这里需要使用int的包装类Integer
        Integer[] data = {24, 18, 12, 9, 16, 66, 21, 32, 5};
        // 找到返回索引位置
        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        // 未找到返回-1
        int res2 = LinearSearch.search(data, 567);
        System.out.println(res2);

        Student[] students = {
                new Student("183801","Alice"),
                new Student("183802","LiangSir"),
                new Student("183803","CoderTh")
        };
        Student LiangSir = new Student("183802","LiangSir");
        int res3 = LinearSearch.search(students, LiangSir);
        System.out.println(res3);
    }
}
