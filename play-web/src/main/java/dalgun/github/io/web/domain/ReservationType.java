package dalgun.github.io.web.domain;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * @author dalgun
 * @since 2019-11-04
 */
public enum ReservationType {

    @JsonEnumDefaultValue
    SIMPLE,

    CONSULTING,

    DIAGNOSIS
}
