create table snack (
   foodname varchar2(25), 
   price number,           
   amount NUMBER CHECK 
   (amount >= 0) 
   );   
   
   
-- ���̺� Ȯ��
select * from tab;

-- ���̺� ���� Ȯ��
desc snack;
select * from snack where like = '�����޺�';
select amount from snack where foodname ='�����޺�';
-- ������ ����
insert into snack values ('�����޺�',13000 , 5);
insert into snack values('�����޺�',15000,5);
insert into snack values('������Ʈ',7000,5);
insert into snack values('CGV�޺�',10000,5);
insert into snack values('�츮 ��Ű��',61000,5);
insert into snack values('���� �� ��Ű��',34000,5);
insert into snack values('����ġ������M',6000,5);
insert into snack values('������Ͼ�����M',6000,5);
insert into snack values('��������M',6000,5);
insert into snack values('����ġ������L',6500,5);
insert into snack values('������Ͼ�����L',6500,5);
insert into snack values('��������L',6500,5);
insert into snack values('��ũ�����̵�',5500,5);
insert into snack values('���̵�',5500,5);
insert into snack values('�Ƹ޸�ī��ICE',4500,5);
insert into snack values('�Ƹ޸�ī��HOT',4000,5);
insert into snack values('ź������L',3500,5);
insert into snack values('ź������M',3000,5);
insert into snack values('ĥ��ġ���',4900,5);
insert into snack values('�÷����ֵ���',4500,5);
insert into snack values('ĥ��ġ���ֵ���',5000,5);
insert into snack values('����',3500,5);


update snack set amount=30; --���� ���� 
select * from snack;
commit;

SELECT foodname, amount FROM snack;
select amount from snack where foodname = '�÷����ֵ���';
select into pay values;



--drop table snackback purge;



select * from pay;
