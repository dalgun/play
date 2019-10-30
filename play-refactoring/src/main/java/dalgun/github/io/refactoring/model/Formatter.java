package dalgun.github.io.refactoring.model;

import dalgun.github.io.model.PayInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dalgun
 * Date: 26/10/2019
 * Time: 7:07 PM
 */
public interface Formatter {

    String getFormat(PayInfo payinfo);

    Formatter DEFAULT_TYPE = new Formatter() {
        @Override
        public String getFormat(PayInfo payInfo) {
            //결제자(5)+결제금액(10)+결제품목(10)+카드사명(5)+카드번호(16)+할부기간(2)+요청시각(20)
            return String.format("%-5s%-10s%-10s%-5s%-16s%-2s%-20s",
                    payInfo.getUserName(),
                    payInfo.getAmount(),
                    payInfo.getProduct(),
                    payInfo.getCardNm(),
                    payInfo.getCardNo(),
                    payInfo.getInstallmentPeriod(),
                    payInfo.getRequestDateTime());
        }
    };
    class A_TYPE_FORMAT implements Formatter{
        @Override
        public String getFormat(PayInfo payinfo) {
            //결제자(10)+결제품목(20)+결제금액(10)+카드명(8)+할부기간(2)
            return String.format("%-10s%-20s%-10s%-8s%-2s",
                    payinfo.getUserName(),
                    payinfo.getProduct(),
                    payinfo.getAmount(),
                    payinfo.getCardNm(),
                    payinfo.getInstallmentPeriod());
        }
    }


    class B_TYPE_FORMAT implements Formatter {
        @Override
        public String getFormat(PayInfo payinfo) {
            //MOBILE(고정):카드명:카드번호:결제금액:할부기간:결제자
            List payInfoData = new ArrayList();
            payInfoData.add(payinfo.getCardNm());
            payInfoData.add(payinfo.getCardNo());
            payInfoData.add(payinfo.getAmount());
            payInfoData.add(payinfo.getInstallmentPeriod());
            payInfoData.add(payinfo.getUserName());
            return "MOBILE:"+payInfoData.stream().collect(Collectors.joining(":")).toString();
        }
    }



}
