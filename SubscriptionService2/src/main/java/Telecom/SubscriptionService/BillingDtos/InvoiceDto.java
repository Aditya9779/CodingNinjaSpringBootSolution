package Telecom.SubscriptionService.BillingDtos;

import lombok.Data;

@Data
public class InvoiceDto {
    private Long subscriptionId;
    private String customerName;
    private String invoiceDate;
    private Integer amount;
}
