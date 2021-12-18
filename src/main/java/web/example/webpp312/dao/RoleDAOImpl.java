package web.example.webpp312.dao;

import org.springframework.stereotype.Repository;
import web.example.webpp312.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return  entityManager.createQuery("select r from Role r").getResultList();
    }

    @Override
    public Role getRoleById(String id) {
        return entityManager.find(Role.class, Long.valueOf(id));
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("select r from Role r where r.role= :name")
                .setParameter("name", name).getSingleResult();
    }


}
