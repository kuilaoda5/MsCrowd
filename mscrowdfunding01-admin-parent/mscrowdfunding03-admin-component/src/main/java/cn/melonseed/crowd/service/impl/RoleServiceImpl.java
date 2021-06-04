/**  
* Title: RoleServiceImpl.java  
* Description:   
* @author MelonSeed
* @date 2021年5月29日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.melonseed.crowd.entity.Role;
import cn.melonseed.crowd.entity.RoleExample;
import cn.melonseed.crowd.mapper.RoleMapper;
import cn.melonseed.crowd.service.api.RoleService;

/**  
* Title: RoleServiceImpl 
* Description:  
* @author MelonSeed
* @date 2021年5月29日  
*/
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
    RoleMapper roleMapper;

    // 获取分页的用户列表
    public PageInfo<Role> getPageInfo(int pageNum, int pageSize, String keyword) {
        // 开启分页
        PageHelper.startPage(pageNum,pageSize);

        // 从mapper方法得到Role的List
        List<Role> roles = roleMapper.selectRoleByKeyword(keyword);

        // 封装为PageInfo对象
        PageInfo<Role> pageInfo = new PageInfo<Role>(roles);

        // 返回pageInfo
        return pageInfo;
    }


    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }
    
   
    public void removeById(List<Integer> roleIdList) {
        // 创建RoleExample
        RoleExample roleExample = new RoleExample();

        // 获取Criteria对象
        RoleExample.Criteria criteria = roleExample.createCriteria();

        // 使用Criteria封装查询条件
        criteria.andIdIn(roleIdList);

        roleMapper.deleteByExample(roleExample);
    }

   
    public List<Role> queryUnAssignedRoleList(Integer adminId) {
        return roleMapper.queryUnAssignedRoleList(adminId);
    }


    public List<Role> queryAssignedRoleList(Integer adminId) {
        return roleMapper.queryAssignedRoleList(adminId);
    }
	
	
}
