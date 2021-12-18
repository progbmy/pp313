package web.example.webpp311.dao;



import web.example.webpp311.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getRoles();
    Role getRoleById(String id);
    Role getRoleByName(String name);

}
