
create table member(
    id varchar2(20),
    password varchar2(20),
    name varchar2(20),
    jumin varchar2(20),
    email varchar2(25),
    primary key(id)
);

-- ���̺� Ȯ��
select * from tab;

-- ���̺� ���� Ȯ��
desc member;

-- ���̺� ����
drop table member purge;

insert into member values ('0502', '2024', '��ȿ��', '9810191111111','12345@naver.com');
insert into member values ('0504', '2024', '��ȿ��', '9810191011111','12345@naver.com');

-- ��ü �˻�
select * from member;

-- �̸��� �ֹι�ȣ �˻� idã��
select * from member where name = '��ȿ��' and jumin = '9810191111111';

-- �̸��˻�
select * from member where name = '��ȿ��';

-- id �˻� password ã��
select * from member where id = '0502';

-- �̸��� �˻�
select * from member where email = '12345@naver.com';

-- �α���
select * from member where id = '0502' and password = '2024';

delete member where id = '2';

commit;