/**  
* Title: CrowdWebMvcConfig.java  
* Description:   
* @author MelonSeed
* @date 2021年6月4日  
* @version 1.0  
*/
package cn.melonseed.crowd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**  
* Title: CrowdWebMvcConfig 
* Description:  
* @author MelonSeed
* @date 2021年6月4日  
*/
@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/do/crowd/launch/page.html").setViewName("project-launch");
        registry.addViewController("/agree/protocol/page.html").setViewName("project-agree");
        registry.addViewController("/return/info/page.html").setViewName("project-return");
        registry.addViewController("/create/confirm/page.html").setViewName("project-confirm");
        registry.addViewController("/create/success.html").setViewName("project-success");
    }
}
