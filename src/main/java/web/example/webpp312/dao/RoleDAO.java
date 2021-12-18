package web.example.webpp312.dao;



import web.example.webpp312.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getRoles();
    Role getRoleById(String id);
    Role getRoleByName(String name);

}
