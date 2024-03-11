package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> list();

    public Project serachById(int id);

    public Project add(Project obj);

    public Project update(Project obj);

    public Project delete(int id);
    
}
