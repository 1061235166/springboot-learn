package com.wyk.controller;

import com.wyk.Util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by k on 2018/6/3.
 */
public class MacServer {
    public static void main(String[] args) throws IOException {
        MacCatch macCatch = new MacCatch();
        macCatch.start();
    }
}
class MacCatch extends Thread{
    private ServerSocket serverSocket;

    public MacCatch() throws IOException {
        serverSocket = new ServerSocket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",80);
        serverSocket.bind(inetSocketAddress);
    }

    @Override
    public void run() {
        try {
            while (true){
                Socket accept = serverSocket.accept();
                InetAddress inetAddress = accept.getInetAddress();
                System.out.println(inetAddress);
                String hostName = inetAddress.getHostName();
                System.out.println(hostName);
                String mac = Util.getMac(hostName);
                System.out.println(mac);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
