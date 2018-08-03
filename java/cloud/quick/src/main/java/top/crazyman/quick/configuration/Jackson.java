package top.crazyman.quick.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/31
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@Configuration
public class Jackson {

    @Bean
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            /**
             * Method that can be called to ask implementation to serialize
             * values of type this serializer handles.
             *
             * @param value       Value to serialize; can <b>not</b> be null.
             * @param gen         Generator used to output resulting Json content
             * @param serializers Provider that can be used to get serializers for
             */
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
                gen.writeString("");
            }
        });
        return objectMapper;
    }
}
