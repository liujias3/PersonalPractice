package module3;

import java.util.Objects;

public class Student {
    //封装 student 类
    private int id;
    private String name;
    private int age;

    //重写 student equal方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    // constructor
    public Student(int id, String name, int age) {
        setId(id);
        setAge(age);
        setName(name);
    }

    // 重写 toString 了
    @Override
    public String toString() {
        return "学生信息 {" +
                "学号 = " + id +
                ", 姓名 = '" + name + '\'' +
                ", 年龄 = " + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
