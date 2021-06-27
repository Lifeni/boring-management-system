package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.RoleDao;
import app.lifeni.bms.entity.model.Role;
import app.lifeni.bms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryAllRoles() {
        return roleDao.queryAllRoles();
    }

    @Override
    public String queryRoleById(long roleId) {
        return roleDao.queryRoleById(roleId).getRoleName();
    }
}
