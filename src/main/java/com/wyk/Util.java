package com.wyk;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * Created by wyk on 2018/6/3.
 */
public class Util {
    public static String getMACAddress(InetAddress ia) throws Exception {
// 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

// 下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
// mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length() == 1 ? 0 + s : s);
        }

// 把字符串所有小写字母改为大写成为正规的mac地址并返回
        return sb.toString().toUpperCase();
    }

    public static String getMac(String ip){
        String str = null;
        String mac = null;
        try{
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream(),"gbk");
            LineNumberReader input = new LineNumberReader(ir);
            for (; true;) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC 地址") > 1) {
                        mac = str.substring(str.indexOf("MAC 地址") + 9);
                        break;
                    }
                }
            }
            System.out.println(mac);
        }catch(IOException e){
            e.printStackTrace();
        }
        return mac;
    }
}
