package dalgun.github.io.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author dalgun
 * @since 2019-10-30
 */
@Converter(autoApply = true)
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String yn) {
        return "Y".equals(yn);
    }
}
