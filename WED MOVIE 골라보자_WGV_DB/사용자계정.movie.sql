
-- 음식 테이블 (카테, 이름)

-- 이름, 주민 ,id ,password,email ,영화명=null;
--create table name(
--    num number,
--    name varchar2(100),
--    age varchar2(50)
--   );

-- 영화 테이블 + 예매 수량 
create table movie(
    num number,
    name varchar2(100),
    age varchar2(50),
    ageimage  varchar2(100),
    image varchar2(100)
   );
   
-- 테이블 확인
select * from tab;

-- 테이블 구조 확인
desc movie;

-- 테이블 삭제
drop table movie purge;

-- insert 
insert into movie values(1,'범죄도시4','15','image/15.png','image/범죄.png');
insert into movie values(2,'스턴트맨','15','image/15.png','image/스턴트맨.png');
insert into movie values(3,'혹성탈출-새로운 시대','12','image/12.png','image/혹성.png');
insert into movie values(4,'악마와의토크쇼','15','image/15.png','image/악마.png');
insert into movie values(5,'쿵푸팬더4','ALL','image/ALL.png','image/쿵푸팬더4.png');
insert into movie values(6,'꼬마참새리차드-신비한보석탐험대','ALL','image/ALL.png','image/꼬마참새.png');
insert into movie values(7,'포켓몬스터-성도지방 이야기, 최종장','ALL','image/ALL.png','image/포켓몬.png');
insert into movie values(8,'챌린저스','15','image/15.png','image/챌린저스.png');
insert into movie values(9,'극장판하이큐!!쓰레기장의결전','ALL','image/ALL.png','image/극장판.png');
insert into movie values(10,'남은 인생 10년',12,'image/12.png','image/남은인생.png');
insert into movie values(11,'앙상블 스타즈!! 드림라이브 8th 투어 - Praesepe#Cancer (도쿄)',12,'image/12.png','image/앙상블.png');
insert into movie values(12,'고스트버스터즈: 오싹한 뉴욕','12','image/12.png','image/고스트.png');
insert into movie values(13,'하이큐!! 끝과 시작',12,'image/12.png','image/하이큐.png');
insert into movie values(14,'슈가│어거스트 디 투어 "디-데이" 더 무비',12,'image/12.png','image/슈가.png');
insert into movie values(15,'콜 미 바이 유어 네임','19','image/19.png','image/콜미.png');
insert into movie values(16,'차이콥스키의 아내',19,'image/19.png','image/차이콥.png');
insert into movie values(17,'파묘','15','image/15.png','image/파묘.png');
insert into movie values(18,'힙노시스: LP 커버의 전설',15,'image/15.png','image/힙노.png');
insert into movie values(19,'로봇 드림','ALL','image/ALL.png','image/로봇.png');
insert into movie values(20,'아이 엠 러브',19,'image/19.png','image/아이엠.png');


-- 전체 검색 
select * from movie;
--select * from movie where name = '';

-- 인기 오름 차순 
select * from movie order by num asc;

-- ㄱㄴㄷ 오름 차순 
select * from movie order by name asc;

delete movie where name like '';

select * from movie where name like '%혹%';
select * from movie;

commit;

