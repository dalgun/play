package dalgun.github.io.refactoring.service;

import dalgun.github.io.refactoring.model.Formatter;
import dalgun.github.io.refactoring.model.FormatterFactory;
import dalgun.github.io.refactoring.model.PayInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dalgun
 * Date: 26/10/2019
 * Time: 7:20 PM
 */
@Slf4j
@Service
public class PayService {

    public String oldMethod (PayInfo payInfo){
        String format = "";
        if("A".equals(payInfo.getType())){
            //결제자(10)+결제품목(20)+결제금액(10)+카드명(8)+할부기간(2)
            format =  String.format("%-10s%-20s%-10s%-8s%-2s",
                    payInfo.getUserName(),
                    payInfo.getProduct(),
                    payInfo.getAmount(),
                    payInfo.getCardNm(),
                    payInfo.getInstallmentPeriod());

        }else if("B".equals(payInfo.getType())){
            //MOBILE(고정):카드명:카드번호:결제금액:할부기간:결제자
            List payInfoData = new ArrayList();
            payInfoData.add(payInfo.getCardNm());
            payInfoData.add(payInfo.getCardNo());
            payInfoData.add(payInfo.getAmount());
            payInfoData.add(payInfo.getInstallmentPeriod());
            payInfoData.add(payInfo.getUserName());
            format =  "MOBILE:"+payInfoData.stream().collect(Collectors.joining(":")).toString();
        }else{
            //결제자(5)+결제금액(10)+결제품목(10)+카드사명(5)+카드번호(16)+할부기간(2)+요청시각(20)
            format = String.format("%-5s%-10s%-10s%-5s%-16s%-2s%-20s",
                    payInfo.getUserName(),
                    payInfo.getAmount(),
                    payInfo.getProduct(),
                    payInfo.getCardNm(),
                    payInfo.getCardNo(),
                    payInfo.getInstallmentPeriod(),
                    payInfo.getRequestDateTime());
        }

        return format;
    }

    public String newMethod(PayInfo payInfo){
        FormatterFactory formatterFactory = new FormatterFactory();
        Formatter formatter = formatterFactory.getFormatterType(payInfo.getType());
        return formatter.getFormat(payInfo);
    }
}
