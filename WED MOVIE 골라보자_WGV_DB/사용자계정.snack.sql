create table snack (
   foodname varchar2(25), 
   price number,           
   amount NUMBER CHECK 
   (amount >= 0) 
   );   
   
   
-- 테이블 확인
select * from tab;

-- 테이블 구조 확인
desc snack;
select * from snack where like = '더블콤보';
select amount from snack where foodname ='더블콤보';
-- 데이터 삽입
insert into snack values ('더블콤보',13000 , 5);
insert into snack values('라지콤보',15000,5);
insert into snack values('스몰세트',7000,5);
insert into snack values('CGV콤보',10000,5);
insert into snack values('우리 패키지',61000,5);
insert into snack values('나랑 너 패키지',34000,5);
insert into snack values('더블치즈팝콘M',6000,5);
insert into snack values('바질어니언팝콘M',6000,5);
insert into snack values('달콤팝콘M',6000,5);
insert into snack values('더블치즈팝콘L',6500,5);
insert into snack values('바질어니언팝콘L',6500,5);
insert into snack values('달콤팝콘L',6500,5);
insert into snack values('핑크레몬에이드',5500,5);
insert into snack values('에이드',5500,5);
insert into snack values('아메리카노ICE',4500,5);
insert into snack values('아메리카노HOT',4000,5);
insert into snack values('탄산음료L',3500,5);
insert into snack values('탄산음료M',3000,5);
insert into snack values('칠리치즈나쵸',4900,5);
insert into snack values('플레인핫도그',4500,5);
insert into snack values('칠리치즈핫도그',5000,5);
insert into snack values('맛밤',3500,5);


update snack set amount=30; --수량 리셋 
select * from snack;
commit;

SELECT foodname, amount FROM snack;
select amount from snack where foodname = '플레인핫도그';
select into pay values;



--drop table snackback purge;



select * from pay;
