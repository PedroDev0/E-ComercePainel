package com.pedro.painelsrvspring.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class JacksonConfig {

	@Value("${spring.jackson.date-format}")
	private String pattern;

	@Bean
	public ObjectMapper objectMapper() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		JavaTimeModule javaTimeModule = new JavaTimeModule();

		javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));

		mapper.registerModule(javaTimeModule);

		return mapper;
	}
}
