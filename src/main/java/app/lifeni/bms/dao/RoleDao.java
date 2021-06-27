package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {
    List<Role> queryAllRoles();

    Role queryRoleById(@Param("roleId") long roleId);
}
