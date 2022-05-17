create schema BPO;
use BPO;
create table callrecords(id int auto_increment primary key, from_number varchar (20), start_time timestamp, end_time timestamp, duration int);

insert into callrecords(from_number, start_time,end_time,duration)values('9999900000', '2021-01-13 06:00:05', '2021-01-13 06:23:06',1381);  
insert into callrecords(from_number, start_time,end_time,duration)values('6999902010', '2021-01-13 06:12:49', '2021-01-13 06:14:44',115);  
insert into callrecords(from_number, start_time,end_time,duration)values('1999902010', '2021-01-13 06:12:49', '2021-01-13 06:14:44',115); 
insert into callrecords(from_number, start_time,end_time,duration)values('4999902010', '2021-01-13 06:12:49', '2021-01-13 06:14:44',115); 
insert into callrecords(from_number, start_time,end_time,duration)values('4699902010', '2021-01-13 06:12:49', '2021-01-13 06:14:44',115); 
insert into callrecords(from_number, start_time,end_time,duration)values('9991232323', '2021-01-13 07:02:49', '2021-01-13 07:14:44',715);  
insert into callrecords(from_number, start_time,end_time,duration)values('8991232323', '2021-01-13 07:02:49', '2021-01-13 07:14:44',715);  
insert into callrecords(from_number, start_time,end_time,duration)values('7991232323', '2021-01-13 07:02:49', '2021-01-13 07:14:44',715);  
insert into callrecords(from_number, start_time,end_time,duration)values('6991232323', '2021-01-13 07:02:49', '2021-01-13 07:14:44',715);  


show tables;
select * from callrecords;