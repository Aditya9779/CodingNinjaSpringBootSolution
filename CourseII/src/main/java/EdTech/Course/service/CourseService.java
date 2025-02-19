package EdTech.Course.service;

import EdTech.Course.dto.CourseDto;
import EdTech.Course.dto.Payment;
import EdTech.Course.model.Course;
import EdTech.Course.model.CourseMaterial;
import EdTech.Course.model.Enrollment;
import EdTech.Course.repository.CourseRepository;
import EdTech.Course.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.orElse(null);
    }

    public void createCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setAmount(courseDto.getAmount());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setInstructor(courseDto.getInstructor());
        for(CourseMaterial courseMaterial : courseDto.getCourseMaterial()){
            courseMaterial.setCourse(course);
        }
        for(Enrollment enrollment : courseDto.getEnrollments()){
            enrollment.setCourse(course);
        }
        course.setCourseMaterial(courseDto.getCourseMaterial());
        course.setEnrollment(courseDto.getEnrollments());
        courseRepository.save(course);
    }

    public void updateCourse(Long id, CourseDto updatedCourseDto) {
        Course existingCourse = getCourseById(id);
        if (existingCourse != null) {
            existingCourse.setName(updatedCourseDto.getName());
            existingCourse.setDescription(updatedCourseDto.getDescription());
            existingCourse.setInstructor(updatedCourseDto.getInstructor());
            existingCourse.setAmount(updatedCourseDto.getAmount());
            for(CourseMaterial courseMaterial : updatedCourseDto.getCourseMaterial()){
                courseMaterial.setCourse(existingCourse);
            }
            for(Enrollment enrollment : updatedCourseDto.getEnrollments()){
                enrollment.setCourse(existingCourse);
            }
            courseRepository.save(existingCourse);
        }
        else{
            throw new RuntimeException("Course do not exist");
        }
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public Course getCourseByInstructor(String instructor){
        return courseRepository.findByInstructor(instructor);
    }

    public List<CourseMaterial> getCourseMaterialByCourseId(Long id){
        return courseRepository.findById(id).orElseThrow().getCourseMaterial();
    }

  /* public void registerStudent(Long courseId, Long userId) {
        String urlUser = "https://localhost:8082/users/id?={userId}";
        String urlPay = "https://localhost:8087/payment";
    
        // Step 1: Check if the user exists by calling the User Service
        ResponseEntity<Boolean> userExistResponse = restTemplate.getForEntity(urlUser, Boolean.class, userId);
        if (userExistResponse.getBody() == null || !userExistResponse.getBody()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    
        // Step 2: Fetch the course details
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));
    
        // Step 3: Save enrollment details
        Enrollment enrollment = new Enrollment();
        enrollment.setUserId(userId);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
    
        // Step 4: Create payment
        Map<String, Object> paymentDetails = new HashMap<>();
        paymentDetails.put("userId", userId);
        paymentDetails.put("courseId", courseId);
        paymentDetails.put("amount", course.getAmount());
    
        ResponseEntity<Void> paymentResponse = restTemplate.postForEntity(urlPay, paymentDetails, Void.class);
        if (paymentResponse.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Payment creation failed for user ID: " + userId + " and course ID: " + courseId);
        }
    }*/
    //UP is for the reference
    public void createEnrollmentForCourse(Long courseId, Long userId) {

        // call to user to find user is available
        String userServiceUrl = "http://localhost:8083/user";
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer {Token generated by user login in User Service}");
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, header);
        ResponseEntity<Object>  response = restTemplate.exchange(userServiceUrl + "/" + userId, HttpMethod.GET,
                requestEntity, Object.class);
        if(response.getBody() == null) throw new RuntimeException("User not found");

        Enrollment enrollment = new Enrollment();
        enrollment.setUserId(userId);
        enrollment.setCourse(courseRepository.findById(courseId).orElseThrow());
        enrollmentRepository.save(enrollment);

        // creating payment
        String paymentServiceUrl = "http://localhost:8082/payment";
        Payment payment = new Payment();
        payment.setCourseId(courseId);
        payment.setUserId(userId);
        payment.setAmount(enrollment.getCourse().getAmount());
        restTemplate.postForObject(paymentServiceUrl, payment, Payment.class);
    }
}
