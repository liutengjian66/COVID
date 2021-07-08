该项目为疫情防控管理系统，前端使用vue+element+echarts，后端使用springboot+mybatisplus+mysql，前后端分离开发。

clone下来后后端代码只需要修改springboot项目的application.yaml中的spring.datasource.url username password 。即分别改为你电脑本地mysql数据库的url ,用户名和密码。改完后maven依赖肯定要更新啦。

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/covid?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
```

vue项目需要在项目命令行使用npm install命令 下载依赖。
