package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentsDal;
import com.example.StudentManagementSystem.service.StudentsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {

    //    StudentsDal studentsDal = Mockito.mock(StudentsDal.class);
    //ShortCut for writting for up line
    @Mock
    StudentsDal studentsDal;
    StudentsService studentsService;

    @BeforeEach
    public void setUp() {
        studentsService = new StudentsService(studentsDal);
    }

    @Test
    @DisplayName("Its Checks for the increment value")
    public void shouldTestIncreementService() {
//        StudentsService studentsService = new StudentsService(studentsDal);
        int num = 0;
        int result = studentsService.increementService(num);
        Assertions.assertEquals(result, num + 1);
    }

    /*@Test
    public void shouldFailTestIncreementService() {
        StudentsService studentsService = new StudentsService(studentsDal);
        int num = 0;
        int result = studentsService.increementService(num);
        Assertions.assertEquals(result,num);
    }*/
    @Test
    @DisplayName("Its checks for the failed test ")
    public void shouldFailTestIncreementService() {
        // StudentsService studentsService = new StudentsService(studentsDal);
        int num = 0;
        int result = studentsService.increementService(num);
        Assertions.assertNotEquals(result, num);
    }

    @Test
    @DisplayName("Its checks for the gellStudents List")
    public void shouldTestGetStudent() {
        //StudentsService studentsService = new StudentsService(studentsDal);
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(
                new Student(1, "Rakesh", 19, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978")
        );
        Mockito.when(studentsDal.findAll()).thenReturn(expectedList);
        List<Student> resultList = studentsService.getStudents();
        Assertions.assertEquals(expectedList.size(), resultList.size());
    }

    @Test
    @DisplayName("Testing for the Delete Function")
    public void shouldTestDeleteSTudent() {
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(
                new Student(1, "Rakesh", 19, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978")
        );
        expectedList.add(new Student(2, "Aditya", 21, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978"));
        int sid = 1;
        Mockito.doNothing().when(studentsDal).deleteById(sid);
        Mockito.when(studentsDal.existsById(sid)).thenReturn(true);
        Boolean resultBoolean = studentsService.deleteStudent(sid);
        Assertions.assertEquals(resultBoolean, true);
    }

    @Test
    @DisplayName("Testing for the Delete Function")
    public void shouldTestNotDeleteSTudent() {
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(
                new Student(1, "Rakesh", 19, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978")
        );
        expectedList.add(new Student(2, "Aditya", 21, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978"));
        int sid = 1;
        Mockito.doNothing().when(studentsDal).deleteById(sid);
        Mockito.when(studentsDal.existsById(sid)).thenReturn(false);
        Boolean resultBoolean = studentsService.deleteStudent(sid);
        Assertions.assertEquals(resultBoolean, false);
    }
}
