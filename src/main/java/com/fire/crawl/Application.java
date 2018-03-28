package com.fire.crawl;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fire.crawl.factory.Initialize;
import com.fire.crawl.service.Crawl;

@SpringBootApplication
public class Application {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 42;
			}
		};
	}

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		Initialize init = applicationContext.getBean(Initialize.class);
		init.init();
		Crawl crawl = applicationContext.getBean(Crawl.class);
		crawl.load();

		System.exit(SpringApplication.exit(applicationContext));
	}

}
