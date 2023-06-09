package win.iot4yj.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import win.iot4yj.entity.RolePermission;
import win.iot4yj.entity.RolePermissionExample;

public interface RolePermissionMapper {
    long countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(RolePermission row);

    int insertSelective(RolePermission row);

    List<RolePermission> selectByExample(RolePermissionExample example);

    RolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") RolePermission row, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("row") RolePermission row, @Param("example") RolePermissionExample example);

    int updateByPrimaryKeySelective(RolePermission row);

    int updateByPrimaryKey(RolePermission row);
}