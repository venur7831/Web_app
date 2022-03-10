package com.quinbay.march22.WEB.APP.repository;

import com.quinbay.march22.WEB.APP.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Studentdb {
    public List<Student> st = new ArrayList();

    {
        Student st1 = new Student(23, "venu", "R", "ec");
        Student st2 = new Student(34, "suresh", "M", "CS");
        Student st3 = new Student(1, "mahesh", "y", "it");
        st.add(st1);
        st.add(st2);
        st.add(st3);
        getstatement();
    }

    public List<Student> getstatement() {


        return st;
    }

    public void addStudent(Student student) {
        st.add(student);
    }

    public Student updateStudent(Student student){
        for(Student i : st){
            if(i.getId() == student.getId()){
                i.setFname(student.getFname());
                i.setLname(student.getLname());
                i.setBranch(student.getBranch());
                return new Student(i.getId(), i.getFname(), i.getLname(), i.getBranch());
            }
        }
        return null;
    }
        public void deleteStudent ( int id){

            for (Student i : st) {
                if (i.getId() == id) {
                    st.remove(i);
                    break;
                }
            }
        }


}
