/**  
* Title: OrderService.java  
* Description:   
* @author MelonSeed
* @date 2021年6月4日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import java.util.List;

import cn.melonseed.crowd.entity.vo.AddressVO;
import cn.melonseed.crowd.entity.vo.OrderProjectVO;
import cn.melonseed.crowd.entity.vo.OrderVO;

/**  
* Title: OrderService 
* Description:  
* @author MelonSeed
* @date 2021年6月4日  
*/
public interface OrderService {

    OrderProjectVO getOrderProjectVO(Integer returnId);

    List<AddressVO> getAddressListVOByMemberId(Integer memberId);

    void saveAddressPO(AddressVO addressVO);

    void saveOrder(OrderVO orderVO);
}
