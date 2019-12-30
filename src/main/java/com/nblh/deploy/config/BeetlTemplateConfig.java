package com.nblh.deploy.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

/**
 * beetl集成springboot配置
 */
@Configuration
@Component
public class BeetlTemplateConfig {

	private static final String PREFIX = "/META-INF/resources/WEB-INF/pages/";

	private static final String SUFFIX = ".html";

	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	/*
	 @Bean(initMethod = "init", name = "beetlConfig")
	 public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
	 BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new
	 BeetlGroupUtilConfiguration();
	 ClasspathResourceLoader crl = new ClasspathResourceLoader(PREFIX);
	 beetlGroupUtilConfiguration.setResourceLoader(crl);
	 beetlGroupUtilConfiguration.init();
	 return beetlGroupUtilConfiguration;
	 } 
	*/
	
	@Bean(initMethod = "init", name = "beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
		ClasspathResourceLoader crl = new ClasspathResourceLoader();
		ResourcePatternResolver patternResolver = ResourcePatternUtils
				.getResourcePatternResolver(new DefaultResourceLoader());
		Resource fileResource = patternResolver.getResource("classpath:/beetl.properties");
		beetlGroupUtilConfiguration.setConfigFileResource(fileResource);
		beetlGroupUtilConfiguration.setResourceLoader(crl);
		return beetlGroupUtilConfiguration;
	}

	/**
	 * 模板解析器
	 * 
	 * @param beetlGroupUtilConfiguration
	 * @return
	 */
	@Bean(name = "beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver(
			@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setSuffix(SUFFIX);
		beetlSpringViewResolver.setContentType(CONTENT_TYPE);
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
		return beetlSpringViewResolver;
	}

}
