package com.wyk;

import com.google.common.collect.Lists;
import com.wyk.annotation.AutoPrint;
import com.wyk.annotation.AutoPrintBean;
import com.wyk.config.ExistsBean;
import com.wyk.config.ExistsCondition;
import com.wyk.config.SubExsistBean;
import com.wyk.config.processor.DefaultBeanFactoryPostProcessor;
import com.wyk.config.processor.DefaultProcessor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.web.context.WebApplicationContext;

import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.StreamSupport;

@SpringBootApplication
@MapperScan(basePackages = "com.wyk.mapper")
@AutoPrint
public class SpringbootmybatisplusApplication {

	@Bean
	@Conditional(ExistsCondition.class)
	public ExistsBean bean(){
		return new ExistsBean();
	}

	@Bean
	public DefaultProcessor defaultProcessor(){
		return new DefaultProcessor();
	}

	@Bean
	public DefaultBeanFactoryPostProcessor factoryPostProcessor(){
		return new DefaultBeanFactoryPostProcessor();
	}

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootmybatisplusApplication.class, args);
//		System.out.println(context.getBean("bean"));

		System.out.println(context.getBean(SubExsistBean.class));

//		Arrays.stream(beanDefinitionNames).forEach((s)->{
//			System.out.println(context.getBean(s).getClass());
//		});
//		SpringApplication application = new SpringApplication(SpringbootmybatisplusApplication.class);
//
//		application.setBanner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.println("ahjsdkhkajsd");
//			}
//		});

//		System.out.println(Integer.class.getName());
//		System.out.println(Number.class.getName());
//
//		System.out.println(Number.class.isAssignableFrom(Integer.class));
//
//		System.out.println(EnvironmentCapable.class.isAssignableFrom(ApplicationContext.class));
//
//		System.out.println();

//		System.out.println(0x61c88647);
//		System.out.println(Math.min(0x61c88647,Integer.MAX_VALUE));
//		System.out.println(Integer.toHexString(1640531527));
//		System.out.println(0x1123);


//		for(int i =0;i<10000;i++){
//			out();
//		}
//		countDownLatch.await();
//		System.out.println("size:"+sets.size());

//		out2();

		Class<? extends Annotation> requiredClass = Required.class;

		System.out.println(requiredClass);


		Lists.newArrayList(1,2,3,4).forEach(System.out::println);
	}



	static Set<Integer>sets = new HashSet<>();

	static Executor executor = Executors.newFixedThreadPool(10000);

	static CountDownLatch countDownLatch = new CountDownLatch(10000);

	private static void out(){
		executor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Field threadLocalHashCode = ThreadLocal.class.getDeclaredField("threadLocalHashCode");
					threadLocalHashCode.setAccessible(true);
					ThreadLocal threadLocal = new ThreadLocal();
					Object o = threadLocalHashCode.get(threadLocal);
					System.out.println(o+"_"+countDownLatch.getCount());
					sets.add((int)o);
					countDownLatch.countDown();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static void out2()  {
		ThreadLocal threadLocal = new ThreadLocal();
		threadLocal.set("1");
		threadLocal.set("2");
		threadLocal.set("3");
		threadLocal.set("4");
		threadLocal.set("5");
		threadLocal.set("6");


		try {
			Class<?> aClass = Class.forName("java.lang.ThreadLocal$ThreadLocalMap");
			Field table = aClass.getDeclaredField("table");
			table.setAccessible(true);

			Field inheritableThreadLocals = Thread.currentThread().getClass().getDeclaredField("threadLocals");

			inheritableThreadLocals.setAccessible(true);
			Object o1 = inheritableThreadLocals.get(Thread.currentThread());
			System.out.println(o1);

			Object o = table.get(o1);
			System.out.println(o);
			Object[]objects = (Object[]) o;
			for(Object o2:objects){
				if(o2!=null){
					Class<?> aClass1 = Class.forName("java.lang.ThreadLocal$ThreadLocalMap$Entry");
					outFiled(aClass1,"value",o2);
//					System.out.println(aClass1);

				}
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}

	private static void outFiled(Class clz,String name,Object obj){
		try {
			Field field = clz.getDeclaredField(name);
			field.setAccessible(true);
			Object o = field.get(obj);
			System.out.println(o);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
