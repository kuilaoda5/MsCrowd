/**  
* Title: ProjectService.java  
* Description:   
* @author MelonSeed
* @date 2021年6月4日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import java.util.List;

import cn.melonseed.crowd.entity.vo.DetailProjectVO;
import cn.melonseed.crowd.entity.vo.PortalTypeVO;
import cn.melonseed.crowd.entity.vo.ProjectVO;

/**  
* Title: ProjectService 
* Description:  
* @author MelonSeed
* @date 2021年6月4日  
*/
public interface ProjectService {
    void saveProject(ProjectVO projectVO, Integer memberId);

    List<PortalTypeVO> getPortalTypeVOList();

    DetailProjectVO getDetailProjectVO(Integer projectId);
}
