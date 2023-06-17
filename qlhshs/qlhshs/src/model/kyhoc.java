/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Hai Le
 */
public class kyhoc {
    private int ky_id;
    private String tenkyhoc;
    private Date start_day;
    private Date end_day;

    public kyhoc(int ky_id, String tenkyhoc, Date start_day, Date end_day) {
        this.ky_id = ky_id;
        this.tenkyhoc = tenkyhoc;
        this.start_day = start_day;
        this.end_day = end_day;
    }

    public kyhoc(String tenkyhoc, Date start_day, Date end_day) {
        this.tenkyhoc = tenkyhoc;
        this.start_day = start_day;
        this.end_day = end_day;
    }

    public int getKy_id() {
        return ky_id;
    }

    public void setKy_id(int ky_id) {
        this.ky_id = ky_id;
    }

    public String getTenkyhoc() {
        return tenkyhoc;
    }

    public void setTenkyhoc(String tenkyhoc) {
        this.tenkyhoc = tenkyhoc;
    }

    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public Date getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

    
}
