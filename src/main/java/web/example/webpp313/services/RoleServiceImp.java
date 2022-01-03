package web.example.webpp313.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.example.webpp313.dao.RoleDAO;
import web.example.webpp313.model.Role;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleDAO roleDao;

    @Autowired
    public RoleServiceImp(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void create(Role role) {
        roleDao.create(role);
    }

    @Override
    public Role readByRole(String role) {
        return roleDao.readByRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

}
