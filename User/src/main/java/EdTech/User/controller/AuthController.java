package EdTech.User.controller;

import EdTech.User.dto.LoginRequest;
import EdTech.User.dto.LoginResponse;
import EdTech.User.dto.ResponseMessage;
import EdTech.User.dto.Signup;
import EdTech.User.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseMessage registerUser(@RequestBody @Valid Signup signup){
        authService.register(signup);
        return new ResponseMessage("User Registered Successfully");
    }
}