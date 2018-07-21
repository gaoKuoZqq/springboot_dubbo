package com.consumer;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import util.VisiableThreadPoolTaskExecutor;

public class ExecutorConfig {
	private Logger log = LoggerFactory.getLogger(this.getClass());

    /** 
     * @Title: asyncServiceExecutor 
     * @Description: 线程池
     * @author gaokuo
     * @date 2018年7月11日 上午10:15:15
     * @return Executor
     */
    @Bean
    public Executor asyncServiceExecutor() {
    	log.info("start resultExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(20);
        //配置队列大小
        executor.setQueueCapacity(20);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("result-");
        executor.setKeepAliveSeconds(300);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
