package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u.username" +
            " FROM User u" +
            " INNER JOIN Ticket t" +
            " ON u.id = t.user.id" +
            " INNER JOIN Category c" +
            " ON c.id = t.category.id" +
            " WHERE c.id = :categoryId" +
            " ORDER BY u.id ASC")
    public List<Object[]> getReportUserForCategory(@Param("categoryId") int categoryId);

}
