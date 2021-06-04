/**  
* Title: MybatisTest.java  
* Description:   
* @author MelonSeed
* @date 2021年6月2日  
* @version 1.0  
*/
package cn.melonseed.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import cn.melonseed.crowd.CrowdMainApp;
import cn.melonseed.crowd.entity.po.MemberPO;
import cn.melonseed.crowd.mapper.MemberPOMapper;

/**  
* Title: MybatisTest 
* Description:  
* @author MelonSeed
* @date 2021年6月2日  
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrowdMainApp.class)
public class MybatisTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MemberPOMapper memberPOMapper;
	
	Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Test
	public void testCon() throws SQLException {
		Connection connection = dataSource.getConnection();
		logger.debug(connection.toString());
	}
	@Test
	public void testMeberPOMapper() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String source = "123456";
		String encode = passwordEncoder.encode(source);
		MemberPO memberPO = new MemberPO(null, "Tom", encode, "汤姆", "Tom@qq.com", 1, 1, "老汤姆", "12345", 1);
		memberPOMapper.insert(memberPO);
	}
}
