package Telecom.SubscriptionService.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String balance;
    private String details;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("account")
    private User user;
}
