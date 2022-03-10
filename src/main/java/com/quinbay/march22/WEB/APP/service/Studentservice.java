package com.quinbay.march22.WEB.APP.service;

import com.quinbay.march22.WEB.APP.dto.Student;
import com.quinbay.march22.WEB.APP.entity.StudentMongodbentity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface  Studentservice {
    List<Student>getAllStudents();
     Student getStudent(Integer id, String fname);
      void addStudent(Student student,Integer number);
      void updateStudent(Student student,Integer number);
      void deleteStudent(Integer id,Integer number);

}
