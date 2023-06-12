package win.iot4yj.service;

import com.google.gson.Gson;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import win.iot4yj.dao.RoleMapper;
import win.iot4yj.dao.UserMapper;
import win.iot4yj.dao.UserRoleMapper;
import win.iot4yj.dto.UserDto;
import win.iot4yj.entity.Role;
import win.iot4yj.entity.RoleExample;
import win.iot4yj.entity.User;
import win.iot4yj.entity.UserExample;
import win.iot4yj.entity.UserExample.Criteria;
import win.iot4yj.entity.UserRole;
import win.iot4yj.entity.UserRoleExample;

/**
 * 用户业务类
 *
 * @author YJ
 * @date 2023/6/9
 **/
@Service
public class UserDetailService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        // 排序
//        example.setOrderByClause("");
        example.setDistinct(false);
        List<User> users = userMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(users)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(users.get(0), userDto);

        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria userRoleExampleCriteria = userRoleExample.createCriteria();
        userRoleExampleCriteria.andUserIdEqualTo(userDto.getId());
        userRoleExample.setDistinct(false);
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);

        if (CollectionUtils.isEmpty(userRoles)) {
            // 不存在用户角色
            return userDto;
        }

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria roleExampleCriteria = roleExample.createCriteria();
        roleExampleCriteria.andIdIn(
            userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        roleExample.setDistinct(false);
        List<Role> roles = roleMapper.selectByExample(roleExample);

        userDto.setRoles(roles);


        Gson gson = new Gson();
        System.out.println("userDto: " + gson.toJson(userDto));

        return userDto;
    }
}
