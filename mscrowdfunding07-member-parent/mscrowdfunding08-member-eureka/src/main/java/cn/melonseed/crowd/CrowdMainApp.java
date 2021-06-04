/**  
* Title: CrowdMainApp.java  
* Description:   
* @author MelonSeed
* @date 2021年6月2日  
* @version 1.0  
*/
package cn.melonseed.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**  
* Title: CrowdMainApp 
* Description:  
* @author MelonSeed
* @date 2021年6月2日  
*/
@EnableEurekaServer
@SpringBootApplication
public class CrowdMainApp {
	public static void main(String[] args) {
		SpringApplication.run(CrowdMainApp.class, args);
	}
}
