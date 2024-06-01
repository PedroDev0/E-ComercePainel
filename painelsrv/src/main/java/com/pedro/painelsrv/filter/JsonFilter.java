package com.pedro.painelsrv.filter;

import java.text.SimpleDateFormat;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

@Provider
public class JsonFilter extends JacksonJsonProvider {

	public JsonFilter() {

		ObjectMapper objectMapper = locateMapper(ObjectMapper.class, MediaType.APPLICATION_JSON_TYPE);
		objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
}