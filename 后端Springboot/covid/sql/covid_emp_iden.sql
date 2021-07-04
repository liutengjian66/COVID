create table emp_iden
(
    id       bigint auto_increment
        primary key,
    name     varchar(10)  null,
    sex      int(2)       null,
    idcard   varchar(20)  null,
    idate    date         null,
    place    varchar(100) null,
    phonenum bigint(100)  null,
    register datetime     null,
    status   varchar(10)  null,
    depart   varchar(20)  null,
    constraint emp_iden_ibfk_1
        foreign key (depart) references department (name)
            on update cascade on delete cascade
);

INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (1, '李先生', 1, '440524196002152100', '2020-11-13', '广州市第一附属医院', 13457896457, '2020-11-14 15:31:44', '确诊', '财务部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (2, '蔡二思', 1, '440634199004050312', '2021-03-22', '深圳市福田区第一医院', null, '2021-03-03 11:33:31', '确诊', '财务部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (3, '王金枝', 0, null, '2021-02-01', '深圳市福田区第一医院', null, null, '疑似', '后勤部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (4, '季王红', 0, '440578199505150547', '2021-03-02', '佛山市三水人民医院', 13411234457, null, '治愈', null);
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (5, '李王思', 1, '440578199902150351', '2021-01-07', '佛山市三水人民医院', 13453456785, '2021-04-06 16:05:11', '疑似', '人力资源部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (6, '王二会', 1, '440582198005040800', '2021-02-19', '深圳市中心医院', 13457891231, '2020-04-09 16:22:26', '疑似', '后勤部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (7, '于雪师', 1, '440578198905213551', '2020-12-12', '深圳市中心医院', 1581456785, '2021-04-06 16:05:11', '死亡', '人力资源部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (10, '阿斯顿', 0, null, '2021-04-01', '汕头市李嘉诚医院', 13531342457, '2021-04-02 14:49:15', '治愈', '财务部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (11, '士大夫', 0, '34124', '2021-03-31', '广州市暨南大学第一附属医院', 13411213257, '2021-04-02 14:49:32', '死亡', '客服部');
INSERT INTO covid.emp_iden (id, name, sex, idcard, idate, place, phonenum, register, status, depart) VALUES (12, '吴开师', 1, '440578199807050321', '2021-03-18', '佛山市三水人民医院', 13412823457, '2021-04-06 16:05:11', '疑似', '人力资源部');