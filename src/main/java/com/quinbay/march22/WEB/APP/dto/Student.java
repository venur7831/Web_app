package com.quinbay.march22.WEB.APP.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Student implements Serializable {
    @NonNull
    public Integer id;

    @NotBlank(message = "name cannot be empty")
    public String fname;

    public String lname;
    public String branch;





    public Student(Integer id, String fname, String lname, String branch) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.branch = branch;
    }

    public Student()
    {


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
