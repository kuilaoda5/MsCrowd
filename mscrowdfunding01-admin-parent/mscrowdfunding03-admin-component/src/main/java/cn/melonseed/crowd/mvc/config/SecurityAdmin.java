/**  
* Title: SecurityAdmin.java  
* Description:   
* @author MelonSeed
* @date 2021年5月30日  
* @version 1.0  
*/
package cn.melonseed.crowd.mvc.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import cn.melonseed.crowd.entity.Admin;

/**  
* Title: SecurityAdmin 
* Description:  
* @author MelonSeed
* @date 2021年5月30日  
*/
public class SecurityAdmin extends User{
	private Admin originalAdmin;

    public SecurityAdmin(Admin admin, List<GrantedAuthority> authorities){
        super(admin.getUserName(),admin.getUserPswd(),authorities);

        this.originalAdmin = admin;
        // 为了保证安全性，擦除放入originalAdmin的对象的密码
        this.originalAdmin.setUserPswd(null);
    }

    public Admin getOriginalAdmin(){
        return this.originalAdmin;
    }
}
