/**  
* Title: OSSProperties.java  
* Description:   
* @author MelonSeed
* @date 2021年6月4日  
* @version 1.0  
*/
package cn.melonseed.crowd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* Title: OSSProperties 
* Description:  
* @author MelonSeed
* @date 2021年6月4日  
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSProperties {
    private String endPoint;
    private String bucketName;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketDomain;
}
