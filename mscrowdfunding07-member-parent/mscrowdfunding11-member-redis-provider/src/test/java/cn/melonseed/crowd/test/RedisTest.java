/**  
* Title: MybatisTest.java  
* Description:   
* @author MelonSeed
* @date 2021年6月2日  
* @version 1.0  
*/
package cn.melonseed.crowd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import cn.melonseed.crowd.CrowdMainApp;


/**  
* Title: MybatisTest 
* Description:  
* @author MelonSeed
* @date 2021年6月2日  
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrowdMainApp.class)
public class RedisTest {
	
	private Logger logger = LoggerFactory.getLogger(RedisTest.class);
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Test
	public void testSet() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		
		operations.set("Apple", "red");
	}
}
