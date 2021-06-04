/**  
* Title: ProjectProviderHandler.java  
* Description:   
* @author MelonSeed
* @date 2021年6月4日  
* @version 1.0  
*/
package cn.melonseed.crowd.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.melonseed.crowd.entity.vo.DetailProjectVO;
import cn.melonseed.crowd.entity.vo.PortalTypeVO;
import cn.melonseed.crowd.entity.vo.ProjectVO;
import cn.melonseed.crowd.service.api.ProjectService;
import cn.melonseed.crowd.util.ResultEntity;

/**  
* Title: ProjectProviderHandler 
* Description:  
* @author MelonSeed
* @date 2021年6月4日  
*/
@RestController
public class ProjectProviderHandler {

    @Autowired
    ProjectService projectService;


    // 将ProjectVO中的数据存入各个数据库
    @RequestMapping("/save/project/remote")
    public ResultEntity<String> saveProjectRemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId){
        // 调用本地service进行保存
        try {
            projectService.saveProject(projectVO, memberId);
            return ResultEntity.successWithoutData();
        } catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }


    @RequestMapping("/get/portal/type/project/data/remote")
    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote(){
        try {
            List<PortalTypeVO> portalTypeVOList = projectService.getPortalTypeVOList();
            return ResultEntity.successWithData(portalTypeVOList);
        } catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    @RequestMapping("/get/detail/project/remote/{projectId}")
    public ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId){
        return ResultEntity.successWithData(projectService.getDetailProjectVO(projectId));
    }

}
