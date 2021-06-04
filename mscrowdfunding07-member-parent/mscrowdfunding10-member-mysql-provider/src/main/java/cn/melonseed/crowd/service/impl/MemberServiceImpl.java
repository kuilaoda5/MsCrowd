/**  
* Title: MemberServiceImpl.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.melonseed.crowd.entity.po.MemberPO;
import cn.melonseed.crowd.entity.po.MemberPOExample;
import cn.melonseed.crowd.entity.po.MemberPOExample.Criteria;
import cn.melonseed.crowd.mapper.MemberPOMapper;
import cn.melonseed.crowd.service.api.MemberService;

/**  
* Title: MemberServiceImpl 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberPOMapper memberPOMapper;

	public MemberPO getMemberPOByLoginAcct(String loginacct) {
		//1.创建Example对象
		MemberPOExample example = new MemberPOExample();
		//2.创建Criteria对象
		Criteria criteria = example.createCriteria();
		//3.封装查询条件
		criteria.andLoginAcctEqualTo(loginacct);
		//4.执行查询
		List<MemberPO> list = memberPOMapper.selectByExample(example);
		//5.返回结果
		if(list==null || list.size()==0) {
			return null;
		}
		return list.get(0);
	}
	
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveMember(MemberPO memberPO) {
            memberPOMapper.insertSelective(memberPO);
    }
}
