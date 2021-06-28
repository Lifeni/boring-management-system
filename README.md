# 一个教务管理系统

![GitHub](https://img.shields.io/github/license/Lifeni/boring-management-system)

来自软件架构课程设计，用 Java 16 + Spring Boot + MyBatis 实现，数据库用的 MySQL 。

前端的代码在 [boring-management-system-web](https://github.com/Lifeni/boring-management-system-web) ，用 SvelteKit 写的。

## 介绍

这是一个简单的教务管理系统，支持以下功能：

- 登录时自动判断身份，无需选择，所有用户可以自行修改密码

- 管理员对课程、学生信息、教师信息进行增删改查，并且可以重置用户的密码

- 教师可以查看自己教的课程，并给学生打分

- 学生可以查看所有课程来进行选课、退课操作，也可以查看出分的课程成绩

### 截图

// TODO

## 开发

项目用的是 IntelliJ IDEA，打开之后，应该会有名为 `Start App` 的运行配置，点击即可运行。

### 跨域问题与反向代理

项目采用前后端分离的方式，用 [Caddy](https://caddyserver.com/) 反向代理，因此没有处理跨域问题。

前端的端口是 6010，反向代理到 localhost:3030；后端的端口是 8080，反向代理到 localhost:3030/api/ 。

```shell
# 启动 Caddy
caddy start --config=./build/Caddyfile --watch
```

```shell
# 停止 Caddy
caddy adapt --config=./build/Caddyfile
```

### 数据库

数据库用的是 MySQL 5.7，默认的数据库名是 bms，用户为 root，密码为 password 。

```shell
# 用 Docker 启动数据库
docker run --name mysql-5.7 -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d mysql:5.7
```

## 开源协议

MIT License
