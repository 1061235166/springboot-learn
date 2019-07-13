package com.wyk;

import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;

/**
 * Created by wyk on 2019/7/13.
 */
public class RedisPubSubUtils {


    private static RedissonClient redissonClient = Redisson.create();

    public static void publish(String channel,Object msg){
        RTopic<Object> topic = redissonClient.getTopic(channel);
        topic.publish(msg);
    }

    public static void subs(String channel, MessageListener<Object>listener){
        RTopic<Object> topic = redissonClient.getTopic(channel);
        int i = topic.addListener(listener);
    }

}
