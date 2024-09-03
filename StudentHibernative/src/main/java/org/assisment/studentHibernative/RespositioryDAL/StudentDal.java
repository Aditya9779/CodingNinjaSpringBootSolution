package org.assisment.studentHibernative.RespositioryDAL;

import jakarta.persistence.EntityManager;
import org.assisment.studentHibernative.StudentEntity.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDal {
    @Autowired
    EntityManager entityManager; //Managing the session for the database

    public void save(Student student) {
        //Getting the session object
        Session session = entityManager.unwrap(Session.class);
        session.save(student);
    }

}
