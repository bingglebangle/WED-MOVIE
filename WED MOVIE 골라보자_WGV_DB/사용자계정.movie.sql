
-- ���� ���̺� (ī��, �̸�)

-- �̸�, �ֹ� ,id ,password,email ,��ȭ��=null;
--create table name(
--    num number,
--    name varchar2(100),
--    age varchar2(50)
--   );

-- ��ȭ ���̺� + ���� ���� 
create table movie(
    num number,
    name varchar2(100),
    age varchar2(50),
    ageimage  varchar2(100),
    image varchar2(100)
   );
   
-- ���̺� Ȯ��
select * from tab;

-- ���̺� ���� Ȯ��
desc movie;

-- ���̺� ����
drop table movie purge;

-- insert 
insert into movie values(1,'���˵���4','15','image/15.png','image/����.png');
insert into movie values(2,'����Ʈ��','15','image/15.png','image/����Ʈ��.png');
insert into movie values(3,'Ȥ��Ż��-���ο� �ô�','12','image/12.png','image/Ȥ��.png');
insert into movie values(4,'�Ǹ�������ũ��','15','image/15.png','image/�Ǹ�.png');
insert into movie values(5,'��Ǫ�Ҵ�4','ALL','image/ALL.png','image/��Ǫ�Ҵ�4.png');
insert into movie values(6,'��������������-�ź��Ѻ���Ž���','ALL','image/ALL.png','image/��������.png');
insert into movie values(7,'���ϸ���-�������� �̾߱�, ������','ALL','image/ALL.png','image/���ϸ�.png');
insert into movie values(8,'ç������','15','image/15.png','image/ç������.png');
insert into movie values(9,'����������ť!!���������ǰ���','ALL','image/ALL.png','image/������.png');
insert into movie values(10,'���� �λ� 10��',12,'image/12.png','image/�����λ�.png');
insert into movie values(11,'�ӻ�� ��Ÿ��!! �帲���̺� 8th ���� - Praesepe#Cancer (����)',12,'image/12.png','image/�ӻ��.png');
insert into movie values(12,'��Ʈ��������: ������ ����','12','image/12.png','image/��Ʈ.png');
insert into movie values(13,'����ť!! ���� ����',12,'image/12.png','image/����ť.png');
insert into movie values(14,'��������Ž�Ʈ �� ���� "��-����" �� ����',12,'image/12.png','image/����.png');
insert into movie values(15,'�� �� ���� ���� ����','19','image/19.png','image/�ݹ�.png');
insert into movie values(16,'�����߽�Ű�� �Ƴ�',19,'image/19.png','image/������.png');
insert into movie values(17,'�Ĺ�','15','image/15.png','image/�Ĺ�.png');
insert into movie values(18,'����ý�: LP Ŀ���� ����',15,'image/15.png','image/����.png');
insert into movie values(19,'�κ� �帲','ALL','image/ALL.png','image/�κ�.png');
insert into movie values(20,'���� �� ����',19,'image/19.png','image/���̿�.png');


-- ��ü �˻� 
select * from movie;
--select * from movie where name = '';

-- �α� ���� ���� 
select * from movie order by num asc;

-- ������ ���� ���� 
select * from movie order by name asc;

delete movie where name like '';

select * from movie where name like '%Ȥ%';
select * from movie;

commit;

