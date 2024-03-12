package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportUserForCategory {

    private Integer id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private int isActive;
    private int kind;

}
