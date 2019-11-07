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
        , include = JsonTypeInfo.As.EXISTING_PROPERTY // 이 설정이 들어가면, super 와 그것을 상속받는 객체에 중복값이 안나온다
        , property = "reservationType" //json 안의 어떤 키값으로 타입을 결정할지 키값
        , defaultImpl = SimpleReservationBase.class) // 키값이 없을 경우 디폴트로 설정할 class
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
