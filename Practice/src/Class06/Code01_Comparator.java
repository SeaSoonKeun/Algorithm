package Class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Auther: xucg
 * @Date: 2021/6/15 - 06 - 15 - 8:01 下午
 * @Description: 比较器
 * 比较器的实质就是重载比较运算符
 * 可以很好地应用在特殊标准的排序上
 * 适用于范型编程
 *
 * 在算法题中，如果重点不是排序内容，可以问面试官是否可以使用比较器调用容器完成排序，减少排序时间。
 *
 * 统一约定：
 * 即如下方法：
 * @Override
 * public int compare(T o1, T o2) ;
 * 返回负数的情况，就是o1比o2优先的情况
 * 返回正数的情况，就是o2比o1优先的情况
 * 返回0的情况，就是o1与o2同样优先的情况
 */
public class Code01_Comparator {

    public static class Student{
        public String name;
        public int id;
        public int age;
        public Student(String name, int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    // 继承比较类
    public static class IdAscendingComparator implements Comparator<Student>{

        // 重写compare方法
        @Override
        public int compare(Student o1, Student o2) {
            // id 升序 age降序排序
            return o1.id != o2.id ? o1.id - o2.id : o2.age - o1.age;
        }
    }
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }
    public static void main(String[] args) {
        // 自定义数组
        Student student1 = new Student("A",2, 20);
        Student student4 = new Student("D",2, 22);
        Student student2 = new Student("B",1, 21);
        Student student3 = new Student("C",4, 22);
        Student[] students = new Student[]{student1, student2, student3,student4};

        System.out.println("origin print");
        System.out.println("====================");
        printStudents(students);

        Arrays.sort(students,new IdAscendingComparator());
        System.out.println("first print");
        System.out.println("====================");
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println(s.name + "," + s.id + "," + s.age);
        }

        // ArrayList容器
        System.out.println("second print");
        System.out.println("====================");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        // 自己定义的需要指定比较器，不然java会懵逼
        studentList.sort(new IdAscendingComparator());
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.println(s.name + "," + s.id + "," + s.age);
        }

        //TreeMap容器
        // 如果定义的比较器中只有ID，ID相同的不会覆盖，会保留原来的。
        System.out.println("Third print");
        System.out.println("====================");
//        TreeMap<Student, String> treeMap = new TreeMap<>(new IdAscendingComparator());
        // lambda 表达式
//        TreeMap<Student, String> treeMap = new TreeMap<>((o1, o2) -> (o1.id != o2.id ? o1.id - o2.id : o2.age - o1.age));
        TreeMap<Student, String> treeMap = new TreeMap<>((o1, o2) -> (o1.id - o2.id));
        treeMap.put(student1,"我是学生1，我的名字是A");
        treeMap.put(student2,"我是学生2，我的名字是B");
        treeMap.put(student3,"我是学生3，我的名字是C");
        treeMap.put(student4,"我是学生4，我的名字是D");
        for(Student s : treeMap.keySet()){
            System.out.println(s.name + "," + s.id + "," + s.age);
        }
    }

}
