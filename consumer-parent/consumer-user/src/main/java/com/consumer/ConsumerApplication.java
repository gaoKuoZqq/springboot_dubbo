package com.consumer;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.Log4jConfigListener;

@SpringBootApplication
@RestController
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	@RequestMapping("/test")
	public String test() {
		return "ConsumerApplication->success!";
	}
    /** 
     * @Title: asyncServiceExecutor 
     * @Description: 业绩计算线程池
     * @author gaokuo
     * @date 2018年7月11日 上午10:15:15
     * @return Executor
     */
    @Bean
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(20);
        //配置队列大小
        executor.setQueueCapacity(999);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("result-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
