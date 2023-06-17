
package model;

import java.sql.Date;


public class Course {
    private int course_id;
    private String course_name;
    private int ky_id;

    public Course(int course_id, String course_name, int ky_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.ky_id = ky_id;
    }

    public Course(String course_name, int ky_id) {
        this.course_name = course_name;
        this.ky_id = ky_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getKy_id() {
        return ky_id;
    }

    public void setKy_id(int ky_id) {
        this.ky_id = ky_id;
    }

    
    
}
