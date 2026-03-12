package com.avantika.blogapi.auth;
import com.avantika.blogapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

        @Autowired
        private JwtUtil jwtUtil;

        @PostMapping("/login")
        public AuthResponse login(@RequestBody LoginRequest request){

            String token = jwtUtil.generateToken(request.getUsername());

            return new AuthResponse(token);
        }
    }

