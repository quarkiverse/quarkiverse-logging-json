package io.quarkiverse.loggingjson.jsonb;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.json.JsonStructure;
import javax.json.JsonValue;

import org.eclipse.yasson.YassonJsonb;

import io.quarkiverse.loggingjson.JsonGenerator;

public class JsonbJsonGenerator implements JsonGenerator {
    private final javax.json.stream.JsonGenerator generator;
    private final YassonJsonb jsonb;

    public JsonbJsonGenerator(javax.json.stream.JsonGenerator generator, YassonJsonb jsonb) {
        this.generator = generator;
        this.jsonb = jsonb;
    }

    @Override
    public void writeStartObject() {
        this.generator.writeStartObject();
    }

    @Override
    public void writeEndObject() {
        this.generator.writeEnd();
    }

    @Override
    public void flush() {
        this.generator.flush();
    }

    @Override
    public void close() {
        this.generator.close();
    }

    @Override
    public void writeFieldName(String name) {
        this.generator.writeKey(name);
    }

    @Override
    public void writeObject(Object pojo) {
        customWriteObject(null, pojo);
    }

    @Override
    public void writeObjectFieldStart(String fieldName) {
        this.generator.writeStartObject(fieldName);
    }

    @Override
    public void writeObjectField(String fieldName, Object pojo) {
        customWriteObject(fieldName, pojo);
    }

    @Override
    public void writeArrayFieldStart(String fieldName) {
        this.generator.writeStartArray(fieldName);
    }

    @Override
    public void writeEndArray() {
        this.generator.writeEnd();
    }

    @Override
    public void writeString(String text) {
        this.generator.write(text);
    }

    @Override
    public void writeStringField(String fieldName, String value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, short value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, int value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, long value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, BigInteger value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, float value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, double value) {
        this.generator.write(fieldName, value);
    }

    @Override
    public void writeNumberField(String fieldName, BigDecimal value) {
        this.generator.write(fieldName, value);
    }

    private void customWriteObject(final String key, final Object obj) {
        if (obj == null) {
            if (key == null) {
                generator.writeNull();
            } else {
                generator.writeNull(key);
            }
        } else if (obj instanceof Boolean) {
            final Boolean value = (Boolean) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof Short) {
            final Short value = (Short) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof Integer) {
            final Integer value = (Integer) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof Long) {
            final Long value = (Long) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof Double) {
            final Double value = (Double) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof BigInteger) {
            final BigInteger value = (BigInteger) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof BigDecimal) {
            final BigDecimal value = (BigDecimal) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof String) {
            final String value = (String) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj instanceof JsonValue) {
            final JsonValue value = (JsonValue) obj;
            if (key == null) {
                generator.write(value);
            } else {
                generator.write(key, value);
            }
        } else if (obj.getClass().isArray()) {
            final Object[] value = (Object[]) obj;
            if (key == null) {
                generator.writeStartArray();
            } else {
                generator.writeStartArray(key);
            }
            for (Object o : value) {
                customWriteObject(null, o);
            }
            generator.writeEnd();
        } else if (obj instanceof List) {
            final List<?> value = (List<?>) obj;
            if (key == null) {
                generator.writeStartArray();
            } else {
                generator.writeStartArray(key);
            }
            for (Object o : value) {
                customWriteObject(null, o);
            }
            generator.writeEnd();
        } else {
            if (key == null) {
                final JsonStructure jsonStructure = jsonb.toJsonStructure(obj);
                this.generator.write(key, jsonStructure);
            } else {
                final JsonStructure jsonStructure = jsonb.toJsonStructure(obj);
                this.generator.writeKey(key);
                if (jsonStructure.equals(JsonValue.EMPTY_JSON_OBJECT)) {
                    this.generator.writeStartObject();
                    this.generator.writeEnd();
                } else {
                    this.generator.write(jsonStructure);
                }
            }
        }
    }
}
