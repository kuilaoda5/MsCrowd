package cn.melonseed.crowd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.melonseed.crowd.entity.po.ReturnPO;
import cn.melonseed.crowd.entity.po.ReturnPOExample;
import cn.melonseed.crowd.entity.vo.AddressVO;

public interface ReturnPOMapper {
    int countByExample(ReturnPOExample example);

    int deleteByExample(ReturnPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturnPO record);

    int insertSelective(ReturnPO record);

    List<ReturnPO> selectByExample(ReturnPOExample example);

    ReturnPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReturnPO record, @Param("example") ReturnPOExample example);

    int updateByExample(@Param("record") ReturnPO record, @Param("example") ReturnPOExample example);

    int updateByPrimaryKeySelective(ReturnPO record);

    int updateByPrimaryKey(ReturnPO record);

    void insertReturnPOList(@Param("projectId") Integer projectId, @Param("returnPOList") List<ReturnPO> returnPOList);

}