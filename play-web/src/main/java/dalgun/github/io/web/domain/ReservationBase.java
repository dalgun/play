package dalgun.github.io.web.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author dalgun
 * @since 2019-11-04
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME
        , include = JsonTypeInfo.As.EXISTING_PROPERTY
        , property = "reservationType")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "SIMPLE", value = SimpleReservationBase.class),
        @JsonSubTypes.Type(name = "CONSULTING", value = ConsultingReservationBase.class),
        @JsonSubTypes.Type(name = "DIAGNOSIS", value = DiagnosisReservationBase.class)
})
public class ReservationBase {

    public ReservationBase(ReservationType reservationType){this.reservationType = reservationType;}

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String reservationDt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String reservationTm;

    private ReservationType reservationType;

}
