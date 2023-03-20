package com.dvctt.yt.entity;

/**
 * @author etern
 */
public class Student {
    private String id;
    private String name;
    private String cap;
    private String teacher;

    public Student(String id, String name, String cap, String teacher) {
        this.id = id;
        this.name = name;
        this.cap = cap;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
