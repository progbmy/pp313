package web.example.webpp313.services;


import web.example.webpp313.model.Role;

import java.util.List;

public interface RoleService {
    void create(Role role);

    Role readByRole(String role);

    List<Role> getAllRoles();
}
