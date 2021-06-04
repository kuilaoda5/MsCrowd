/**  
* Title: PortalHandler.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.melonseed.crowd.MySQLRemoteService;
import cn.melonseed.crowd.constant.CrowdConstant;
import cn.melonseed.crowd.entity.vo.PortalTypeVO;
import cn.melonseed.crowd.util.ResultEntity;

/**  
* Title: PortalHandler 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@Controller
public class PortalHandler {

    @Autowired
    MySQLRemoteService mySQLRemoteService;

    // 首页
    @RequestMapping("/")
    public String showPortalPage(ModelMap modelMap){

        // 调用MySQLRemoteService提供的方法查询首页要显示的数据
        ResultEntity<List<PortalTypeVO>> resultEntity = mySQLRemoteService.getPortalTypeProjectDataRemote();
        // 如果操作成功，将得到的list加入请求域
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())){
            List<PortalTypeVO> portalTypeVOList = resultEntity.getData();
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_TYPE_LIST,portalTypeVOList);
        }
        return "portal";
    }

}
