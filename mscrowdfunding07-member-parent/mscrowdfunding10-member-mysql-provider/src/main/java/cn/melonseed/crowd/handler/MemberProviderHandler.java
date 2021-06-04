/**  
* Title: MemberProviderHandler.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.melonseed.crowd.constant.CrowdConstant;
import cn.melonseed.crowd.entity.po.MemberPO;
import cn.melonseed.crowd.service.api.MemberService;
import cn.melonseed.crowd.util.ResultEntity;

/**  
* Title: MemberProviderHandler 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@RestController
public class MemberProviderHandler {

    @Autowired
    MemberService memberService;

    @RequestMapping("/get/member/by/login/acct/remote")
    public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct){
        try {
        	//1.调用本地Service完成查询
            MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
            //2.未抛异常，返回成功结果
            return ResultEntity.successWithData(memberPO);
        } catch (Exception e){
            e.printStackTrace();
          //2.抛异常，返回失败结果
            return ResultEntity.failed(e.getMessage());
        }
    }
    

    @RequestMapping("/save/member/remote")
    public ResultEntity<String> saveMemberRemote(@RequestBody MemberPO memberPO){
        try {
            memberService.saveMember(memberPO);
            return ResultEntity.successWithoutData();
        } catch (Exception e){
            if (e instanceof DuplicateKeyException){
                return ResultEntity.failed(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
            }
            return ResultEntity.failed(e.getMessage());
        }
    }

}