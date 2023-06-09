package win.iot4yj.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import win.iot4yj.entity.UserRole;
import win.iot4yj.entity.UserRoleExample;

public interface UserRoleMapper {
    long countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRole row);

    int insertSelective(UserRole row);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") UserRole row, @Param("example") UserRoleExample example);

    int updateByExample(@Param("row") UserRole row, @Param("example") UserRoleExample example);

    int updateByPrimaryKeySelective(UserRole row);

    int updateByPrimaryKey(UserRole row);
}