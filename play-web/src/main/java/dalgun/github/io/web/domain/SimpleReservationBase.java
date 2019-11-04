package dalgun.github.io.web.domain;

import lombok.Data;

/**
 * @author dalgun
 * @since 2019-11-04
 */
@Data
//@ToString(callSuper = true)
public class SimpleReservationBase extends ReservationBase {

    SimpleReservationBase(){super(ReservationType.SIMPLE);}

}
