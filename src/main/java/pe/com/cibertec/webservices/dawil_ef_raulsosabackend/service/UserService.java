package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.User;

import java.util.List;

public interface UserService {

    public List<User> list();

    public User serachById(int id);

    public User add(User obj);

    public User update(User obj);

    public User delete(int id);
    
}
