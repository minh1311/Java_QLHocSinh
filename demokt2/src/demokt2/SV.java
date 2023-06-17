/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demokt2;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class SV implements Serializable {
    Scanner sc = new Scanner(System.in);
    
    private String name;
    private String id;
    private String sex;
    private String brith_year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrith_year() {
        return brith_year;
    }

    public void setBrith_year(String brith_year) {
        this.brith_year = brith_year;
    }

    @Override
    public String toString() {
        return "SV" + "name=" + name + ", id=" + id + ", sex=" + sex + ", brith_year=" + brith_year ;
    }
    
    public SV() {
    }

    public SV(String name, String id, String sex, String brith_year) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.brith_year = brith_year;
    }
    
    public void nhap()
    {
        System.out.println("Nhap MSV:");id=sc.nextLine();
        System.out.println("Nhap ten:");name=sc.nextLine();
        System.out.println("Nhap gioi tinh:");sex=sc.nextLine();
        System.out.println("Nhap nam sinh:");brith_year=sc.nextLine();
    }
}
