package com.wyk.service;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import sun.reflect.Reflection;

import java.util.concurrent.TimeUnit;

/**
 * Created by k on 2019/1/19.
 */
@Service
public class LockService {
    private RedissonClient client = Redisson.create();

    public String doSomething(){
        RLock yourLock = client.getLock("yourLock");
        System.out.println();
        try {
            yourLock.lock();
            System.out.println("开始工作，持续5秒");
            TimeUnit.SECONDS.sleep(5l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            yourLock.unlock();
        }
        return "";
    }


    public static void main(String[] args) {
        Class<?> callerClass = Reflection.getCallerClass();
        System.out.println(callerClass);
    }
}
