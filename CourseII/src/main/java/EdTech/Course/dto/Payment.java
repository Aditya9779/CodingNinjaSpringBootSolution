package EdTech.Course.dto;

import lombok.Data;

@Data
public class Payment {
    private Long userId;
    private Long courseId;
    private String date;
    private Long amount;
}
