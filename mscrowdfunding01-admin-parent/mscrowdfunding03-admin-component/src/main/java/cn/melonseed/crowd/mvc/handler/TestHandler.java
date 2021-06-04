/**  
* Title: TestHandler.java  
* Description:   
* @author MelonSeed
* @date 2021年5月24日  
* @version 1.0  
*/
package cn.melonseed.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.melonseed.crowd.entity.Admin;
import cn.melonseed.crowd.service.api.AdminService;
import cn.melonseed.crowd.util.ResultEntity;

/**  
* Title: TestHandler 
* Description:  
* @author MelonSeed
* @date 2021年5月24日  
*/
@Controller
public class TestHandler {

    @Autowired
    AdminService adminService;

    @RequestMapping("/test/ssm.html")
    public String testSSM(ModelMap modelMap){
        //Admin admin = adminService.queryAdmin(1);
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList", adminList);
        return "target";
    }
    
  //通过@RequestParam接收数组
    @ResponseBody
    @RequestMapping("/send/array/one.json")
    public String testAjax01(@RequestParam("array[]") Integer[] array){
        for(Integer num : array){
            System.out.println("num:"+num);
        }
        return "success";
    }

    //通过@RequestBody接收数组
    @ResponseBody
    @RequestMapping("/send/array/two.json")
    public ResultEntity<Integer> testAjax02(@RequestBody Integer[] array){
        ResultEntity<Integer> resultEntity = ResultEntity.successWithData(array[0]);
        return resultEntity;
    }




}
