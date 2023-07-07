package br.com.compassuol.pb.challenge.msnotification.dto;

import br.com.compassuol.pb.challenge.msproducts.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
