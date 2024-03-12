package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    String username;
    String name;
    String lastname;
    String password;
    String email;
}
