/**  
* Title: RedisRemoteService.java  
* Description:   
* @author MelonSeed
* @date 2021年6月3日  
* @version 1.0  
*/
package cn.melonseed.crowd;

import java.util.concurrent.TimeUnit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.melonseed.crowd.util.ResultEntity;

/**  
* Title: RedisRemoteService 
* Description:  
* @author MelonSeed
* @date 2021年6月3日  
*/
@FeignClient("crowd-redis")
public interface RedisRemoteService {

    @RequestMapping("/set/redis/key/value/remote")
    ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value
    );

    @RequestMapping("/set/redis/key/value/with/timeout/remote")
    ResultEntity<String> setRedisKeyValueWithTimeoutRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit
            );

    @RequestMapping("/get/redis/value/by/key/remote")
    ResultEntity<String> getRedisValueByKeyRemote(
            @RequestParam("key") String key
    );

    @RequestMapping("/remove/redis/key/by/key/remote")
    ResultEntity<String> removeRedisKeyByKeyRemote(
            @RequestParam("key") String key
    );
}
