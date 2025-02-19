package EdTech.User.dto;

import lombok.Builder;
import lombok.Data;

@Data

public class LoginRequest {

    private String email;
    private String password;
}
