package it.gest.pren.rest.crud.security;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {    
    private String username;    
    private String password;
}
