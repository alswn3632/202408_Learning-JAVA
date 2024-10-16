
Create table student (
st_id int auto_increment,
st_num varchar(20),
st_name varchar(20) not null,
st_birth varchar(20),
st_phone varchar(13),
st_addr varchar(100),
st_regdate datetime default now(),
primary key(st_id));