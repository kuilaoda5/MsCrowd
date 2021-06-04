/**  
* Title: MemberService.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import cn.melonseed.crowd.entity.po.MemberPO;

/**  
* Title: MemberService 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
public interface MemberService {
	
	MemberPO getMemberPOByLoginAcct(String loginacct);
	
    void saveMember(MemberPO memberPO);
}
