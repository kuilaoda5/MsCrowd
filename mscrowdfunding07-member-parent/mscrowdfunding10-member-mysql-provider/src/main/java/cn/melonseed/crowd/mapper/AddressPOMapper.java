package cn.melonseed.crowd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.melonseed.crowd.entity.po.AddressPO;
import cn.melonseed.crowd.entity.po.AddressPOExample;

public interface AddressPOMapper {
    int countByExample(AddressPOExample example);

    int deleteByExample(AddressPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressPO record);

    int insertSelective(AddressPO record);

    List<AddressPO> selectByExample(AddressPOExample example);

    AddressPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressPO record, @Param("example") AddressPOExample example);

    int updateByExample(@Param("record") AddressPO record, @Param("example") AddressPOExample example);

    int updateByPrimaryKeySelective(AddressPO record);

    int updateByPrimaryKey(AddressPO record);
}