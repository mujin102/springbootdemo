package com.dongqtai;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
@RestController
@EnableAutoConfiguration
public class Example {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}

/*
    Example类上使用的第一个注解是 @RestController ，这被称为构造型（stereotype）注解。它为阅读代码的人提供暗示（这是一个支持REST的控制器），
    对于Spring，该类扮演了一个特殊角色。在本示例中，我们的类是一个web @Controller ，所以当web请求进来时，Spring会考虑是否使用它来处理。
    @RequestMapping 注解提供路由信息，它告诉Spring任何来自"/"路径的HTTP请求都应该被映射到 home 方法。
     @RestController 注解告诉Spring以字符串的形式渲染结果，并直接返回给调用者。
    注： @RestController 和 @RequestMapping 是Spring MVC中的注解（它们不是Spring Boot的特定部分）。

    第二个类级别的注解是 @EnableAutoConfiguration ，这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
    由于 spring-boot-starter-web 添加了Tomcat和Spring MVC，所以auto-configuration将假定你正在开发一个web应用，
    并对Spring进行相应地设置。
    Starters和Auto-Configuration：Auto-configuration设计成可以跟"Starters"一起很好的使用，但这两个概念没有直接的联系。
    你可以自由地挑选starters以外的jar依赖，Spring Boot仍会尽最大努力去自动配置你的应用。

    应用程序的最后部分是main方法，这是一个标准的方法，它遵循Java对于一个应用程序入口点的约定。我们的main方法通过调用 run ，
    将业务委托给了Spring Boot的SpringApplication类。SpringApplication将引导我们的应用，
    启动Spring，相应地启动被自动配置的Tomcat web服务器。我们需要将 Example.class 作为参数传递给 run 方法，
    以此告诉SpringApplication谁是主要的Spring组件，并传递args数组以暴露所有的命令行参数。

    到此，示例应用可以工作了。由于使用了 spring-boot-starter-parent POM，这样我们就有了一个非常有用的run目标来启动程序。
    在项目根目录下输入 mvn spring-boot:run 启动应用：

    如果使用浏览器打开localhost:8080，你应该可以看到如下输出：
        Hello World!
    注：点击 ctrl-c 温柔的关闭应用程序。
 */