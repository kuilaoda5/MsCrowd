/**  
* Title: ResultEntity.java  
* Description:   
* @author MelonSeed
* @date 2021年5月25日  
* @version 1.0  
*/
package cn.melonseed.crowd.util;

/**  
* Title: ResultEntity 
* Description:  统一整个项目Ajax请求返回结果，分布式架构也会用到。
* @author MelonSeed
* @date 2021年5月25日  
*/
public class ResultEntity<T> {
	//设置两个常量
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    //请求错误时，返回的错误信息，对应SUCCESS与FAILED
    private String message;

    //要返回的数据
    private T data;

    //封装当前请求的处理结果是成功还是失败
    private String result;

    

    /**
	 * 
	 */
	public ResultEntity() {
			
	}

	/**
	 * @param message
	 * @param data
	 * @param result
	 */
	public ResultEntity(String message, T data, String result) {
		super();
		this.message = message;
		this.data = data;
		this.result = result;
	}

	//请求处理成功并且不向前端返回数据时，使用的静态方法
    //第一个<Type>表示声明一个泛型Type，第二个和return中的<Type>表示使用该泛型
    public static <Type> ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(null,null,SUCCESS);
    }
    
	//请求处理成功并且向前端返回数据时，使用的静态方法
    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(null,data,SUCCESS);
    }
    
	//请求处理失败，需要返回错误信息时，使用的静态方法
    public static <Type> ResultEntity<Type> failed(String message){
        return new ResultEntity<Type>(message,null,FAILED);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
