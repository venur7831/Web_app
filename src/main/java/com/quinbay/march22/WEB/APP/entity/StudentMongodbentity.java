package com.quinbay.march22.WEB.APP.entity;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Id;

@Document(collection = "student")
public class StudentMongodbentity {
    public StudentMongodbentity(Integer id, String fnmae, String lname, String branch) {
        this.id = id;
        this.fnmae = fnmae;
        this.lname = lname;
        this.branch = branch;
    }

    @MongoId
    private Integer id;
    private String fnmae;
    private String lname;
    private String branch;

//    public StudentMongodbentity(String fname,String Lname,Integer id,String branch) {
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFnmae() {
        return fnmae;
    }

    public void setFnmae(String fnmae) {
        this.fnmae = fnmae;
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
