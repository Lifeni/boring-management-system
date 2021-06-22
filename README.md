# 一个教务管理系统

来自软件架构课程设计，用 Java 16 + Spring Boot + MyBatis + Shiro 实现。

前端的代码在 [boring-management-system-web](https://github.com/Lifeni/boring-management-system-web) ，用 SvelteKit 写的。

## 开发

项目用的是 IntelliJ IDEA，打开之后，应该会有名为 `Start App` 的运行配置，点击即可运行。

项目采用前后端分离的方式，用 [Caddy](https://caddyserver.com/) 反向代理，因此没有处理跨域问题。前端的端口是 5000，反向代理到 localhost:3030；后端的端口是 8080，反向代理到
localhost:3030/api 。

```shell
# 启动 Caddy
caddy start --config=./build/Caddyfile --watch
# 停止 Caddy
caddy adapt --config=./build/Caddyfile
```

数据库用的是 MySQL 5.7，默认的数据库名是 bms，用户为 root，密码为 password 。

```shell
# 用 Docker 启动数据库
docker run --name mysql-5.7 -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d mysql:5.7
```

## 开源协议

MIT License
