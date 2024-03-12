package com.baseline.wais.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.baseline.wais.common", "com.baseline.wais.business"})
@EntityScan({"com.baseline.wais.common.entity", "com.baseline.wais.business.entity"})
@EnableMongoRepositories({"com.baseline.wais.common.repository", "com.baseline.wais.business.repository"})
public class EntryPoint extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EntryPoint.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}
}
