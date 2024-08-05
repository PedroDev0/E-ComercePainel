package com.pedro.painelsrv.filter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;

@Provider
public class JsonFilter extends JacksonJsonProvider {

    private static final List<SimpleDateFormat> DATE_FORMATS = new ArrayList<>();

    static {
        DATE_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        DATE_FORMATS.add(new SimpleDateFormat("yyyy-MM-dd"));
        DATE_FORMATS.add(new SimpleDateFormat("MM-dd-yyyy"));
        DATE_FORMATS.add(new SimpleDateFormat("dd/MM/yyyy"));
    }

    public JsonFilter() {
        ObjectMapper objectMapper = locateMapper(ObjectMapper.class, MediaType.APPLICATION_JSON_TYPE);
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Registrar deserializador e serializador customizados
        SimpleModule module = new SimpleModule("CustomDateModule", Version.unknownVersion());
        module.addDeserializer(Date.class, new CustomDateDeserializer());
        module.addSerializer(Date.class, new CustomDateSerializer());

        objectMapper.registerModule(module);
    }

    private static class CustomDateDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
            String dateStr = jsonParser.getText();
            for (SimpleDateFormat dateFormat : DATE_FORMATS) {
                try {
                    return dateFormat.parse(dateStr);
                } catch (ParseException e) {
                    // Continue to the next format
                }
            }
            throw new IOException("Cannot parse date: " + dateStr);
        }
    }

    private static class CustomDateSerializer extends JsonSerializer<Date> {
        private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
            String formattedDate = outputFormat.format(date);
            jsonGenerator.writeString(formattedDate);
        }
    }
}

