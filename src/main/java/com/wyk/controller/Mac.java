package com.wyk.controller;

import com.wyk.Util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by wyk on 2018/6/3.
 */
public class Mac {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        NetworkInterface localhost = NetworkInterface.getByName("127.0.0.1");
        System.out.println(localhost);
        NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(InetAddress.getByName("localhost"));
        System.out.println(byInetAddress);
        byte[] hardwareAddress = byInetAddress.getHardwareAddress();
        System.out.println(hardwareAddress);

        InetAddress localHost = InetAddress.getLocalHost();
        NetworkInterface byInetAddress1 = NetworkInterface.getByInetAddress(localHost);
        System.out.println(new String(byInetAddress1.getHardwareAddress()));
        byte[] bytes = byInetAddress1.getHardwareAddress();
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<bytes.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = bytes[i]&0xff;
            String str = Integer.toHexString(temp);
            System.out.println("每8位:"+str);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        System.out.println(sb.toString());
    }
}
