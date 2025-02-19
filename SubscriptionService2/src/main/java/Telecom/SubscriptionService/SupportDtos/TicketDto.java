package Telecom.SubscriptionService.SupportDtos;

import lombok.Data;

@Data
public class TicketDto {
    private Long userId;
    private String issueDescription;
    private String priority;
    private String status;
    private String creationDate;
    private String resolutionDate;
}
