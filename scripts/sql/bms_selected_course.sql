create table `selected-course`
(
    courseId  int not null,
    studentId int not null,
    mark      int null comment '成绩'
);

create index courseId
    on `selected-course` (courseId);

create index studentId
    on `selected-course` (studentId);

INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (2, 2018201301, 12);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (1, 2018201301, 95);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (3, 2018201301, null);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (202106, 2018203301, 89);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (6, 2018203301, 720);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (2, 2018203301, null);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (4, 2018203301, null);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (6, 2018201301, 60);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (58, 2020123456, null);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (1, 2020123456, null);
INSERT INTO bms.`selected-course` (courseId, studentId, mark)
VALUES (5, 2018201301, null);