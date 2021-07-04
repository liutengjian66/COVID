create table material_manage
(
    id         int(20) auto_increment
        primary key,
    name       varchar(255) null,
    count      int          null,
    type       varchar(255) null,
    isImp      int          null,
    charge     varchar(255) null,
    cnum       bigint       null,
    updateTime datetime     null
);

INSERT INTO covid.material_manage (id, name, count, type, isImp, charge, cnum, updateTime) VALUES (113, 'KN94口罩', 150, '个', 1, '孙迪', 13415135777, '2021-03-31 13:54:36');
INSERT INTO covid.material_manage (id, name, count, type, isImp, charge, cnum, updateTime) VALUES (114, 'N95口罩', 220, '个', 1, '孙迪', 13415135777, '2021-04-06 16:14:45');
INSERT INTO covid.material_manage (id, name, count, type, isImp, charge, cnum, updateTime) VALUES (123, '防护服', 30, '个', 1, '王旭', 15148796568, '2021-04-22 14:21:56');
INSERT INTO covid.material_manage (id, name, count, type, isImp, charge, cnum, updateTime) VALUES (125, '酒精消毒棉片', 200, '盒', 1, '李建', 13431357964, '2021-03-31 13:54:06');
INSERT INTO covid.material_manage (id, name, count, type, isImp, charge, cnum, updateTime) VALUES (126, '抽纸纸巾', 20, '箱', 0, '李玉', 13534654675, '2021-04-22 19:29:30');
INSERT INTO covid.material_manage (id, name, count, type, isImp, charge, cnum, updateTime) VALUES (133, '防护眼罩', 30, '个', 1, '杨迪', 123123123123, '2021-04-23 17:00:52');