/**  
* Title: AdminService.java  
* Description:   
* @author MelonSeed
* @date 2021年5月24日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.melonseed.crowd.entity.Admin;

/**  
* Title: AdminService 
* Description:  
* @author MelonSeed
* @date 2021年5月24日  
*/
public interface AdminService {
	
	void saveAdmin(Admin admin);
	
	void updateAdmin(Admin admin);
	
	void removeById(Integer adminId);
	
	void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);
	    
    Admin queryAdmin(Integer id);

    Admin getAdminByUsername(String adminLoginAcct, String adminPassword);

    Admin getAdminByLoginAcct(String loginAcct);
    
	List<Admin> getAll();
	
	PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);
	
    
}
