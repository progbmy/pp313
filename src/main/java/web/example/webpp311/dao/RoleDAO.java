package web.example.webpp311.dao;


import javax.management.relation.Role;
import java.util.List;

public interface RoleDAO {
    List<Role> getRoles();
    Role getRoleById(String id);
    Role getRoleByName(String name);

}
