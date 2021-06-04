/**  
* Title: ShortMessageProperties.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* Title: ShortMessageProperties 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "short.message")
public class ShortMessageProperties {
    private String host;
    private String path;
    private String appCode;
    private String sign;
    private String skin;
}
