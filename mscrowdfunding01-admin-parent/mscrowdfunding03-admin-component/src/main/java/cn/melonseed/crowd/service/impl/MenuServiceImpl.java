/**  
* Title: MenuServiceImpl.java  
* Description:   
* @author MelonSeed
* @date 2021年5月29日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.melonseed.crowd.entity.Menu;
import cn.melonseed.crowd.entity.MenuExample;
import cn.melonseed.crowd.mapper.MenuMapper;
import cn.melonseed.crowd.service.api.MenuService;

/**  
* Title: MenuServiceImpl 
* Description:  
* @author MelonSeed
* @date 2021年5月29日  
*/
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
    private MenuMapper menuMapper;


    public List<Menu> getAll() {
        return menuMapper.selectByExample(new MenuExample());
    }

 
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }


    public void editMenu(Menu menu) {
        // 有选择地更新，如果menu中有的值为null（如这里的pid），则不会更新该内容
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    public void removeMenuById(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
