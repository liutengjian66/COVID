create table emp_health
(
    id         int(10) auto_increment
        primary key,
    name       varchar(20)  null,
    sex        int(1)       null,
    phonenum   bigint       null,
    temp       float(4, 1)  null,
    risk       varchar(30)  null,
    health     varchar(30)  null,
    content    varchar(255) null,
    createTime datetime     null,
    depart     varchar(30)  null,
    constraint de
        foreign key (depart) references department (name)
);

INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (2, '刘先生', 1, 15143355464, 36.5, '否', '正常', '', '2021-03-31 14:03:52', '后勤部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (3, '吴雷师', 0, 15151549751, 37, '否', '正常', '无', '2021-03-13 20:16:30', '客服部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (4, '刘腾键', 1, 13415135795, 36.5, '否', '正常', '', '2021-03-13 19:54:40', '客服部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (5, '刘腾键', 1, 13415135795, 36.5, '否', '感冒', '', '2021-03-13 19:54:40', '研发部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (6, '刘胜虎', 1, 123414234123, 39, '否', '低烧', '', '2021-04-05 22:41:39', '技术部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (7, '王继红', 0, 13513534534, 38, '否', '与新冠肺炎有关的其他症状，如流涕，咽痛，肌痛，腹泻等', '', '2021-04-06 13:39:38', '客服部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (8, '刘小姐', 1, 231123123, 23, '是', '呼吸困难', '', '2021-04-06 15:34:42', '后勤部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (9, '111', 1, 111111111, 11, '111', '正常', '11', '2021-04-10 16:03:01', '研发部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (10, '刘渲', 1, 13514124567, 37, '否', '正常', '', '2021-04-15 14:29:15', '后勤部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (11, '王佳', 0, 13512314534, 37.5, '否', '正常', '', '2021-04-15 14:42:55', '人力资源部');
INSERT INTO covid.emp_health (id, name, sex, phonenum, temp, risk, health, content, createTime, depart) VALUES (12, '刘腾键', 1, 13512365456, 36.5, '否', '乏力', '', '2021-04-15 14:46:49', '技术部');