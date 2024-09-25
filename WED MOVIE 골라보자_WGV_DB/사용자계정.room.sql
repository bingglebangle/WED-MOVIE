--drop table snackback purge;

create table room(
    roomnum number,
    num number,
    room varchar2(100),
    time varchar2(100),
    count number
   );
   
-- 抛捞喉 犬牢
select *from tab;


-- 抛捞喉 备炼 犬牢
desc movie;

-- 涝仿
select * from room order by roomnum,num asc;
insert into room values(1,1,'1包 6摸','12:10',96);
insert into room values(1,2,'1包 6摸','14:30',105);
insert into room values(1,3,'1包 6摸','16:50',20);
insert into room values(1,4,'1包 6摸','19:20',45);
insert into room values(1,5,'1包 6摸','21:40',56);
insert into room values(1,6,'1包 6摸','24:00',120);

insert into room values(2,1,'2包[LCK包] 6摸 (Laser)','09:40',108);
insert into room values(2,2,'2包[LCK包] 6摸 (Laser)','19:50',23);
insert into room values(2,3,'2包[LCK包] 6摸 (Laser)','22:55',122);
insert into room values(2,4,'2包[LCK包] 6摸 (Laser)','23:30',121);

insert into room values(3,1,'3包 8摸','08:00',166);
insert into room values(3,2,'3包 8摸','10:20',113);
insert into room values(3,3,'3包 8摸','12:40',102);
insert into room values(3,4,'3包 8摸','15:00',92);
insert into room values(3,5,'3包 8摸','17:20',34);
insert into room values(3,6,'3包 8摸','19:40',25);
insert into room values(3,7,'3包 8摸','22:00',44);

SELECT DISTINCT room FROM room;
commit;
-- 抛捞喉 昏力
--drop table movie purge;
