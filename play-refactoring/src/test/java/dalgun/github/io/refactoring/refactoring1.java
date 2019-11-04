package dalgun.github.io.refactoring;

import dalgun.github.io.model.PayInfo;
import dalgun.github.io.refactoring.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by dalgun
 * Date: 27/10/2019
 * Time: 2:27 AM
 */
@Slf4j
public class refactoring1 {
    PayInfo payInfo;

    @Before
    public void init(){

        payInfo = new PayInfo();
        payInfo.setAmount(10000);
        payInfo.setCardNm("아메리카익스프레스");
        payInfo.setCardNo("1234123412341234");
        payInfo.setInstallmentPeriod("03");
        payInfo.setRequestDateTime(LocalDateTime.now());
        payInfo.setProduct("프로포폴");
        payInfo.setUserName("홍길동");
    }

    @Test
    public void 타입에_따른_FORMAT(){
        PayService payService = new PayService();
        payInfo.setType("A");
        String oldString  = payService.oldMethod(payInfo);
        log.info("oldString:<{}>, length:{}", oldString, oldString.length());
        String newString = payService.newMethod(payInfo);
        log.info("newString:<{}>, length:{}", newString, newString.length());
    }

}
