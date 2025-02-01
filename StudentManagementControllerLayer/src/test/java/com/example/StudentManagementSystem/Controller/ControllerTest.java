package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.controller.studentsController;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = studentsController.class)
public class ControllerTest {
    @MockBean
    private StudentsService studentsService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Testing for GetStudentsApi")
    public void shouldTestGetStudents() throws Exception {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Rakesh", 19, "JUnit", "Aryabhatta Hostels", "rakesh@gmial.com", "0978"));
        Mockito.when(studentsService.getStudents()).thenReturn(studentList);
        mockMvc.perform(MockMvcRequestBuilders.get("/students/getStudents")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
