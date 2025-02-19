package EdTech.Course.dto;

import EdTech.Course.model.CourseMaterial;
import EdTech.Course.model.Enrollment;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Data
public class CourseDto {
    private String name;
    private String description;
    private String instructor;
    private Long amount;
    private List<CourseMaterial> courseMaterial;
    private List<Enrollment> enrollments;
}
