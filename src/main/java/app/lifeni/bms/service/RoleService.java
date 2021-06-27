package app.lifeni.bms.service;

import app.lifeni.bms.entity.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryAllRoles();

    String queryRoleById(long roleId);
}
