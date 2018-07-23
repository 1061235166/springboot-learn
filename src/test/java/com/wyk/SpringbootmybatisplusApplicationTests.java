package com.wyk;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.toolkit.SystemClock;
import com.wyk.entity.Resource;
import com.wyk.mapper.ResourceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootmybatisplusApplicationTests {

	@Autowired
	ResourceMapper resourceMapper;

	@Test
	public void contextLoads() {
		System.out.println(resourceMapper);

		Resource resource = new Resource();

		byte i = (byte) ThreadLocalRandom.current().nextInt();

		resource.setResourcePath(i+"");
		resource.setResourceType((int)i);
		Date date = new Date();
		resource.setCreateTime(date);
		resource.setUpdateTime(date);
		resourceMapper.insert(resource);

		Resource id = resourceMapper.selectById(2);

		System.out.println(id);

//		EntityWrapper entityWrapper = new EntityWrapper<Resource>();
//
//		entityWrapper.setEntity(new Resource());
//
//		entityWrapper.eq("id",1);
//
//		Resource entity1 = (Resource) entityWrapper.getEntity();
//
//		System.out.println(entity1.getId());
//
//		Wrapper wrapper = entityWrapper.where("id={0}", 1);
//
//		String sqlSegment = wrapper.getSqlSegment();
//
//		System.out.println(sqlSegment);
//
//		Object entity = wrapper.getEntity();
//
//		System.out.println(entity);
//
//		Resource resource = (Resource) entity;
//
//		System.out.println(resource.getCreateTime());
//
//		System.out.println(resource.getId());
	}

}
