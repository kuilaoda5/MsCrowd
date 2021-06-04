/**  
* Title: AuthServiceImpl.java  
* Description:   
* @author MelonSeed
* @date 2021年5月29日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.melonseed.crowd.entity.Auth;
import cn.melonseed.crowd.entity.AuthExample;
import cn.melonseed.crowd.mapper.AuthMapper;
import cn.melonseed.crowd.service.api.AuthService;

/**  
* Title: AuthServiceImpl 
* Description:  
* @author MelonSeed
* @date 2021年5月29日  
*/
@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
    private AuthMapper authMapper;

  
    public List<Auth> queryAuthList() {
        return authMapper.selectByExample(new AuthExample());
    }


    public List<Integer> getAuthByRoleId(Integer roleId) {
        return authMapper.getAuthByRoleId(roleId);
    }

    public void saveRoleAuthRelationship(Map<String, List<Integer>> map) {
        // 从map获取到roleId、authIdList
        List<Integer> roleIdList = map.get("roleId");
        Integer roleId = roleIdList.get(0);

        List<Integer> authIdList = map.get("authIdList");

        // 1 清除原有的关系信息
        authMapper.deleteOldRelationshipByRoleId(roleId);


        // 2 当authIdList有效时，添加前端获取的新的关系信息
        if (authIdList != null && authIdList.size() > 0){
            authMapper.insertNewRelationship(roleId,authIdList);
        }
    }

    public List<String> getAuthNameByAdminId(Integer adminId) {
        return authMapper.selectAuthNameByAdminId(adminId);
    }

}
