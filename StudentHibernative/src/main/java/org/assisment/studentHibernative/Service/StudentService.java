package org.assisment.studentHibernative.Service;

import jakarta.transaction.Transactional;
import org.assisment.studentHibernative.RespositioryDAL.StudentDal;
import org.assisment.studentHibernative.StudentEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentDal studentDal;

    @Transactional
    public void saveDeatils(Student student) {
        studentDal.save(student);
    }
}
