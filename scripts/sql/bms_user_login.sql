create table `user-login`
(
    userId   bigint auto_increment
        primary key,
    userName varchar(200)  not null,
    password varchar(200)  not null,
    role     int default 2 not null comment '角色权限'
);

create index role
    on `user-login` (role);

INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('admin', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 0);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('root', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 0);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2018201301', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('9001', '13b7994fae9387c2e1b598524ba1204ae404d02fa67016ed86c74183ab1aafca', 1);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2019202201', 'bd2a504446a98f7ba7acb635ee50a655d1c7580ca8f4c804f72847077286a3c9', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('9002', 'e609d533127c0ec82085faf4f164a2957f866ece2ac65d7401f2c7285eade435', 1);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2018201828', '1e9575e42bee40172f80f7931c68628f1863f72b5cdf4ab8ebcfa330c59881f2', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('9003', '4023f322ac7a0e30e78e71cc1e686b2aa43c989d9f55d02412144620ec21a7a2', 1);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('9004', '002abd21b8e998d58fc9809cdcdb7d49219680649655ce71907546923f41577d', 1);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('8001', '242d1f9ba9fbda48e877c20dd4de8e9a0074e98add3de4856115ab61863786c5', 1);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('8002', '419487a66d85c8f86b54728fe123f2ae514939c9304e333ff43ab34c763a5e05', 1);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2020202020', '3d0dbaf8a71f79136e4f373553c0dc9fce085a544a83780bff7a267558846340', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2020900502', '5d613857c31711f309a01b216b81170db2cc5789c76ebd545e0e317f8662a0a6', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2222333301', 'c33548fb22389cbeb133d48abea59e630022182cffb6df3bae03f00d17af22cb', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2018203301', '2ae6f8c76f3f85c594d6d49b344e945b37521603d619e1201e139f1c8c66dcf6', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2019000100', '91a1c85f5b048b9e4be57b4a6fee057aa64dc3ff682bad9ca52ee974d2a6c5fd', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2020010293', 'd7eba9cbae8c246674075c8da0f2389350be5d36364791afac9f4226b2ae1fc1', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('2021202101', '1f42af91010607fcc078fefad954cc064116d26a8e10603dba9109aab7a05f88', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('1921202100', '4aa1381c48fd3c3e99a59bd4e2f44cc206acd84c75a78f237e98deabe96d19fb', 2);
INSERT INTO bms.`user-login` (userName, password, role)
VALUES ('8848', 'd7697570462f7562b83e81258de0f1e41832e98072e44c36ec8efec46786e24e', 1);