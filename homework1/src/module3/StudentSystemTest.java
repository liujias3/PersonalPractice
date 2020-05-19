package module3;

import java.util.*;

public class StudentSystemTest {
    private List<Student> list = new ArrayList<>();

    //构建学生
    public static Student buildStudent(Scanner sc){
        int id = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();
        Student student = new Student(id, name, age);
        return student;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while(true){
            System.out.println("请输入您需要的操作 1.增加学生 2.删除学生 3.修改学生信息 4.查找学生 5.退出");
            int operation = sc.nextInt();
            if(operation == 1){
                System.out.println("请输入您需要添加的学生的学号，姓名，年龄");
                Student student = buildStudent(sc);
                studentSystem.add(student);
            } else if(operation == 2){
                System.out.println("请输入您需要删除的学生的学号，姓名，年龄");
                Student student = buildStudent(sc);
                studentSystem.remove(student);
            } else if(operation == 3){
                System.out.println("请输入您需要修改的学生的学号，姓名，年龄");
                Student student = buildStudent(sc);
                studentSystem.replace(student);
            }else if(operation == 4){
                System.out.println("请输入您需要查找的学生的学号");
                int id = sc.nextInt();
                Student student = studentSystem.find(id);
                if(student != null)
                    System.out.println(student);
            }else{
                break;
            }
        }
        Map map = new HashMap<>();
        map.get("0");

    }

}
