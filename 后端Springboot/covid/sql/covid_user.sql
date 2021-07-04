create table user
(
    id       int auto_increment
        primary key,
    username varchar(20)  null,
    password varchar(255) null,
    depart   varchar(20)  null
);

INSERT INTO covid.user (id, username, password, depart) VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '人力资源部');
INSERT INTO covid.user (id, username, password, depart) VALUES (3, 'root', 'e10adc3949ba59abbe56e057f20f883e', '后勤部');
INSERT INTO covid.user (id, username, password, depart) VALUES (12, '994091246', 'd7d7b53081e1e3ecbd28c30c34b4bcd3', '技术部');