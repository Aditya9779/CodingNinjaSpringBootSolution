package EdTech.Course.controller;

import EdTech.Course.dto.CourseDto;
import EdTech.Course.dto.ResponseMessage;
import EdTech.Course.model.Course;
import EdTech.Course.model.CourseMaterial;
import EdTech.Course.service.CourseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class courseController {


    @Autowired
    private CourseService courseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/name/")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseByName(@RequestParam("name") String name) {
        return courseService.getCourseByName(name);
    }

    @GetMapping("/courseMaterial/")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseMaterial> getCourseMaterialByCourseId(@RequestParam("id") Long id){
        return courseService.getCourseMaterialByCourseId(id);
    }

    @GetMapping("/instructor/")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseByInstructor(@RequestParam("instructor") String instructor) {
        return courseService.getCourseByInstructor(instructor);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createCourse(@RequestBody CourseDto courseDto) {
        courseService.createCourse(courseDto);
        return new ResponseMessage("Course Added Successfully");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updateCourse(@PathVariable Long id, @RequestBody CourseDto updatedCourseDto) {
        courseService.updateCourse(id, updatedCourseDto);
        return new ResponseMessage("Course Updated Successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseMessage("Course Deleted Successfully");
    }


    @PostMapping("/course/{courseId}/register/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    @HystrixCommand(fallbackMethod = "registerForCourseFallback")
    public ResponseMessage registerForCourse(@PathVariable Long courseId, @PathVariable Long userId){
        courseService.createEnrollmentForCourse(courseId, userId);
        return new ResponseMessage("Student Enrolled Successfully");
    }

    public ResponseMessage registerForCourseFallback(@PathVariable Long courseId, @PathVariable Long userId){
        return new ResponseMessage("Services not available");
    }

}
