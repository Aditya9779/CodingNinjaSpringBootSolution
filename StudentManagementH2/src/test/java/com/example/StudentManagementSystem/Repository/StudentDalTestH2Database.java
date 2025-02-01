package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentsDal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test") //for activating the different profiles of yml
//while making the file of the yml we used the name conversion application-? what
//ever after the dash
public class StudentDalTestH2Database {

 @Autowired
   private StudentsDal studentsDal;
   @Test
   @DisplayName("Testing for the Save Student")
    public void shouldSaveStudent(){
      Student student= new Student(1, "Rakesh", 19, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978");
      Student resultTest=studentsDal.save(student);
      assertThat(resultTest).usingRecursiveComparison().ignoringFields("sid").isEqualTo(student);
   }

}
