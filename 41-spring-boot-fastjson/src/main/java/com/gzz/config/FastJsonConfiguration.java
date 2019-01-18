package com.gzz.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 将fastjson添加到视图消息转换器列表内
		converters.add(fastConverter);
	}
}
// DisableCircularReferenceDetect禁用循环引用