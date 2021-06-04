/**  
* Title: LoginFailedException.java  
* Description:   
* @author MelonSeed
* @date 2021年5月26日  
* @version 1.0  
*/
package cn.melonseed.crowd.exception;

/**  
* Title: LoginFailedException 
* Description:  
* @author MelonSeed
* @date 2021年5月26日  
*/
public class LoginFailedException extends RuntimeException{
	public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
