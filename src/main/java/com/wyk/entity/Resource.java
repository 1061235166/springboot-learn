package com.wyk.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TableName(value = "resource")
public class Resource {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Date createTime;
    private Date updateTime;
    private String resourcePath;
    private Integer resourceType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

//    int a=0;
//    volatile int b=0;
//    public static void main(String[] args) {
//
//        Resource resource = new Resource();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                resource.b = 1;
//            }
//        });
//
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (resource.b==0){
//                    System.out.println("loop b");
//                }
//            }
//        });
//
//        executorService.shutdown();
//    }

    @Override
    public String toString() {
        return ""+id+createTime+updateTime+resourcePath+"";
    }
}
