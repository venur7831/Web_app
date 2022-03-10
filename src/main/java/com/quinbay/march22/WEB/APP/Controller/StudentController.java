package com.quinbay.march22.WEB.APP.Controller;

import com.quinbay.march22.WEB.APP.dto.Student;
import com.quinbay.march22.WEB.APP.entity.StudentMongodbentity;
import com.quinbay.march22.WEB.APP.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("Student")

public class StudentController {
    @Autowired
    Studentservice studentService;

    @GetMapping("/students")
    public List<Student>students()
    {
        return studentService.getAllStudents();
    }

   // @GetMapping(value = "/studentbyid", produces = "application/json")
//    public Student getStudentByPath(@PathVariable Integer id)
//    {
//        return studentService.getStudent(id);
//    }

    @GetMapping(value = "/studentbyid", produces = "application/json")
    public Student getStudentByParam(@RequestParam int id ,@RequestParam String fname,Integer number)
    {
        return studentService.getStudent(id,fname);
    }

    @PostMapping(value="/student")
    public void addStudent(@RequestBody @Valid Student student,Integer number)
    {
       studentService.addStudent(student,number);

   }
   @PutMapping("/student")
   public void updateStudent(@RequestBody Student student,Integer number)
   {
      studentService.updateStudent(student,number);
   }
    @DeleteMapping ("/student")
    public void deleteStudent(@RequestBody Integer id,Integer number)
    {
        studentService.deleteStudent(id,number);
    }

}
