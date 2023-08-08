package com.example.demoojwt2.payload.response;

import com.example.demoojwt2.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Long id_user;
    private String username;

    private List<Role> roleList =new ArrayList<>();
}
