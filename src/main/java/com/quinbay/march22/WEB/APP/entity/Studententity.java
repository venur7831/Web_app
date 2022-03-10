package com.quinbay.march22.WEB.APP.entity;

//import com.sun.javafx.beans.IDProperty;
//import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;
import javax.print.DocFlavor;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="student")

public class Studententity {
    public Studententity(String name, String lnmae) {
      //  this.id = id;
        this.name = name;
        this.lname = lname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name="id", nullable=false)

    private Integer id;
     @NotBlank (message = "student name cannot be empty")
    private String name;

//    public Studententity(Integer id, String fname, String lname, String branch) {
//    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    private String lname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return name;
    }

    public void setFName(String name) {
        this.name = name;
    }
}
