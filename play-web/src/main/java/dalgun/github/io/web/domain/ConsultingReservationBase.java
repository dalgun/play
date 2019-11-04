package dalgun.github.io.web.domain;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author dalgun
 * @since 2019-11-04
 */
@Data
//@ToString(callSuper = true)
public class ConsultingReservationBase extends ReservationBase {

    ConsultingReservationBase(){ super(ReservationType.CONSULTING);}

//    @NotEmpty(message = "consultation type 은 FAMILY, FRIEND, COMPANY 중에 선택하셔야 합니다")
    private ConsultationType consultationType;

//    @NotEmpty(message = "memo 는 null 이 아니며, 최소 10자리에서 최대 500자리까지 기입하셔야 합니다")
    @Size(min = 10, max = 500)
    private String memo;

}
