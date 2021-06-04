/**  
* Title: LoginInterceptor.java  
* Description:   
* @author MelonSeed
* @date 2021年5月26日  
* @version 1.0  
*/
package cn.melonseed.crowd.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.melonseed.crowd.constant.CrowdConstant;
import cn.melonseed.crowd.entity.Admin;
import cn.melonseed.crowd.exception.AccessForbiddenException;

/**  
* Title: LoginInterceptor 
* Description:  
* @author MelonSeed
* @date 2021年5月26日  
*/
//拦截器，用来在未登录时访问受保护页面时进行拦截并抛出AccessForbiddenException
public class LoginInterceptor extends HandlerInterceptorAdapter {

 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     // 通过request获得session对象
     HttpSession session = request.getSession();

     // 从session域中取出Admin对象
     Admin admin = (Admin) session.getAttribute(CrowdConstant.LOGIN_ADMIN_NAME);

     // 判断admin对象是否为空，若为空表示未登录，抛出异常
     if (admin == null){
         throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDDEN);
     }

     // admin对象不为空，表示已登录，放行
     return true;
 }
}
