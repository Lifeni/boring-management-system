create table course
(
    courseId   int          not null
        primary key,
    courseName varchar(200) not null comment '课程名称',
    teacherId  int          not null,
    courseTime varchar(200) null comment '开课时间',
    classRoom  varchar(200) null comment '开课地点',
    courseWeek int(200)     null comment '学时',
    courseType varchar(20)  null comment '课程类型',
    collegeId  int          not null comment '所属院系',
    score      int          not null comment '学分'
);

create index collegeId
    on course (collegeId);

create index teacherId
    on course (teacherId);

INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (1, 'C 语言程序设计', 8001, '周二', '科401', 18, '必修课', 1, 3);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (2, 'Python 爬虫从入门到入狱', 9001, '周四', 'X402', 18, '必修课', 1, 3);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (3, '数据结构', 9002, '周四', '科401', 18, '必修课', 1, 2);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (4, 'Java 程序设计', 9004, '周五', '科401', 18, '必修课', 1, 2);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (5, '英语', 9003, '周四', 'X302', 18, '必修课', 2, 2);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (6, '服装设计', 9001, '周一', '科401', 18, '选修课', 2, 2);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (10, '今日说法', 9003, '', '', 12, '选修课', 3, 2);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (58, '毛概', 8002, '周二、周四', 'N201', 16, '公共课', 3, 6);
INSERT INTO bms.course (courseId, courseName, teacherId, courseTime, classRoom, courseWeek, courseType, collegeId,
                        score)
VALUES (202106, 'Test', 9001, '工作日', '21B 403', 2, '专业选修课', 1, 2);