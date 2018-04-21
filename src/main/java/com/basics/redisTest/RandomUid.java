package com.basics.redisTest;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @PACKAGE_NAME: com.basics.redisTest
 * @PROJECT_NAME: JavaCode
 * @Date: 2018/4/19
 * @author: Jossc
 * reids id 生成策略
 */
public class RandomUid {
    private  static Jedis jedis = new Jedis("127.0.0.1",6379);
   /* private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        protected synchronized SimpleDateFormat initialValue() {
            return  new SimpleDateFormat("yy-MM-dd", Locale.getDefault());
        }
    };*/
   private static ThreadLocal<SimpleDateFormat>
           threadLocal = ThreadLocal.withInitial(() ->
           new SimpleDateFormat("yy-MM-dd", Locale.getDefault()));
    static {
        jedis.set("redisCount","10000");

    }
    public static void main (String args[]){
        String value = randomId("01",new Date());
        System.out.println("value : " + value);
    }

    public static String randomId(String type,Date date){
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        String dateFomat  = simpleDateFormat.format(date).replaceAll("-","");
        jedis.incr("redisCount");
        String redisValue = jedis.get("redisCount");
        UUID uuid = UUID.randomUUID();
        String uuidValue =  new String(String.valueOf(uuid.hashCode())).
                replaceAll("-","").substring(0,2);
        return type + dateFomat + redisValue + uuidValue;
    }

}
