package com.softart.dferestapi.components.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public final class StringStripModule extends SimpleModule {

    private final static class StringStripDeserializer extends StdScalarDeserializer<String> {

        private StringStripDeserializer() {
            super(String.class);
        }

        @Override
        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return jsonParser.getValueAsString().trim();
        }
    }

    public StringStripModule() {
        addDeserializer(String.class, new StringStripDeserializer());
    }
}
