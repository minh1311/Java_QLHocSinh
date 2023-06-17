    
package model;

public class Student {
    private int student_id;
    private String student_name;
    private int year_birth;
    private int age;
    private String hometown;
    private int class_id;

    public Student() {
    }

    public Student(int student_id, String student_name, int year_birth, int age, String hometown, int class_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.year_birth = year_birth;
        this.age = age;
        this.hometown = hometown;
        this.class_id = class_id;
    }

    public Student(String student_name, int year_birth, int age, String hometown, int class_id) {
        this.student_name = student_name;
        this.year_birth = year_birth;
        this.age = age;
        this.hometown = hometown;
        this.class_id = class_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getYear_birth() {
        return year_birth;
    }

    public void setYear_birth(int year_birth) {
        this.year_birth = year_birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

   
    
}
