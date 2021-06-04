/**  
* Title: RoleService.java  
* Description:   
* @author MelonSeed
* @date 2021年5月29日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.melonseed.crowd.entity.Role;

/**  
* Title: RoleService 
* Description:  
* @author MelonSeed
* @date 2021年5月29日  
*/
public interface RoleService {

    PageInfo<Role> getPageInfo(int pageNum, int pageSize, String keyword);

    void saveRole(Role role);

    void updateRole(Role role);

    void removeById(List<Integer> roleIdList);

    // 根据adminId查询已分配的角色
    List<Role> queryUnAssignedRoleList(Integer adminId);

    List<Role> queryAssignedRoleList(Integer adminId);
	
}
