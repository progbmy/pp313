package web.example.webpp313.dao;



import web.example.webpp313.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getRoles();
    Role getRoleById(String id);
    Role getRoleByName(String name);

}
