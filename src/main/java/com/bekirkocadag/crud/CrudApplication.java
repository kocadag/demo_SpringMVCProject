package com.bekirkocadag.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author H.Bekir Kocadag
 */
@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) { SpringApplication.run(CrudApplication.class, args); }

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void configurePathMatch(PathMatchConfigurer configurer) {

			}

			@Override
			public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

			}

			@Override
			public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

			}

			@Override
			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

			}

			@Override
			public void addFormatters(FormatterRegistry registry) {

			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {

			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {

			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/library/list").allowedOrigins("http://localhost:3000");
			}

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {

			}

			@Override
			public void configureViewResolvers(ViewResolverRegistry registry) {

			}

			@Override
			public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

			}

			@Override
			public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

			}

			@Override
			public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

			}

			@Override
			public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

			}

			@Override
			public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

			}

			@Override
			public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

			}

			@Override
			public Validator getValidator() {
				return null;
			}

			@Override
			public MessageCodesResolver getMessageCodesResolver() {
				return null;
			}
		};
	}
}
