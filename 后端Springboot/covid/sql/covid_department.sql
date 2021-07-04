create table department
(
    id     int         not null
        primary key,
    name   varchar(20) null,
    charge varchar(20) null
);

create index name
    on department (name);

INSERT INTO covid.department (id, name, charge) VALUES (1, '财务部', '王刚');
INSERT INTO covid.department (id, name, charge) VALUES (2, '人力资源部', '李师');
INSERT INTO covid.department (id, name, charge) VALUES (3, '后勤部', '王二霞');
INSERT INTO covid.department (id, name, charge) VALUES (4, '客服部', '刘晓华');
INSERT INTO covid.department (id, name, charge) VALUES (5, '研发部', '李海红');
INSERT INTO covid.department (id, name, charge) VALUES (6, '技术部', '刘苏哈');