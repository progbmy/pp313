package web.example.webpp311.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.example.webpp311.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
