
package model;

import java.util.Date;


public class Class {
    private int class_id;
    private String class_name;
    private int course_id;
    private Date register_day;

    public Class() {
    }

    public Class(int class_id, String class_name, int course_id, Date register_day) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.course_id = course_id;
        this.register_day = register_day;
    }

    public Class(String class_name, int course_id, Date register_day) {
        this.class_name = class_name;
        this.course_id = course_id;
        this.register_day = register_day;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Date getRegister_day() {
        return register_day;
    }

    public void setRegister_day(Date register_day) {
        this.register_day = register_day;
    }
    
}
