package cn.melonseed.crowd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.melonseed.crowd.entity.po.ProjectPO;
import cn.melonseed.crowd.entity.po.ProjectPOExample;
import cn.melonseed.crowd.entity.vo.DetailProjectVO;
import cn.melonseed.crowd.entity.vo.PortalTypeVO;

public interface ProjectPOMapper {
    int countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    void saveTypeRelationship(@Param("projectId") Integer projectId, @Param("typeIdList") List<Integer> typeIdList);

    void saveTagRelationship(@Param("projectId")  Integer projectId, @Param("tagIdList") List<Integer> tagIdList);

    List<PortalTypeVO> selectPortalTypeVOList();

    DetailProjectVO selectDetailProjectVO(Integer projectId);
}