package com.quinbay.march22.WEB.APP.service;

import com.quinbay.march22.WEB.APP.dto.Student;
import com.quinbay.march22.WEB.APP.entity.StudentMongodbentity;
import com.quinbay.march22.WEB.APP.entity.Studententity;
import com.quinbay.march22.WEB.APP.repository.StudentMongodbRepository;
import com.quinbay.march22.WEB.APP.repository.StudentRedisRepository;
import com.quinbay.march22.WEB.APP.repository.StudentRepository;
import com.quinbay.march22.WEB.APP.repository.Studentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements  Studentservice {

    @Autowired
    Studentdb studentdb;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongodbRepository studentMongodbRepository;

    @Override

    public List<Student> getAllStudents() {
        List<Student> student = new ArrayList();

        student.addAll(studentdb.getstatement());
        for (Studententity studententity : studentRepository.findAll()) {
            Student st1 = new Student();

            st1.setFname((studententity.getFname()));


            st1.setId((studententity.getId()));
            st1.setLname(studententity.getLname());

            student.add(st1);
        }


        for (StudentMongodbentity studententity : studentMongodbRepository.findAll()) {
            Student st1 = new Student();

            st1.setFname((studententity.getFnmae()));


            st1.setId((studententity.getId()));
            st1.setLname(studententity.getLname());
            st1.setBranch(studententity.getBranch());
            student.add(st1);
        }
        student.addAll(studentRedisRepository.findAll());


        return student;
        //student.add(st);
        //return studentRedisRepository.findAll();
        //return studentMongodbRepository.findAll();

    }

    @Override
    public Student getStudent(Integer id, String fname) {
        // List<Student> studentList = studentdb.getstatement();
        for (Student st : studentdb.getstatement()) {
            if (st.getId() == id && st.getFname().equals(fname)) {
                return st;
            }
        }

        return null;
    }

    @Override

    public void addStudent(Student student, Integer number) {

        if (number == 1) {
            for (Studententity studententity : studentRepository.findAll()) {
                studentRepository.save(studententity);
            }
        }


        if (number == 2) {
            StudentMongodbentity studentMongodbentity = new StudentMongodbentity(student.getId(), student.getFname(), student.getLname(),
                    student.getBranch());

            studentMongodbRepository.save((studentMongodbentity));
        }
        if (number == 3) {

            studentRedisRepository.insert(student);
        }
        if (number == 4) {
            studentdb.addStudent(student);
        }


    }






    @Override
    public void updateStudent(Student student, Integer number) {
        // List<Student> studentList = studentdb.getstatement();
        //studentList.add(student);
        //return studentList;
//
//       studentList if (number == 2) {
//            StudentMongodbentity studentMongodbentity = new StudentMongodbentity();
//            studentMongodbRepository.save(studentMongodbentity);
//        if(number==1)
//        {
//            studentdb.updateStudent(student);
//        }
//        if (number == 1) {
//
//            for (Studententity studentEntity : studentRepository.findAll()) {
//                if (studentEntity.getId() == student.getId()) {
//                    studentRepository.save(new Studententity(student.getId(), student.getFname(),
//                            student.getLname(),student.getBranch()));
//                }
//
//            }
//        }
            if (number == 2) {
                StudentMongodbentity studentMongodbentity = new StudentMongodbentity(student.getId(), student.getFname(), student.getLname(),
                        student.getBranch());

                studentMongodbRepository.save((studentMongodbentity));
            }


            if (number == 3) {
                studentRedisRepository.insert(student);
            }
            if (number == 4) {

                studentdb.updateStudent(student);

            }
        }




    @Override
    public void deleteStudent(Integer id, Integer number) {


        //  for(StudentMongodbentity studentMongodbentity:studentMongodbRepository.findAll())
        // {
        //    if(studentMongodbentity.getId()==(id))
        //      {
        //studentMongodbRepository.delete(studentMongodbentity);
        //      }
        //  }
        if(number==1)
        {
            studentRepository.deleteById(id);
        }

        if (number == 2) {

            for(StudentMongodbentity studentMongodbentity : studentMongodbRepository.findAll())
            {
                if(studentMongodbentity.getId()==id)
                {

                    studentMongodbRepository.delete(studentMongodbentity);

                }
            }


        }



        if (number == 3) {
            studentRedisRepository.delete (id);
        }

    }
}





