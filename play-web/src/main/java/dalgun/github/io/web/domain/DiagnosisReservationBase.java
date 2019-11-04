package dalgun.github.io.web.domain;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author dalgun
 * @since 2019-11-04
 */
@Data
//@ToString(callSuper = true)
public class DiagnosisReservationBase extends ReservationBase {

    DiagnosisReservationBase(){super(ReservationType.DIAGNOSIS);}

//    @NotEmpty(message = "symptom 은 null 이 아니며, 최소 10자리에서 최대 500자리까지 기입하셔야 합니다")
    @Size(min = 10, max = 500)
    private String symptom;
}
