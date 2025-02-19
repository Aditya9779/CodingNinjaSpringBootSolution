package Telecom.SubscriptionService.dto;

import lombok.Data;


@Data
public class ResponseMessage {
    private String message;

    public ResponseMessage() {}
    public ResponseMessage(String message){
        this.message = message;
    }
}
