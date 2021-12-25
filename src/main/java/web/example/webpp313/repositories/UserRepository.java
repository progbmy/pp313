package web.example.webpp313.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.example.webpp313.model.User;


//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User userName(String username);

}
