package dalgun.github.io.web.endpoint;

import dalgun.github.io.web.domain.ReservationBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalgun
 * @since 2019-11-04
 */
@Slf4j
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @PostMapping("/v1")
    public ResponseEntity post(@Validated @RequestBody ReservationBase reservationBase){

        log.debug("TYPE", reservationBase.getReservationType());

        return ResponseEntity.ok().body(reservationBase);

    }

}
