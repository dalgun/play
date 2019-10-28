package dalgun.github.io.refactoring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PayInfo {

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
    @JsonFormat(pattern = "yyyyMMdd hh:mm:ss")
    private LocalDateTime requestDateTime;

    /**
     * 전문타입
     */
    private String type;

}

