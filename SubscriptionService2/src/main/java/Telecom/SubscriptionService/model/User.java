package Telecom.SubscriptionService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.*;
import java.math.BigInteger;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private BigInteger contact;
    private String address;
    @JsonIgnoreProperties("user")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Subscription> subscriptionList;
}
