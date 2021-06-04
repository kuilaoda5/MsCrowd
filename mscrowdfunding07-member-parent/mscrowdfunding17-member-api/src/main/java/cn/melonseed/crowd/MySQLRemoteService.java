/**  
* Title: MySQLRemoteService.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.melonseed.crowd.entity.po.MemberPO;
import cn.melonseed.crowd.entity.vo.AddressVO;
import cn.melonseed.crowd.entity.vo.DetailProjectVO;
import cn.melonseed.crowd.entity.vo.OrderProjectVO;
import cn.melonseed.crowd.entity.vo.OrderVO;
import cn.melonseed.crowd.entity.vo.PortalTypeVO;
import cn.melonseed.crowd.entity.vo.ProjectVO;
import cn.melonseed.crowd.util.ResultEntity;

/**  
* Title: MySQLRemoteService 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@FeignClient("crowd-mysql")
public interface MySQLRemoteService {

	@RequestMapping("/get/member/by/login/acct/remote")
    ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

    @RequestMapping("/save/member/remote")
    ResultEntity<String> saveMemberRemote(@RequestBody MemberPO memberPO);

    @RequestMapping("/save/project/remote")
    ResultEntity<String> saveProjectRemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);

    @RequestMapping("/get/portal/type/project/data/remote")
    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

    @RequestMapping("/get/detail/project/remote/{projectId}")
    public ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);

    @RequestMapping("/get/order/project/vo/remote")
    ResultEntity<OrderProjectVO> getOrderProjectVO(@RequestParam("returnId") Integer returnId);

    @RequestMapping("/get/address/list/by/member/id/remote")
    ResultEntity<List<AddressVO>> getAddressListByMemberIdRemote(@RequestParam("memberId") Integer memberId);

    @RequestMapping("/save/address/remote")
    ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO);

    @RequestMapping("save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO);
    
}
