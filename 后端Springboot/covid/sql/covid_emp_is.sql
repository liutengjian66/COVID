create table emp_is
(
    id      bigint auto_increment
        primary key,
    name    varchar(20)  null,
    sex     int(3)       null,
    phone   bigint       null,
    temp    float(10, 2) null,
    type    varchar(10)  null,
    place   varchar(100) null,
    begin   datetime     null,
    end     datetime     null,
    leaved  varchar(100) null,
    arrived varchar(100) null,
    content varchar(255) null,
    depart  varchar(20)  null,
    constraint dep
        foreign key (depart) references department (name)
);

INSERT INTO covid.emp_is (id, name, sex, phone, temp, type, place, begin, end, leaved, arrived, content, depart) VALUES (1, '黎香湖', 0, 12341231231, 35, '酒店隔离', '广州市广州南站如家酒店', '2021-04-06 00:00:00', '2021-04-20 00:00:00', '广东汕头', '广东东莞', null, '人力资源部');
INSERT INTO covid.emp_is (id, name, sex, phone, temp, type, place, begin, end, leaved, arrived, content, depart) VALUES (2, '王老二', 1, 13545479653, 38.5, '酒店集中隔离', '广州市火车站快捷酒店', '2021-04-14 00:00:00', '2021-04-28 00:00:00', '广东汕头', '广东东莞', '', '后勤部');
INSERT INTO covid.emp_is (id, name, sex, phone, temp, type, place, begin, end, leaved, arrived, content, depart) VALUES (3, '蔡司', 1, 13452342356, 36.6, '酒店集中隔离', '深圳市宝安区平和小区', '2020-11-23 00:00:00', '2020-12-07 00:00:00', '重庆市', '湖南长沙', '', '研发部');
INSERT INTO covid.emp_is (id, name, sex, phone, temp, type, place, begin, end, leaved, arrived, content, depart) VALUES (5, '蔡司', 1, 13452342356, 35.6, '居家隔离', '深圳市宝安区平和小区', '2021-01-09 00:00:00', '2021-01-23 00:00:00', '重庆市', '湖南长沙', '', '研发部');