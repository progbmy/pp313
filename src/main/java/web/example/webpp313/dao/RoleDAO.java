package web.example.webpp313.dao;

import web.example.webpp313.model.Role;

import java.util.List;

public interface RoleDAO {
    void create(Role role);
    Role readByRole(String role);
    List<Role> getAllRoles();
}
