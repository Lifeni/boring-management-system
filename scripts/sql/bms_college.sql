create table college
(
    collegeId   int          not null
        primary key,
    collegeName varchar(200) not null comment '课程名'
);

INSERT INTO bms.college (collegeId, collegeName)
VALUES (1, '计算机系');
INSERT INTO bms.college (collegeId, collegeName)
VALUES (2, '设计系');
INSERT INTO bms.college (collegeId, collegeName)
VALUES (3, '财经系');