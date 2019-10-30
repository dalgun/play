DELETE FROM pay_info;
INSERT INTO pay.pay_info ( amount, card_nm, card_no, installment_period, product, request_date_time, success_yn, user_name, type) VALUES ( 1000, '아메리카익스프레스', '1234123412341234', '00', '프로포폴', NOW(), 'N', '홍길동', 'A');
INSERT INTO pay.pay_info ( amount, card_nm, card_no, installment_period, product, request_date_time, success_yn, user_name, type) VALUES ( 1000, '삼성', '1234123412341234', '03', '프로포폴', NOW(), 'Y', '신민아', 'B');
INSERT INTO pay.pay_info ( amount, card_nm, card_no, installment_period, product, request_date_time, success_yn, user_name, type) VALUES ( 1000, '신한', '1234123412341234', '12', '프로포폴', NOW(), 'Y', '이하늬', 'A');
INSERT INTO pay.pay_info ( amount, card_nm, card_no, installment_period, product, request_date_time, success_yn, user_name, type) VALUES ( 1000, '국민
', '1234123412341234', '06', '프로포폴', NOW(), 'N', '김사랑
', 'C');
INSERT INTO pay.pay_info ( amount, card_nm, card_no, installment_period, product, request_date_time, success_yn, user_name, type) VALUES ( 1000, '하나
', '1234123412341234', '00', '프로포폴', NOW(), 'N', '솔라
', 'A');