package dev.palhano.mudi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import dev.palhano.mudi.interceptor.AcessInteceptor;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(new AcessInteceptor())
			.addPathPatterns("/**");
	
	}
}
