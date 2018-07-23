package com.wyk.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wyk.entity.Resource;
import com.wyk.mapper.ResourceMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by wyk on 2018/2/23.
 */
@Service
public class ResourceService {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\wyk\\Desktop\\福汇模拟账号.txt")));
        String r = null;
        while ((r=reader.readLine())!=null){
            System.out.println(r);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\wyk\\Desktop\\福汇模拟账号.txt"),"gbk");

        reader = new BufferedReader(inputStreamReader);
        while ((r=reader.readLine())!=null){
            System.out.println(r);
        }
    }

}
