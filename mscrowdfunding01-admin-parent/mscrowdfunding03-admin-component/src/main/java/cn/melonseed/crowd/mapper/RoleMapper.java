package cn.melonseed.crowd.mapper;

import cn.melonseed.crowd.entity.Role;
import cn.melonseed.crowd.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    Role selectByPrimaryKey(Integer id);
    
    List<Role> selectByExample(RoleExample example);
    
    List<Role> selectRoleByKeyword(String keyword);

	List<Role> queryUnAssignedRoleList(Integer adminId);

	List<Role> queryAssignedRoleList(Integer adminId);
}