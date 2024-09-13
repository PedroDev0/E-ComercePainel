package com.pedro.painelsrvspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfig {

	 @Bean
	    public Jackson2ObjectMapperBuilder jacksonBuilder() {
	        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	        builder.simpleDateFormat("dd/MM/yyyy");  
	        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	        return builder;
	    }
}
