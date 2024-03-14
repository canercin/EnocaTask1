package org.example.enocatask1.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;

}
