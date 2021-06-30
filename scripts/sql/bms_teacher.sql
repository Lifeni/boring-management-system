create table teacher
(
    userId    bigint auto_increment
        primary key,
    userName  varchar(200) not null,
    sex       varchar(20)  null,
    birthYear date         not null,
    degree    varchar(20)  null comment '学历',
    title     varchar(255) null comment '职称',
    grade     date         null comment '入职时间',
    collegeId int          not null comment '院系'
);

create index collegeId
    on teacher (collegeId);

INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('陈老师', '男', '1980-03-08', '博士', '副教授', '2005-06-09', 2);
INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('Pony', '男', '1971-10-29', '本科', '啥也不是', '2022-04-01', 1);
INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('8848', '', '2021-06-27', '', '', null, 0);
INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('赵老师', '男', '1990-12-20', '大专', '大专人', '2021-06-01', 1);
INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('王老师', '男', '1988-06-04', '学士', '讲师', '2016-04-01', 3);
INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('刘老师', '女', '1995-11-12', '硕士', '讲师', '2018-02-01', 1);
INSERT INTO bms.teacher (userName, sex, birthYear, degree, title, grade, collegeId)
VALUES ('李老师', '女', '1999-07-07', '硕士', '讲师', '2021-06-01', 2);