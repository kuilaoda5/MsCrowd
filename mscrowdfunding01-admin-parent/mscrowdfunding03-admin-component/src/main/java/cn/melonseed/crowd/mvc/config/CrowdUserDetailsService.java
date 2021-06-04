/**  
* Title: CrowdUserDetailsService.java  
* Description:   
* @author MelonSeed
* @date 2021年5月30日  
* @version 1.0  
*/
package cn.melonseed.crowd.mvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.melonseed.crowd.entity.Admin;
import cn.melonseed.crowd.entity.Role;
import cn.melonseed.crowd.service.api.AdminService;
import cn.melonseed.crowd.service.api.AuthService;
import cn.melonseed.crowd.service.api.RoleService;

/**  
* Title: CrowdUserDetailsService 
* Description:  
* @author MelonSeed
* @date 2021年5月30日  
*/
@Component
public class CrowdUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过用户名得到Admin对象
        Admin admin = adminService.getAdminByLoginAcct(username);

        // 通过AdminId得到角色List
        List<Role> roles = roleService.queryAssignedRoleList(admin.getId());

        // 通过AdminId得到权限name地List
        List<String> authNameList = authService.getAuthNameByAdminId(admin.getId());

        // 创建List用来存放GrantedAuthority（权限信息）
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        // 向List存放角色信息，注意角色必须要手动加上 “ROLE_” 前缀
        for (Role role : roles){
            String roleName = "ROLE_" + role.getName();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
            authorities.add(simpleGrantedAuthority);
        }

        // 向List存放权限信息
        for (String authName : authNameList){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);
            authorities.add(simpleGrantedAuthority);
        }

        // 将Admin对象、权限信息封装入SecurityAdmin对象（User的子类）
        SecurityAdmin securityAdmin = new SecurityAdmin(admin,authorities);

        // 返回SecurityAdmin对象
        return securityAdmin;
    }
}
