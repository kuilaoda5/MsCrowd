/**  
* Title: MenuService.java  
* Description:   
* @author MelonSeed
* @date 2021年5月29日  
* @version 1.0  
*/
package cn.melonseed.crowd.service.api;

import java.util.List;

import cn.melonseed.crowd.entity.Menu;

/**  
* Title: MenuService 
* Description:  
* @author MelonSeed
* @date 2021年5月29日  
*/
public interface MenuService {
    List<Menu> getAll();

    void saveMenu(Menu menu);

    void editMenu(Menu menu);

    void removeMenuById(Integer id);
}
