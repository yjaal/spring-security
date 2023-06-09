package win.iot4yj.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import win.iot4yj.entity.Permission;
import win.iot4yj.entity.PermissionExample;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Permission row);

    int insertSelective(Permission row);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Permission row, @Param("example") PermissionExample example);

    int updateByExample(@Param("row") Permission row, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission row);

    int updateByPrimaryKey(Permission row);
}