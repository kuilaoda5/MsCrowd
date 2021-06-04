/**  
* Title: CrowdTest.java  
* Description:   
* @author MelonSeed
* @date 2021年5月24日  
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.melonseed.crowd.entity.Admin;
import cn.melonseed.crowd.entity.Role;
import cn.melonseed.crowd.mapper.AdminMapper;
import cn.melonseed.crowd.mapper.RoleMapper;
import cn.melonseed.crowd.service.api.AdminService;
import cn.melonseed.crowd.service.api.RoleService;


/**  
* Title: CrowdTest 
* Description:  
* @author MelonSeed
* @date 2021年5月24日  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMapper roleMapper;
	@Test
	public void testConection() throws SQLException{
//		Connection c = dataSource.getConnection();
//		System.out.println(c);
	}
	
//	@Test
//	public void testAdmin() throws SQLException{
//		for(int i = 0; i<238; i++) {
//			Admin admin = new Admin(null, "tom"+i, "123456", "唐猫"+i, "tom@163.com", null);
//			int count = adminMapper.insert(admin);
//			System.out.println("受影响的行数："+count);
//		}
//	}
//	@Test
//	public void testLog(){
//	    //获取Logger对象，这里传入的Class就是当前打印日志的类
//	    Logger logger = LoggerFactory.getLogger(CrowdTest.class);
//	    //等级 DEBUG < INFO < WARN < ERROR
//	    logger.debug("I am DEBUG!!!");
//
//	    logger.info("I am INFO!!!");
//
//	    logger.warn("I am WARN!!!");
//
//	    logger.error("I am ERROR!!!");
//
//	}
//	@Test
//	public void testTx() {
//		Admin admin = new Admin(null, "tom", "123456", "唐猫", "tom@163.com", null);
//		adminService.saveAdmin(admin);
//	}
	@Test
	public void testRole() {
		for(int i = 0; i<238; i++) {
			Role role = new Role(null, "boss"+i);
			int count = roleMapper.insert(role);
			System.out.println("受影响的行数："+count);
		}
	}
	
}
