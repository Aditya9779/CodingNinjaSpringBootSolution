package Telecom.SubscriptionService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;
    private String planName;
    private String planDetails;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("subscriptionList")
    private User user;
}

