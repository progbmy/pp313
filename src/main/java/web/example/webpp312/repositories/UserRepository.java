package web.example.webpp312.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.example.webpp312.model.User;


//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUsername(String username);
    User userName(String username);

}
