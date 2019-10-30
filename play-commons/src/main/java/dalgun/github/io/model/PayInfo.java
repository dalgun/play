package dalgun.github.io.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dalgun.github.io.utils.BooleanToYNConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by dalgun
 * Date: 26/10/2019
 * Time: 7:08 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PayInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    /**
     * 사용자명
     */
    private String userName;

    /**
     * 결제금액
     */
    private int amount;

    /**
     * 결제품목
     */
    private String product;

    /**
     * 카드사명
     */
    private String cardNm;

    /**
     * 카드번호
     */
    private String cardNo;

    /**
     * 할부기간
     */
    private String installmentPeriod;

    /**
     * 요청시각
     */
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime requestDateTime;

    /**
     * 전문타입
     */
    @Convert(converter = BooleanToYNConverter.class)
    private boolean successYn;

    private String type;

}
