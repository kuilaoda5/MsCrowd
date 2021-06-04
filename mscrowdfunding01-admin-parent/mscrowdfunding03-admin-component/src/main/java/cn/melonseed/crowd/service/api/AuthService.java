/**  
* Title: AuthService.java  
* Description:   
* @author MelonSeed
* @date 2021年5月29日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import java.util.List;
import java.util.Map;

import cn.melonseed.crowd.entity.Auth;

/**  
* Title: AuthService 
* Description:  
* @author MelonSeed
* @date 2021年5月29日  
*/
public interface AuthService {
    List<Auth> queryAuthList();

    List<Integer> getAuthByRoleId(Integer roleId);

    void saveRoleAuthRelationship(Map<String, List<Integer>> map);

    List<String> getAuthNameByAdminId(Integer adminId);
}
