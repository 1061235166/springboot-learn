package com.wyk.controller;

import com.wyk.Util;
import com.wyk.service.LockService;
import org.aspectj.lang.annotation.Around;
import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.security.Principal;
import java.util.Iterator;

/**
 * Created by wyk on 2018/2/20.
 */
@RestController
public class MainController {

    @Autowired
    private LockService lockService;

    @GetMapping("get")
    public String getIp(HttpServletRequest request){
        String host = request.getHeader("host");
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        return host+"_"+remoteAddr+"_"+remoteHost;
    }

    @GetMapping("mac")
    public String getMac(){
        try {
            String mac = Util.getMac(null);
            System.out.println(mac);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/hello")
    public String hello(){
        System.out.println(1);
        return "hello";
    }

    @GetMapping(value = "/hello2")
    public String hello2(String name){
        System.out.println(name);
        return "hello2";
    }

    @GetMapping(value = "/web")
    public String webReq(WebRequest webRequest){
        System.out.println(webRequest);
        String name = webRequest.getParameter("name");
        Principal userPrincipal =
                webRequest.getUserPrincipal();
        System.out.println(userPrincipal);

        Iterator<String> headerNames = webRequest.getHeaderNames();
        String s = headerNames.toString();

        return "123"+name;
    }


    @GetMapping("/lock")
    public String lock(@RequestParam(name = "lock",required = false)String lock){
        String s = lockService.doSomething();
        return "lock结束";
    }

    public static void main(String[] args) throws IOException {

        System.out.println(1024|2048);

        System.out.println(1024 & 3072);

        System.out.println(2048 & 3072);

        System.out.println(2048+1024 & 2048);

        System.out.println(1+1);

        InetAddress inetAddress = InetAddress.getByName("www.google.com");

        boolean reachable = inetAddress.isReachable(1);
        System.out.println(reachable);

        Process exec = Runtime.getRuntime().exec("ping www.baidu.com");
        OutputStream outputStream = exec.getOutputStream();
        InputStream inputStream = exec.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String s = reader.readLine();
        System.out.println(s);
        System.out.println(inputStream.available());
    }
}
