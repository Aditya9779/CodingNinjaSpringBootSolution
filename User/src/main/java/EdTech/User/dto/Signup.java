package EdTech.User.dto;

import lombok.Data;

@Data
public class Signup {
    private String name;
    private String username;
    private String email;
    private Long contact;
    private String address;
    private String role;
    private String password;
}
