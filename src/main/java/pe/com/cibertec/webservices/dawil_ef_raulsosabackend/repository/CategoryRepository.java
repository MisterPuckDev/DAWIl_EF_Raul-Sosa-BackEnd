package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
