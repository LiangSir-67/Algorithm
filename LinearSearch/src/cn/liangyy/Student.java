package cn.liangyy;

import java.util.Objects;

/**
 * @Author: 梁歪歪 <1732178815@qq.com>
 * @Description: blog <liangyy.cn>
 * @Create 2021-04-19-17:21
 */
public class Student {

    private String userId;
    private String name;

    public Student(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // 自反性，传入自身
        if (this == o) return true;
        // 判断是否为空，是否是Student类型，this本身不可能为空，否则引发空指针异常
        if (o == null || getClass() != o.getClass()) return false;
        // 强制类型转换
        Student student = (Student) o;
        // 在判断字符串 userId，name是否相同
        return Objects.equals(userId, student.userId) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }
}
