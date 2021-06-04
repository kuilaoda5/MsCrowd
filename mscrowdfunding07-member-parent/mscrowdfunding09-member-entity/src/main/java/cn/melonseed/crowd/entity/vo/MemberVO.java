/**  
* Title: MemberVO.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* Title: MemberVO 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {
    private String loginAcct;

    private String userPswd;

    private String userName;

    private String email;

    private String phoneNum;

    private String code;

}
