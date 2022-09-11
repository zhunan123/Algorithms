class Student {
    public int id;

    public Student(int id) {
        this.id = id;
    }
}

public class Class {
    /**
     * Declare a public attribute `students` which is an array of `Student`
     * instances
     */
    // write your code here.
    public Student[] students;

    /**
     * Declare a constructor with a parameter n which is the total number of
     * students in the *class*. The constructor should create n Student
     * instances and initialized with student id from 0 ~ n-1
     */
    // write your code here
    public Class(int n) {
        //声明一个Student类型的数组
        //create a class object 里面有一个atrribute which is a students array
        //which calls the students another constructor Students
        this.students = new Student[n];
        for (int i = 0; i < n; i++) {
            //一定要new 一个student 出来，不new 的话就没有对象在，然后reference上面的
            //student constructor which passed in id

            //这里就是create id为 i的每一个学生object然后assign 给students array里面
            this.students[i] = new Student(i);
        }
    }

    public static void main(String[] args){
        //create a new class object called students with length of 20
        //students in the class;
        Class students = new Class(20);
    }
}
