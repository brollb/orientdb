package com.orientechnologies.orient.core.serialization.serializer.record.json.vserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.orientechnologies.orient.core.serialization.serializer.record.json.ValueSerializer;

import java.io.IOException;

public class DoubleSerializer implements ValueSerializer {
    @Override
    public void toJSON(final JsonGenerator generator,final Object value) throws IOException {
        if (value == null) {
            generator.writeNull();
            return;
        }

        generator.writeNumber((double) value);
    }

    @Override
    public String typeId() {
        return "d";
    }
}
