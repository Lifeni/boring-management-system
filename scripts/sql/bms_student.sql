create table student
(
    userId    bigint auto_increment
        primary key,
    userName  varchar(200) not null,
    sex       varchar(20)  null,
    birthYear date         null comment '出生日期',
    grade     date         null comment '入学时间',
    collegeId int          not null comment '院系Id'
);

create index collegeId
    on student (collegeId);

INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('DDD', '女', '1921-07-01', '2021-07-01', 1);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('小梁', '男', '2001-01-22', '2018-09-01', 1);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('匿名', '女', '2000-02-29', '2018-09-02', 3);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('(*/ω＼*)', '女', '2021-06-27', '2021-06-27', 2);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('😅', '男', '2000-10-10', '2018-09-01', 2);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('小王', '男', '2002-05-26', '2019-09-01', 2);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('小方', '男', '2000-07-07', '2020-09-01', 3);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('小马', '女', '2000-02-02', '2020-02-20', 1);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('Mike', '男', '2000-08-23', '2020-09-01', 3);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('小白', '女', '2000-04-13', '2021-08-31', 3);
INSERT INTO bms.student (userName, sex, birthYear, grade, collegeId)
VALUES ('John', '男', '2003-01-12', '2200-01-12', 1);