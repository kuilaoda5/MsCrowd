/**  
* Title: StringTest.java  
* Description:   
* @author MelonSeed
* @date 2021年5月26日  
* @version 1.0  
*/
package cn.melonseed.crowd.test;

import org.junit.Test;

import cn.melonseed.crowd.util.CrowdUtil;

/**  
* Title: StringTest 
* Description:  
* @author MelonSeed
* @date 2021年5月26日  
*/
public class StringTest {
	@Test
	public void testMd5() {
		String sourceString = "123456";
		String encodedString = CrowdUtil.MD5(sourceString);
		System.out.println(encodedString);
		//E10ADC3949BA59ABBE56E057F20F883E
	}
}
