package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
