package web.example.webpp313.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.example.webpp313.model.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public List<User> resUsers() {
        return entityManager.createQuery(
                "select distinct user from User user join fetch user.roles roles", User.class)
                .getResultList();
    }
    @Override
    public List<User> index() {
        return resUsers();
    }

    @Override
    public User showUser(Long id) {
        return (User) entityManager.createQuery(
                "select distinct user from User user join fetch user.roles roles where user.id=:id").getSingleResult();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(Long id, User updatedUser) {
        User user1 = entityManager.find(User.class, id);
        user1.setUserName(updatedUser.getUserName());
        user1.setLastName(updatedUser.getLastName());
        user1.setEmail(updatedUser.getEmail());
        user1.setAge(updatedUser.getAge());
        user1.setRoles(updatedUser.getRoles());
        user1.setPassword(passwordEncoder.encode(updatedUser.getPassword()));;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }


    @Override
    public User findByUsername(String username) {
        try {
            User user = entityManager.createQuery(
                    "SELECT distinct u FROM User u join fetch u.roles roles where u.userName = :name", User.class)
                    .setParameter("name", username)
                    .getSingleResult();
            System.out.println(user);
            return user;

        } catch (NoResultException ex) {
            return null;
        }
    }
}
