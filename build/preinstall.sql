DROP TABLE IF EXISTS `college`;

CREATE TABLE `college`
(
    `collegeId`   int(11)      NOT NULL,
    `collegeName` varchar(200) NOT NULL COMMENT '课程名',
    PRIMARY KEY (`collegeId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `college` */

insert into `college`(`collegeId`, `collegeName`)
values (1, '计算机系'),
       (2, '设计系'),
       (3, '财经系');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course`
(
    `courseId`   int(11)      NOT NULL,
    `courseName` varchar(200) NOT NULL COMMENT '课程名称',
    `teacherId`  int(11)      NOT NULL,
    `courseTime` varchar(200) DEFAULT NULL COMMENT '开课时间',
    `classRoom`  varchar(200) DEFAULT NULL COMMENT '开课地点',
    `courseWeek` int(200)     DEFAULT NULL COMMENT '学时',
    `courseType` varchar(20)  DEFAULT NULL COMMENT '课程类型',
    `collegeId`  int(11)      NOT NULL COMMENT '所属院系',
    `score`      int(11)      NOT NULL COMMENT '学分',
    PRIMARY KEY (`courseId`),
    KEY `collegeId` (`collegeId`),
    KEY `teacherId` (`teacherId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `course` */

insert into `course`(`courseId`, `courseName`, `teacherId`, `courseTime`, `classRoom`, `courseWeek`, `courseType`,
                     `collegeId`, `score`)
values (1, 'C语言程序设计', 1001, '周二', '科401', 18, '必修课', 1, 3),
       (2, 'Python爬虫技巧', 1001, '周四', 'X402', 18, '必修课', 1, 3),
       (3, '数据结构', 1001, '周四', '科401', 18, '必修课', 1, 2),
       (4, 'Java程序设计', 1002, '周五', '科401', 18, '必修课', 1, 2),
       (5, '英语', 1002, '周四', 'X302', 18, '必修课', 2, 2),
       (6, '服装设计', 1003, '周一', '科401', 18, '选修课', 2, 2);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role`
(
    `roleId`      int(11)     NOT NULL,
    `roleName`    varchar(20) NOT NULL,
    `permissions` varchar(255) DEFAULT NULL COMMENT '权限',
    PRIMARY KEY (`roleId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `role` */

insert into `role`(`roleId`, `roleName`, `permissions`)
values (0, 'admin', NULL),
       (1, 'teacher', NULL),
       (2, 'student', NULL);

/*Table structure for table `selected-course` */

DROP TABLE IF EXISTS `selected-course`;

CREATE TABLE `selected-course`
(
    `courseId`  int(11) NOT NULL,
    `studentId` int(11) NOT NULL,
    `mark`      int(11) DEFAULT NULL COMMENT '成绩',
    KEY `courseId` (`courseId`),
    KEY `studentId` (`studentId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `selected-course` */

insert into `selected-course`(`courseId`, `studentId`, `mark`)
values (2, 10001, 12),
       (1, 10001, 95),
       (1, 10002, 66),
       (2, 10003, 99),
       (5, 10001, NULL),
       (3, 10001, NULL),
       (1, 10003, NULL),
       (4, 10003, NULL);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student`
(
    `userId`    int(11)      NOT NULL AUTO_INCREMENT,
    `userName`  varchar(200) NOT NULL,
    `sex`       varchar(20) DEFAULT NULL,
    `birthYear` date        DEFAULT NULL COMMENT '出生日期',
    `grade`     date        DEFAULT NULL COMMENT '入学时间',
    `collegeId` int(11)      NOT NULL COMMENT '院系Id',
    PRIMARY KEY (`userId`),
    KEY `collegeId` (`collegeId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10008
  DEFAULT CHARSET = utf8;

/*Data for the table `student` */

insert into `student`(`userId`, `userName`, `sex`, `birthYear`, `grade`, `collegeId`)
values (9999, 'mike1', '男', '1996-09-03', '2019-11-13', 3),
       (10001, '小红', '男', '2020-03-02', '2020-03-02', 1),
       (10002, '小绿', '男', '2020-03-10', '2020-03-10', 1),
       (10003, '小陈', '女', '1996-09-02', '2015-09-02', 2),
       (10005, '小左', '女', '1996-09-02', '2015-09-02', 2),
       (10007, 'MIke', '男', '1996-09-02', '2015-09-02', 2);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher`
(
    `userId`    int(11)      NOT NULL AUTO_INCREMENT,
    `userName`  varchar(200) NOT NULL,
    `sex`       varchar(20)  DEFAULT NULL,
    `birthYear` date         NOT NULL,
    `degree`    varchar(20)  DEFAULT NULL COMMENT '学历',
    `title`     varchar(255) DEFAULT NULL COMMENT '职称',
    `grade`     date         DEFAULT NULL COMMENT '入职时间',
    `collegeId` int(11)      NOT NULL COMMENT '院系',
    PRIMARY KEY (`userId`),
    KEY `collegeId` (`collegeId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1004
  DEFAULT CHARSET = utf8;

/*Data for the table `teacher` */

insert into `teacher`(`userId`, `userName`, `sex`, `birthYear`, `degree`, `title`, `grade`, `collegeId`)
values (1001, '刘老师', '女', '1990-03-08', '硕士', '副教授', '2015-09-02', 2),
       (1002, '张老师', '女', '1996-09-02', '博士', '讲师', '2015-09-02', 1),
       (1003, '软老师', '女', '1996-09-02', '硕士', '助教', '2017-07-07', 1);

/*Table structure for table `user-login` */

DROP TABLE IF EXISTS `user-login`;

CREATE TABLE `user-login`
(
    `userId`   int(11)      NOT NULL AUTO_INCREMENT,
    `userName` varchar(200) NOT NULL,
    `password` varchar(200) NOT NULL,
    `role`     int(11)      NOT NULL DEFAULT '2' COMMENT '角色权限',
    PRIMARY KEY (`userId`),
    KEY `role` (`role`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 23
  DEFAULT CHARSET = utf8;

/*Data for the table `user-login` */

insert into `user-login`(`userId`, `userName`, `password`, `role`)
values (1, 'admin', '123', 0),
       (10, '10003', '123', 2),
       (11, '10005', '123', 2),
       (14, '1001', '123', 1),
       (15, '1002', '123', 1),
       (16, '1003', '123', 1),
       (20, '9999', '123', 2),
       (21, '10001', '123', 2),
       (22, '10002', '123', 2);

