--drop table snackback purge;

create table room(
    roomnum number,
    num number,
    room varchar2(100),
    time varchar2(100),
    count number
   );
   
-- ���̺� Ȯ��
select *from tab;


-- ���̺� ���� Ȯ��
desc movie;

-- �Է�
select * from room order by roomnum,num asc;
insert into room values(1,1,'1�� 6��','12:10',96);
insert into room values(1,2,'1�� 6��','14:30',105);
insert into room values(1,3,'1�� 6��','16:50',20);
insert into room values(1,4,'1�� 6��','19:20',45);
insert into room values(1,5,'1�� 6��','21:40',56);
insert into room values(1,6,'1�� 6��','24:00',120);

insert into room values(2,1,'2��[LCK��] 6�� (Laser)','09:40',108);
insert into room values(2,2,'2��[LCK��] 6�� (Laser)','19:50',23);
insert into room values(2,3,'2��[LCK��] 6�� (Laser)','22:55',122);
insert into room values(2,4,'2��[LCK��] 6�� (Laser)','23:30',121);

insert into room values(3,1,'3�� 8��','08:00',166);
insert into room values(3,2,'3�� 8��','10:20',113);
insert into room values(3,3,'3�� 8��','12:40',102);
insert into room values(3,4,'3�� 8��','15:00',92);
insert into room values(3,5,'3�� 8��','17:20',34);
insert into room values(3,6,'3�� 8��','19:40',25);
insert into room values(3,7,'3�� 8��','22:00',44);

SELECT DISTINCT room FROM room;
commit;
-- ���̺� ����
--drop table movie purge;
