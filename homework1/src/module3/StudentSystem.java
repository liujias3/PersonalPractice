package module3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentSystem {
    //学生系统
    private List<Student> studentList=  new ArrayList<>();
    private Set<Integer> idList=  new HashSet<>();

    // 添加学生
    public void add(Student student){
        //判断学生年龄打过00 或者 学号为负数 或 已有这个学号 的
        if(student.getAge()>= 100 || student.getAge() <0){
            System.out.println("年龄过大或过小");
        }
        else if(student.getId()<0){
            System.out.println("学号不为负数");
        }
        else if(idList.contains(student.getId())){
            System.out.println("已经有这个学号的同学了");
        } else{
            studentList.add(student);
            idList.add(student.getId());
        }
    }

    //删除学生
    public void remove(Student student){
        //先尝试通过id找那个学生 如果不存在return null
        Student student1 = find(student.getId());
        //如果能找到学生 而且该学生 等于要删除学生 则删除
        //防止误删 所以需要输入 完整的学生信息
        if (student1 != null && student1.equals(student)){
            studentList.remove(student1);
            idList.remove(student.getId());
            System.out.println("成功删除");
        } else{
            System.out.println("没有和这个向匹配的同学");
        }
    }

    //更改交替学生
    public void replace(Student student){
        //先尝试通过id找那个学生 如果不存在return null
        Student student1 = find(student.getId());
        //如果能找到该学生 怎删除 并重新添加学生， 如果找不到 则直接添加
        if(student1 != null){
            studentList.remove(student1);
            studentList.add(student);
            System.out.println("成功删除添加");
        }else{
            studentList.add(student);
            idList.add(student.getId());
            System.out.println("没有找到匹配学院 默认添加为新学员");
        }
    }

    //通过学号找同学
    public Student find(int id){
        if(!idList.contains(id)){
            System.out.println("没有这个学号的同学了");
        }else{
            //遍历每一个学生
            for(Student student : studentList){
                if (student.getId() == id){
                    return student;
                }
            }
        }
        return null;
    }
}
