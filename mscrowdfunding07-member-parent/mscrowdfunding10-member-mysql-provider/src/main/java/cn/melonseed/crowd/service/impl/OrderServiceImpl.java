/**  
* Title: OrderServiceImpl.java  
* Description:   
* @author MelonSeed
* @date 2021年6月4日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.melonseed.crowd.entity.po.AddressPO;
import cn.melonseed.crowd.entity.po.AddressPOExample;
import cn.melonseed.crowd.entity.po.OrderPO;
import cn.melonseed.crowd.entity.po.OrderProjectPO;
import cn.melonseed.crowd.entity.vo.AddressVO;
import cn.melonseed.crowd.entity.vo.OrderProjectVO;
import cn.melonseed.crowd.entity.vo.OrderVO;
import cn.melonseed.crowd.mapper.AddressPOMapper;
import cn.melonseed.crowd.mapper.OrderPOMapper;
import cn.melonseed.crowd.mapper.OrderProjectPOMapper;
import cn.melonseed.crowd.service.api.OrderService;

/**  
* Title: OrderServiceImpl 
* Description:  
* @author MelonSeed
* @date 2021年6月4日  
*/
@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderProjectPOMapper orderProjectPOMapper;

    @Autowired
    AddressPOMapper addressPOMapper;

    @Autowired
    OrderPOMapper orderPOMapper;


   
    public OrderProjectVO getOrderProjectVO(Integer returnId) {
        return orderProjectPOMapper.selectOrderProjectVO(returnId);
    }

   
    public List<AddressVO> getAddressListVOByMemberId(Integer memberId) {

        AddressPOExample example = new AddressPOExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<AddressPO> addressPOList = addressPOMapper.selectByExample(example);

        List<AddressVO> addressVOList = new ArrayList<AddressVO>();
        for (AddressPO addressPO : addressPOList) {
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(addressPO,addressVO);
            addressVOList.add(addressVO);
        }

        return addressVOList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveAddressPO(AddressVO addressVO) {
        AddressPO addressPO = new AddressPO();
        BeanUtils.copyProperties(addressVO,addressPO);
        addressPOMapper.insert(addressPO);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveOrder(OrderVO orderVO) {
        // 创建OrderPO对象
        OrderPO orderPO = new OrderPO();
        // 从传入的OrderVO给OrderPO赋值
        BeanUtils.copyProperties(orderVO,orderPO);
        // 将OrderPO存入数据库
        orderPOMapper.insert(orderPO);
        // 得到存入后自增产生的order id
        Integer orderId = orderPO.getId();
        // 得到orderProjectVO
        OrderProjectVO orderProjectVO = orderVO.getOrderProjectVO();
        // 创建OrderProjectPO对象
        OrderProjectPO orderProjectPO = new OrderProjectPO();
        // 赋值
        BeanUtils.copyProperties(orderProjectVO,orderProjectPO);
        // 给orderProjectPO设置orderId
        orderProjectPO.setOrderId(orderId);
        // 存入数据库
        orderProjectPOMapper.insert(orderProjectPO);
    }
}
