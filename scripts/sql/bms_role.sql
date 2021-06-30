create table role
(
    roleId      int          not null
        primary key,
    roleName    varchar(20)  not null,
    permissions varchar(255) null comment '权限'
);

INSERT INTO bms.role (roleId, roleName, permissions)
VALUES (0, '管理员', null);
INSERT INTO bms.role (roleId, roleName, permissions)
VALUES (1, '教师', null);
INSERT INTO bms.role (roleId, roleName, permissions)
VALUES (2, '学生', null);