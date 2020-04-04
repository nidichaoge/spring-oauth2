##### 搭建资源服务器
###### 浏览器中直接访问
    http://localhost/user/info?useId=1
###### 可以返回结果

###### 引入spring-cloud-starter-oauth2依赖
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-oauth2</artifactId>
    </dependency>
###### 再次访问就会被重定向到登陆页, 默认的用户名是 user , 密码在控制台打印, 可以使用如下的配置替换用户名和密码
    spring.security.user.name=mouse
    spring.security.user.password=123456
###### 使用账号名和密码登陆后即可返回相同的结果

###### 增加如下注解开启资源服务器
    @EnableResourceServer
###### 此时再次访问会返回如下信息
    {
        "error": "unauthorized",
        "error_description": "Full authentication is required to access this resource"
    }
    
##### 问题汇总
    java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
###### 必须指定一个密码加密模式
    org.springframework.web.client.HttpClientErrorException$Forbidden: 403 : [{"timestamp":"2020-03-24T12:47:33.098+0000","status":403,"error":"Forbidden","message":"Forbidden","path":"/oauth/check_token"}]
###### 默认情况下是关闭的, 需要显式打开
    [org.springframework.web.util.NestedServletException: Handler dispatch failed; nested exception is java.lang.StackOverflowError]