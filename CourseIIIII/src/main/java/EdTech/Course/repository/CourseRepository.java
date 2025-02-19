package EdTech.Course.repository;

import EdTech.Course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
    Course findByInstructor(String instructor);
}
