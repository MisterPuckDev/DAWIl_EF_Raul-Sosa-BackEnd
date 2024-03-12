package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Project;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.ProjectRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> list() {
        return projectRepository.findAll();
    }

    @Override
    public Project serachById(int id) {
        return null;
    }

    @Override
    public Project add(Project obj) {
        return null;
    }

    @Override
    public Project update(Project obj) {
        return null;
    }

    @Override
    public Project delete(int id) {
        return null;
    }
}
