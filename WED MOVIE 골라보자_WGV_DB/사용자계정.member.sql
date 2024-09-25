
create table member(
    id varchar2(20),
    password varchar2(20),
    name varchar2(20),
    jumin varchar2(20),
    email varchar2(25),
    primary key(id)
);

-- 테이블 확인
select * from tab;

-- 테이블 구조 확인
desc member;

-- 테이블 삭제
drop table member purge;

insert into member values ('0502', '2024', '이효준', '9810191111111','12345@naver.com');
insert into member values ('0504', '2024', '이효준', '9810191011111','12345@naver.com');

-- 전체 검색
select * from member;

-- 이름과 주민번호 검색 id찾기
select * from member where name = '이효준' and jumin = '9810191111111';

-- 이름검색
select * from member where name = '이효준';

-- id 검색 password 찾기
select * from member where id = '0502';

-- 이메일 검색
select * from member where email = '12345@naver.com';

-- 로그인
select * from member where id = '0502' and password = '2024';

delete member where id = '2';

commit;