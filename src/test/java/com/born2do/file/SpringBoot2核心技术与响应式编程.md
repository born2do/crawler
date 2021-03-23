# 第一季：SpringBoot2核心技术-基础入门 #

# 学习要求 #

 *  熟悉Spring基础
 *  熟悉Maven使用

  


# 环境要求 #

 *  Java8及以上
 *  Maven 3.3及以上：[https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html\#getting-started-system-requirements][https_docs.spring.io_spring-boot_docs_current_reference_html_getting-started.html_getting-started-system-requirements]

  


  


# 学习资料 #

 *  文档地址： [https://www.yuque.com/atguigu/springboot][https_www.yuque.com_atguigu_springboot]

 *  文档不支持旧版本IE、Edge浏览器，请使用chrome或者firefox

 *  视频地址： [http://www.gulixueyuan.com/][http_www.gulixueyuan.com]    [https://www.bilibili.com/video/BV19K4y1L7MT?p=1][https_www.bilibili.com_video_BV19K4y1L7MT_p_1]
 *  源码地址：[https://gitee.com/leifengyang/springboot2][https_gitee.com_leifengyang_springboot2]

  


  


  


  


  



[https_docs.spring.io_spring-boot_docs_current_reference_html_getting-started.html_getting-started-system-requirements]: https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-system-requirements
[https_www.yuque.com_atguigu_springboot]: https://www.yuque.com/atguigu/springboot
[http_www.gulixueyuan.com]: http://www.gulixueyuan.com/
[https_www.bilibili.com_video_BV19K4y1L7MT_p_1]: https://www.bilibili.com/video/BV19K4y1L7MT?p=1
[https_gitee.com_leifengyang_springboot2]: https://gitee.com/leifengyang/springboot2
# 01、Spring与SpringBoot #

# 1、Spring能做什么 #

## 1.1、Spring的能力 ##

 ![image.png][] 

WhatSpringcando

Microservices

Wedapps

Cloud

Reactive

Frameworksforfast,secure.

Quicklydeliver

Yourcode,anycloud-weve

Spring'sasynchronous,

andresponsiveweb

nonblockingarchitecture

production-gradefeatures

gotyoucovered.connect

meansyoucanggermore

applicationsconnectedto

andscaleyourservices

withindependently

whateveryourplatform.

fromyourcomputing

evolvablemicroservices

anydatastore.

resources

Batch

EventDriven

Serverless

Theultiateflexibility.Scale

lntegratewithyour

Automatedtasks.Offline

upondemandandscaleto

enterprise.Reactto

processingofdataatatime

businessevents.Actonyour

tosuityou.

zerowhenthere'sno

demand.

streamingdatainrealtime

  


## 1.2、Spring的生态 ##

[https://spring.io/projects/spring-boot][https_spring.io_projects_spring-boot]

  


覆盖了：

web开发

数据访问

安全控制

分布式

消息服务

移动开发

批处理

......

## 1.3、Spring5重大升级 ##

### 1.3.1、响应式编程 ###

 ![image.png][image.png 1] 

SpringBoot2

Reactor

OptionalDependency

Servletstack

ReactiveStack

SpringMvcisbuiltontheServletA

SpringWebfluxisanon-blockingweb

andusesasynchronousblocking/o

frameworkbuiltfromthegrounduptotake

architecturewithaone-request-per

advantageofmulti-core,next-generation

threadmodel.

processorsandhandlemassivenumbersof

concurrentconnections

ServletContainers

Netty.Servlet3.1+Contaies

ServletAPl

ReactiveStreamsAdapters

SpringSecurityReactive

SpringSecurity

SpringMvC

SpringWebFlux

SpringDataRepositories

SpringDataReacitiveRepositories

Mongo,Cassandra,Redis,Couchbase,R2DBC

JDBCJPANOSQL

### 1.3.2、内部源码设计 ###

基于Java8的一些新特性，如：接口默认实现。重新设计源码架构。

  


# 2、为什么用SpringBoot #

  


> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
> 
>   
> 
> 
> 能快速创建出生产级别的Spring应用

  


## 2.1、SpringBoot优点 ##

 *  Create stand-alone Spring applications

 *  创建独立Spring应用

 *  Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)

 *  内嵌web服务器

 *  Provide opinionated 'starter' dependencies to simplify your build configuration

 *  自动starter依赖，简化构建配置

 *  Automatically configure Spring and 3rd party libraries whenever possible

 *  自动配置Spring以及第三方功能

 *  Provide production-ready features such as metrics, health checks, and externalized configuration

 *  提供生产级别的监控、健康检查及外部化配置

 *  Absolutely no code generation and no requirement for XML configuration

 *  无代码生成、无需编写XML

  


> SpringBoot是整合Spring技术栈的一站式框架
> 
> SpringBoot是简化Spring技术栈的快速开发脚手架

  


## 2.2、SpringBoot缺点 ##

 *  人称版本帝，迭代快，需要时刻关注变化
 *  封装太深，内部原理复杂，不容易精通

# 3、时代背景 #

## 3.1、微服务 ##

[James Lewis and Martin Fowler (2014)][James Lewis and Martin Fowler _2014]  提出微服务完整概念。[https://martinfowler.com/microservices/][https_martinfowler.com_microservices]

> In short, the **microservice architectural style** is an approach to developing a single application as a **suite of small services**, each **running in its own process** and communicating with **lightweight** mechanisms, often an **HTTP** resource API. These services are **built around business capabilities** and **independently deployable** by fully **automated deployment** machinery. There is a **bare minimum of centralized management** of these services, which may be **written in different programming languages** and use different data storage technologies.\-- [James Lewis and Martin Fowler (2014)][James Lewis and Martin Fowler _2014]

 *  微服务是一种架构风格  
    
 *  一个应用拆分为一组小型服务  
    
 *  每个服务运行在自己的进程内，也就是可独立部署和升级  
    
 *  服务之间使用轻量级HTTP交互  
    
 *  服务围绕业务功能拆分  
    
 *  可以由全自动部署机制独立部署  
    
 *  去中心化，服务自治。服务可以使用不同的语言、不同的存储技术

  


## 3.2、分布式 ##

 ![1599562347965-a617a866-4270-44e9-9c5b-ced552683eda.png_x-oss-process_image_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fresize_2Cw_1028][] 

  


### 分布式的困难 ###

 *  远程调用
 *  服务发现
 *  负载均衡
 *  服务容错
 *  配置管理
 *  服务监控
 *  链路追踪
 *  日志管理
 *  任务调度
 *  ......

  


### 分布式的解决 ###

 *  SpringBoot + SpringCloud

  


 ![1599799119457-841ef47a-6585-4ca4-8e3d-8298e796012c.png_x-oss-process_image_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_10_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_10_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10][] 

  


## 3.3、云原生 ##

原生应用如何上云。 Cloud Native

### 上云的困难 ###

 *  服务自愈
 *  弹性伸缩
 *  服务隔离
 *  自动化部署
 *  灰度发布
 *  流量治理
 *  ......

### 上云的解决 ###

 ![1599563498261-8b0b4d86-bd9b-49a3-aefc-89696a375dcb.png_x-oss-process_image_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10][] 

  


# 4、如何学习SpringBoot #

## 4.1、官网文档架构 ##

 ![image.png][image.png 2] 

SpringBootReferenceDocumentation

Phipwewb:Dwsyruhog

Stb3tienDdlaeMmM

Therererencedocumentationconsistsofthefollowingsections

Legalinformation.

Legal

DocumentationOverview

AbouttheDocumentationGetingHelpFrststepsandmore

MATYSBOSR

GettingStarted

入门

AALDSJHEmSSTUUIBYURO.HUIPBSHDPNEODOM

UsingSpringBoot

进价

ProfilesLoingsecurity.cingpingrtii

SpringBootFeatures

高送特仨

MonitoringMetricsAudiigadmore

SpringBootActuator

DeployingSpringBootappllcatlons

DeployingtotheCloud,nstallingasaunixapplication

SprlngBootcLi

installingthecLlusingthecLiconfguingh

BuilDToOLPlugins

MavenPlugin.GradlePlugin,Antlib.andmorc

"How-to'Guides

ApplLcaLonDevelopmenconurdd

小技巧

  


 ![image.png][image.png 3] 

Thereferencedocumentationhasthefollowingappendices:

commonapplitationproperiesthatcanbusdcongureupiaio

ApplicationProperties

所有配置低览Comn

Metadatausedtodescribeconfigurationproperties

ConfigurationMetadata

Auto-configurationClasses

所有自动配置Auto-configurationclassesprovidedbyspringBoot.

TestAuto-configurationAnnotations

Testautoconfigurationannotationsusedtotestsicesoyourapplication

常见测试汪解

ExecutableJars

SpringBootsexecutablejars,heiluchesherfrmat

可执行jar

DependencyVersions

所有场景体版本ealsofthedependenciesthataremanagedbyspringBoot

  


  


  


查看版本新特性；

[https://github.com/spring-projects/spring-boot/wiki\#release-notes][https_github.com_spring-projects_spring-boot_wiki_release-notes]

 ![image.png][image.png 4] 

SpringBoot

2.3.4.RELEASE

SAMPLES

LEARN

OVERVIEW

SpingBootmakesiteasytocy

justrun"

weakeangpmoniecvwrthepPaomy

minimumfus.MostSpringBootappicaonedinimingconii

HYOUReLOkingorinoinusnicinudm

utheprojectreleasenotessection

onourwiki.

earlierrelease,checkouthep

  


  


  


  


  


  


  


  


  


  



[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602641710418-5123a24a-60df-4e26-8c23-1d93b8d998d9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[https_spring.io_projects_spring-boot]: https://spring.io/projects/spring-boot
[image.png 1]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602642309979-eac6fe50-dc84-49cc-8ab9-e45b13b90121.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[James Lewis and Martin Fowler _2014]: https://martinfowler.com/articles/microservices.html
[https_martinfowler.com_microservices]: https://martinfowler.com/microservices/
[1599562347965-a617a866-4270-44e9-9c5b-ced552683eda.png_x-oss-process_image_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fresize_2Cw_1028]: https://cdn.nlark.com/yuque/0/2020/png/1613913/1599562347965-a617a866-4270-44e9-9c5b-ced552683eda.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[1599799119457-841ef47a-6585-4ca4-8e3d-8298e796012c.png_x-oss-process_image_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_10_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_10_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10]: https://cdn.nlark.com/yuque/0/2020/png/1613913/1599799119457-841ef47a-6585-4ca4-8e3d-8298e796012c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[1599563498261-8b0b4d86-bd9b-49a3-aefc-89696a375dcb.png_x-oss-process_image_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10_2Fwatermark_2Ctype_d3F5LW1pY3JvaGVp_2Csize_14_2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3_2Ccolor_FFFFFF_2Cshadow_50_2Ct_80_2Cg_se_2Cx_10_2Cy_10]: https://cdn.nlark.com/yuque/0/2020/png/1613913/1599563498261-8b0b4d86-bd9b-49a3-aefc-89696a375dcb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 2]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602654700738-b6c50c90-0649-4d62-98d3-57658caf0fdb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 3]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602654837853-48916a4f-cb5a-422c-ba7a-83b027c5bf24.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[https_github.com_spring-projects_spring-boot_wiki_release-notes]: https://github.com/spring-projects/spring-boot/wiki#release-notes
[image.png 4]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602730009896-1b651f2c-133c-4f62-b21c-92a002f09e73.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
# 02、SpringBoot2入门 #

## 1、系统要求 ##

 *  [Java 8][] & 兼容java14 .  
    
 *  Maven 3.3+  
    
 *  idea 2019.1.2  
    

  


### 1.1、maven设置 ###

    <mirrors> <mirror> <id>nexus-aliyun</id> <mirrorOf>central</mirrorOf> <name>Nexus aliyun</name> <url>http://maven.aliyun.com/nexus/content/groups/public</url> </mirror> </mirrors> <profiles> <profile> <id>jdk-1.8</id> <activation> <activeByDefault>true</activeByDefault> <jdk>1.8</jdk> </activation> <properties> <maven.compiler.source>1.8</maven.compiler.source> <maven.compiler.target>1.8</maven.compiler.target> <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion> </properties> </profile> </profiles>

## 2、HelloWorld ##

需求：浏览发送/hello请求，响应 Hello，Spring Boot 2 

### 2.1、创建maven工程 ###

  


### 2.2、引入依赖 ###

    <parent> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-parent</artifactId> <version>2.3.4.RELEASE</version> </parent> <dependencies> <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-web</artifactId> </dependency> </dependencies>

### 2.3、创建主程序 ###

    /** * 主程序类 * @SpringBootApplication：这是一个SpringBoot应用 */ @SpringBootApplication public class MainApplication { public static void main(String[] args) { SpringApplication.run(MainApplication.class,args); } }

### 2.4、编写业务 ###

### 2.5、测试 ###

直接运行main方法

### 2.6、简化配置 ###

application.properties

### 2.7、简化部署 ###

把项目打成jar包，直接在目标服务器执行即可。

  


注意点：

 *  取消掉cmd的快速编辑模式

  


###     ###

  


  


  


  


  


  



[Java 8]: https://www.java.com/
# 03、了解自动配置原理 #

# 1、SpringBoot特点 #

  


## 1.1、依赖管理 ##

 *  父项目做依赖管理

    依赖管理 <parent> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-parent</artifactId> <version>2.3.4.RELEASE</version> </parent> 他的父项目 <parent> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-dependencies</artifactId> <version>2.3.4.RELEASE</version> </parent> 几乎声明了所有开发中常用的依赖的版本号,自动版本仲裁机制

 *  开发导入starter场景启动器

    1、见到很多 spring-boot-starter-* ： *就某种场景 2、只要引入starter，这个场景的所有常规需要的依赖我们都自动引入 3、SpringBoot所有支持的场景 https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-starter 4、见到的 *-spring-boot-starter： 第三方为我们提供的简化开发的场景启动器。 5、所有场景启动器最底层的依赖 <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter</artifactId> <version>2.3.4.RELEASE</version> <scope>compile</scope> </dependency>

 *  无需关注版本号，自动版本仲裁

    1、引入依赖默认都可以不写版本 2、引入非版本仲裁的jar，要写版本号。

 *  可以修改默认版本号

    1、查看spring-boot-dependencies里面规定当前依赖的版本 用的 key。 2、在当前项目里面重写配置 <properties> <mysql.version>5.1.43</mysql.version> </properties>

## 1.2、自动配置 ##

 *  自动配好Tomcat

 *  引入Tomcat依赖。
 *  配置Tomcat

    <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-tomcat</artifactId> <version>2.3.4.RELEASE</version> <scope>compile</scope> </dependency>

 *  自动配好SpringMVC

 *  引入SpringMVC全套组件
 *  自动配好SpringMVC常用组件（功能）

 *  自动配好Web常见功能，如：字符编码问题

 *  SpringBoot帮我们配置好了所有web开发的常见场景

 *  默认的包结构

 *  主程序所在包及其下面的所有子包里面的组件都会被默认扫描进来
 *  无需以前的包扫描配置
 *  想要改变扫描路径，@SpringBootApplication(scanBasePackages=**"com.atguigu"**)

 *  或者@ComponentScan 指定扫描路径

  


 *  各种配置拥有默认值

 *  默认配置最终都是映射到某个类上，如：MultipartProperties
 *  配置文件的值最终会绑定每个类上，这个类会在容器中创建对象

 *  按需加载所有自动配置项

 *  非常多的starter
 *  引入了哪些场景这个场景的自动配置才会开启
 *  SpringBoot所有的自动配置功能都在 spring-boot-autoconfigure 包里面
 *    
    

 *  ......

  


  


  


# 2、容器功能 #

## 2.1、组件添加 ##

### 1、@Configuration ###

 *  基本使用
 *  **Full模式与Lite模式**

 *  示例
 *  最佳实战

 *  配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
 *  配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式

  


### 2、@Bean、@Component、@Controller、@Service、@Repository ###

  


### 3、@ComponentScan、@Import ###

@Import 高级用法： [https://www.bilibili.com/video/BV1gW411W7wy?p=8][https_www.bilibili.com_video_BV1gW411W7wy_p_8]

### 4、@Conditional ###

条件装配：满足Conditional指定的条件，则进行组件注入

 ![image.png][] 

Conditional(org.springframework.context.annotation)

ConditionalOnRepositoryTypeCorg.springffameworkoota

ConditionalonWarDeploymentorgspringframework.boota

ConditionalOnBean(org.springframework.bootautoconfigu

ConditionalOnSingleCandidateorg.ringwko

ConditionalonMissingBeanog.pringwro.aut

ConditionalonPropertyorgpringframework.bootautoconf

ConditionalonMissingclass(ogsringfmeworkootau

ConditionalOnResource(org.spring

gframework.boot.autocon

ConditionalonJava(org.springframework.boot.autoconfigur

ConditionalonwebApplicationog.springramework.oot.au

ConditionalonNotwebApplication(org.springfrmework.o

ConditionalonJndiCorg.springframework.ootutoconfigure

ConditionalOnExpressionCorg.springframework.boot.autoco

ConditionaloncloudPlatfommorg.springframework.boot.au

ConditionalOnEnabledResourcechainorg.ringframework

ConditionalonClassCorg.springframework.bootautoconfigur

Profile(org.springframework.context.annotation)

## 2.2、原生配置文件引入 ##

### 1、@ImportResource ###

  


## 2.3、配置绑定 ##

如何使用Java读取到properties文件中的内容，并且把它封装到JavaBean中，以供随时使用；

### 1、@ConfigurationProperties ###

### 2、@EnableConfigurationProperties + @ConfigurationProperties ###

  


### 3、@Component + @ConfigurationProperties ###

# 3、自动配置原理入门 #

## 3.1、引导加载自动配置类 ##

### 1、@SpringBootConfiguration ###

@Configuration。代表当前是一个配置类

  


### 2、@ComponentScan ###

指定扫描哪些，Spring注解；

  


### 3、@EnableAutoConfiguration ###

#### 1、@AutoConfigurationPackage ####

自动配置包？指定了默认的包规则

#### 2、@Import(AutoConfigurationImportSelector.class) ####

##      ![image.png][image.png 1]   confIgurationsLinkeList@361  size二127  0"o13pngramwokbootauoumcm  1E"ogspringframework.bootautoconfuruocniu  2-  org.springframewrk.ootuoniuiucniu  3-"  "org.springframework.boot.autoconfigure.ath.auocouri  "org.springframework.oot.autoconiguchcchuocou  三5  "orgspringframework.bootautoconuuu      ##

## 3.2、按需开启自动配置项 ##

  


## 3.3、修改默认配置 ##

  


##     ##

SpringBoot默认会在底层配好所有的组件。但是如果用户自己配置了以用户的优先

##     ##

总结：

 *  SpringBoot先加载所有的自动配置类  xxxxxAutoConfiguration
 *  每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值。xxxxProperties里面拿。xxxProperties和配置文件进行了绑定
 *  生效的配置类就会给容器中装配很多组件
 *  只要容器中有这些组件，相当于这些功能就有了
 *  定制化配置

 *  用户直接自己@Bean替换底层的组件
 *  用户去看这个组件是获取的配置文件什么值就去修改。

**xxxxxAutoConfiguration ---> 组件  --->** **xxxxProperties里面拿值  ----> application.properties**

  


  


  


  


## 3.4、最佳实践 ##

 *  引入场景依赖

 *  [https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html\#using-boot-starter][https_docs.spring.io_spring-boot_docs_current_reference_html_using-spring-boot.html_using-boot-starter]

 *  查看自动配置了哪些（选做）

 *  自己分析，引入场景对应的自动配置一般都生效了
 *  配置文件中debug=true开启自动配置报告。Negative（不生效）\\Positive（生效）

 *  是否需要修改

 *  参照文档修改配置项

 *  [https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html\#common-application-properties][https_docs.spring.io_spring-boot_docs_current_reference_html_appendix-application-properties.html_common-application-properties]
 *  自己分析。xxxxProperties绑定了配置文件的哪些。

 *  自定义加入或者替换组件

 *  @Bean、@Component。。。

 *  自定义器  **XXXXXCustomizer**；
 *  ......

  


  


  


  


# 4、开发小技巧 #

## 4.1、Lombok ##

简化JavaBean开发

## 4.2、dev-tools ##

  


项目或者页面修改以后：Ctrl+F9；

  


  


  


## 4.3、Spring Initailizr（项目初始化向导） ##

  


### 0、选择我们需要的开发场景 ###

 ![image.png][image.png 2] 

NewProject

版本选择

SElectedDependencies

2.3.4

Dependencles

SpringBoot

Web

DeveloperTools

SpringWeb

SpringWeb

Wob

SpringReactNeWeB

TemplateEngines

RESIREPOSitories

Security

SpringSession

SQL

REstReposiloresHALExPlorer

NoSOL

REstRepositonesHALBrowser

Messaging

场景选择

SpringHATEOAS

SpringWebServices

场景分类

Ops

Joisoy

observability

Vaadin

Testing

SpringCloud

SpringCloudSecurity

SpringCloudTools

SpringCloudConfig

SpringWeb

BuldweBicludingRESTulaplicationsusinging

SpringCloudDiscovery

MVC.UsesApacheTomcatasthedefaultembedded

SpringCloudRouting

container

SpringCloudCircuilBroako

BuikdingaRESTfULWebService

SpringCloudTracing

ServingWebContentwithSpringMVC

BuikdingRESTserviceswithSpring

SpringCloudMessaging

  


  


### 1、自动依赖引入 ###

 ![image.png][image.png 3] 

<parent>

groupidsorg.springframework.boot/groupd

artifactidspring-boot-starter-parent/artifact

<version>2.3.4.RELEASE/version>

<relativePath/k-Lookupparentfromrepository-->

</parent>

<groupid>com.atguigu.boot/groupId

artifactidboot-o1-heowo2iact

<version>0.0.1-SNAPSHOT/version

<name>boot-o1-heiloworld-2/name

descriptionDemoprojectforSpringBoot/description

<properties>

<java.version>1.8/java.vrsion

</properties>

<dependencies>

<dependency>

<groupid>org.springframework.boot/groupid

<artifactdsspring-boot-starter-data-redissartifact

</dependency>

<dependency>

groupidorg.springframework.boot/group

artifactdspring-boot-start-we/rtifact

</dependency>

  


  


### 2、自动创建项目结构 ###

 ![image.png][image.png 4] 

boot-01-helloworld-2C:UsesfyDesktopboo-

idea

SrC

main

java

resources

static

静态资源

templates

页面

application.properties

配置文件

test

boot-01-helloworld-2.iml

mpom.xml

  


  


### 3、自动编写好主配置类 ###

 ![image.png][image.png 5] 

import

@SpringBootapplication

ciass

BootoiHeiloworld2Application

public

publicstaticvoidmain(stringargs)

SpringApplicationun(ootwlicatin


[https_www.bilibili.com_video_BV1gW411W7wy_p_8]: https://www.bilibili.com/video/BV1gW411W7wy?p=8
[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602835786727-28b6f936-62f5-4fd6-a6c5-ae690bd1e31d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 1]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602845382065-5c41abf5-ee10-4c93-89e4-2a9b831c3ceb.png
[https_docs.spring.io_spring-boot_docs_current_reference_html_using-spring-boot.html_using-boot-starter]: https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-starter
[https_docs.spring.io_spring-boot_docs_current_reference_html_appendix-application-properties.html_common-application-properties]: https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#common-application-properties
[image.png 2]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602922147241-73fb2496-e795-4b5a-b909-a18c6011a028.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 3]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602921777330-8fc5c198-75da-4ff9-b82c-71ee3fe18af8.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 4]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602921758313-5099fe18-4c7b-4417-bf6f-2f40b9028296.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 5]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1602922039074-79e98aad-8158-4113-a7e7-305b57b0a6bf.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
# 第一季：SpringBoot2核心技术-核心功能 #

原理解析

配置文件

指标监控

web开发

单元测试

数据访问

核心功能

核心功能

配置文件

web开发

数据访问

单元测试

指标监控

原理解析

 100% 

![original][]

  

  



[original]: https://gw.alipayobjects.com/mdn/prod_resource/afts/img/A*vl1iS57KtIoAAAAAAAAAAABjAQAAAQ/original
# 04、配置文件 #

# 1、文件类型 #

## 1.1、properties ##

同以前的properties用法

## 1.2、yaml ##

### 1.2.1、简介 ###

YAML 是 "YAML Ain't Markup Language"（YAML 不是一种标记语言）的递归缩写。在开发的这种语言时，YAML 的意思其实是："Yet Another Markup Language"（仍是一种标记语言）。 

  


非常适合用来做以数据为中心的配置文件

  


### 1.2.2、基本语法 ###

 *  key: value；kv之间有空格
 *  大小写敏感
 *  使用缩进表示层级关系
 *  缩进不允许使用tab，只允许空格
 *  缩进的空格数不重要，只要相同层级的元素左对齐即可
 *  '\#'表示注释
 *  字符串无需加引号，如果要加，''与""表示字符串内容 会被 转义/不转义

  


### 1.2.3、数据类型 ###

  


 *  字面量：单个的、不可再分的值。date、boolean、string、number、null

    k: v

 *  对象：键值对的集合。map、hash、set、object 

    行内写法： k: {k1:v1,k2:v2,k3:v3} #或 k: k1: v1 k2: v2 k3: v3

 *  数组：一组按次序排列的值。array、list、queue

    行内写法： k: [v1,v2,v3] #或者 k: - v1 - v2 - v3

### 1.2.4、示例 ###

    @Data public class Person { private String userName; private Boolean boss; private Date birth; private Integer age; private Pet pet; private String[] interests; private List<String> animal; private Map<String, Object> score; private Set<Double> salarys; private Map<String, List<Pet>> allPets; } @Data public class Pet { private String name; private Double weight; }

  


  


# 2、配置提示 #

自定义的类和配置文件绑定一般没有提示。

  


  


  


  


  


  


  


  


  

# 05、Web开发 #

#     #

定制化原理

SpringMVC自动配置概览

嵌入式Web容器

简单功能分析

原生Servlet组件

请求参数处理

异常处理

数据响应与内容协商

拦截器

视图解析与模板引擎

深入Web原理

深入Web原理

SpringMVC自动配置概览

简单功能分析

请求参数处理

数据响应与内容协商

视图解析与模板引擎

拦截器

异常处理

原生Servlet组件

嵌入式Web容器

定制化原理

 90% 

![original][]

  

#     #

# 1、SpringMVC自动配置概览 #

Spring Boot provides auto-configuration for Spring MVC that **works well with most applications.(大多场景我们都无需自定义配置)**

The auto-configuration adds the following features on top of Spring’s defaults:

 *  Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.

 *  内容协商视图解析器和BeanName视图解析器

 *  Support for serving static resources, including support for WebJars (covered [later in this document][])).

 *  静态资源（包括webjars）

 *  Automatic registration of `Converter`, `GenericConverter`, and `Formatter` beans.

 *  自动注册 `Converter，GenericConverter，Formatter`

 *  Support for `HttpMessageConverters` (covered [later in this document][later in this document 1]).

 *  支持 `HttpMessageConverters` （后来我们配合内容协商理解原理）

 *  Automatic registration of `MessageCodesResolver` (covered [later in this document][later in this document 2]).

 *  自动注册 `MessageCodesResolver` （国际化用）

 *  Static `index.html` support.

 *  静态index.html 页支持

 *  Custom `Favicon` support (covered [later in this document][later in this document 3]).

 *  自定义 `Favicon`  

 *  Automatic use of a `ConfigurableWebBindingInitializer` bean (covered [later in this document][later in this document 4]).

 *  自动使用 `ConfigurableWebBindingInitializer` ，（DataBinder负责将请求数据绑定到JavaBean上）

> If you want to keep those Spring Boot MVC customizations and make more [MVC customizations][] (interceptors, formatters, view controllers, and other features), you can add your own `@Configuration` class of type `WebMvcConfigurer` but **without** `@EnableWebMvc`.
> 
> **不用@EnableWebMvc注解。使用** **`@Configuration`** **+** **`WebMvcConfigurer`** **自定义规则**

  


> If you want to provide custom instances of `RequestMappingHandlerMapping`, `RequestMappingHandlerAdapter`, or `ExceptionHandlerExceptionResolver`, and still keep the Spring Boot MVC customizations, you can declare a bean of type `WebMvcRegistrations` and use it to provide custom instances of those components.
> 
> **声明** **`WebMvcRegistrations`** **改变默认底层组件**

  


> If you want to take complete control of Spring MVC, you can add your own `@Configuration` annotated with `@EnableWebMvc`, or alternatively add your own `@Configuration`\-annotated `DelegatingWebMvcConfiguration` as described in the Javadoc of `@EnableWebMvc`.
> 
> **使用** **`@EnableWebMvc+@Configuration+DelegatingWebMvcConfiguration 全面接管SpringMVC`**

  


  


# 2、简单功能分析 #

## 2.1、静态资源访问 ##

### 1、静态资源目录 ###

只要静态资源放在类路径下： called `/static` (or `/public` or `/resources` or `/META-INF/resources`

访问 ： 当前项目根路径/ + 静态资源名

  


原理： 静态映射/\*\*。

请求进来，先去找Controller看能不能处理。不能处理的所有请求又都交给静态资源处理器。静态资源也找不到则响应404页面

  


改变默认的静态资源路径

  


### 2、静态资源访问前缀 ###

默认无前缀

当前项目 + static-path-pattern + 静态资源名 = 静态资源文件夹下找

  


  


### 3、webjar ###

自动映射 /[webjars][]/\*\*

[https://www.webjars.org/][https_www.webjars.org]

访问地址：[http://localhost:8080/webjars/**jquery/3.5.1/jquery.js**][webjars]   后面地址要按照依赖里面的包路径

  


## 2.2、欢迎页支持 ##

 *  静态资源路径下  index.html

 *  可以配置静态资源路径
 *  但是不可以配置静态资源的访问前缀。否则导致 index.html不能被默认访问

 *  controller能处理/index

  


  


  


  


## 2.3、自定义 `Favicon` ##

favicon.ico 放在静态资源目录下即可。

  


  


## 2.4、静态资源配置原理 ##

 *  SpringBoot启动默认加载  xxxAutoConfiguration 类（自动配置类）
 *  SpringMVC功能的自动配置类 WebMvcAutoConfiguration，生效

 *  给容器中配了什么。

 *  配置文件的相关属性和xxx进行了绑定。WebMvcProperties==**spring.mvc**、ResourceProperties==**spring.resources**

  


  


  


  


  


#### 1、配置类只有一个有参构造器 ####

  


  


#### 2、资源处理的默认规则 ####

  


#### 3、欢迎页的处理规则 ####

#### 4、favicon ####

# 3、请求参数处理 #

## 0、请求映射 ##

### 1、rest使用与原理 ###

 *  @xxxMapping；
 *  Rest风格支持（*使用**HTTP**请求方式动词来表示对资源的操作*）

 *  *以前：**/getUser  * *获取用户* *    /deleteUser* *删除用户* *   /editUser  **修改用户* *      /saveUser* *保存用户*
 *  *现在： /user    **GET-**获取用户    **DELETE-**删除用户    * *PUT-**修改用户      **POST-**保存用户*
 *  核心Filter；HiddenHttpMethodFilter

 *  用法： 表单method=post，隐藏域 \_method=put
 *  SpringBoot中手动开启

 *  扩展：如何把\_method 这个名字换成我们自己喜欢的。

Rest原理（表单提交要使用REST的时候）

 *  表单提交会带上**\_method=PUT**
 *  **请求过来被**HiddenHttpMethodFilter拦截

 *  请求是否正常，并且是POST

 *  获取到**\_method**的值。
 *  兼容以下请求；**PUT**.**DELETE**.**PATCH**
 *  **原生request（post），包装模式requesWrapper重写了getMethod方法，返回的是传入的值。**
 *  **过滤器链放行的时候用wrapper。以后的方法调用getMethod是调用****requesWrapper的。**

  


**Rest使用客户端工具，**

 *  如PostMan直接发送Put、delete等方式请求，无需Filter。

  


### 2、请求映射原理 ###

 ![image.png][] 

doGet

HIpServletlavaxsenlethtto)do

HttpServletBean(org.springframework.web.servlet)

FrameworkServletorgspringframeworkW

processRequest->doservice

DispatcherServletorg.springframework.web.see)

doService实现

doDispatch(每个请求都会调用)

SpringMVC功能分析都从 org.springframework.web.servlet.DispatcherServlet-》doDispatch（）

  


 ![image.png][image.png 1] 

Mappings-ArrayList@5614size-5

oothis.handlerMa

ORequestMappingHandlerMapping@5678

1-WWelcomePageHandlerMapping@5679

2BeanNameUrlHandlerMapping@56801

3-RouterFunctionMapping@56811

4-SimpleUrHandlerMapping@5682

**RequestMappingHandlerMapping**：保存了所有@RequestMapping 和handler的映射规则。

 ![image.png][image.png 2] 

oOWppingRequslMappingHandlrapping@5678

useSuffixPattemiatch三false

useReqistcredsuftixPartemiatch-to5c

东人人入

UsoTaLingSlashMatchLuo

pathPrefixesinkdHashMapo5707)size-o

CONTANINAGOLIIIONMANNgER(CONTENTNEgOtIATIONMANAgER@708)

CmboddodValcResoNmdddVaLuRoNr5709

WNfg-RequostMappinghfosoulderconfquralion@5710)

DATEctHandlerlathodslnAncestorContexis-fulse

NAmINSIyIRAqUINAPPIHHAdN

MAPoRCosyACiq12

pregisliyeashMap@5740Vsizg-7

mappingLonkupinkedHashMap@574115iz7

HANDLERHETHODQ5757)

comotguigubootcontrollerHelloControllerhelor

ibugjpg

RequesiMappinginfog5756)

tandlencthodo5/59)

RequcstMappinglnto@57581

GETFusor

com.aquq.nHlocontroloqtUscr

Handlenkethod@5761

POSTYusery-

RequesuMappinglmnfo@5760)"

COMALguIgU.BooLcoHCo

nndaHathodu53mguubaaloHon

PUTAuerP

RaqUESIMAPPINGLNfQQ57621

HANDEMMETHODAoMUHCondelee

IDELETEAEOGU

IRequestMoppinginfog5764)

LRSICERCOntllEOrLORoquosly

RorHndooLouw

RoquostMappinginto@57661

@心位tm.5i@wquomodomo

你quesinappinglnfo@57683"

urllookupLinkediultValueMapo5742)s

所有的请求映射都在HandlerMapping中。

  


 *  SpringBoot自动配置欢迎页的 WelcomePageHandlerMapping 。访问 /能访问到index.html；
 *  SpringBoot自动配置了默认 的 RequestMappingHandlerMapping
 *  请求进来，挨个尝试所有的HandlerMapping看是否有请求信息。

 *  如果有就找到这个请求对应的handler
 *  如果没有就是下一个 HandlerMapping

 *  我们需要一些自定义的映射处理，我们也可以自己给容器中放**HandlerMapping**。自定义 **HandlerMapping**

  


## 1、普通参数与基本注解 ##

### 1.1、注解： ###

@PathVariable、@RequestHeader、@ModelAttribute、@RequestParam、@MatrixVariable、@CookieValue、@RequestBody

### 1.2、Servlet API： ###

WebRequest、ServletRequest、MultipartRequest、 HttpSession、javax.servlet.http.PushBuilder、Principal、InputStream、Reader、HttpMethod、Locale、TimeZone、ZoneId

  


**ServletRequestMethodArgumentResolver  以上的部分参数**

  


### 1.3、复杂参数： ###

**Map**、**Model（map、model里面的数据会被放在request的请求域  request.setAttribute）、**Errors/BindingResult、**RedirectAttributes（ 重定向携带数据）**、**ServletResponse（response）**、SessionStatus、UriComponentsBuilder、ServletUriComponentsBuilder

**Map、Model类型的参数**，会返回 mavContainer.getModel（）；---> BindingAwareModelMap 是Model 也是Map

**mavContainer**.getModel(); 获取到值的

 ![image.png][image.png 3] 

publicclassModeiAndviewContainer

booleanignoreDefaultModenRedirectfaise

private

@Nuilable

privateobjectview;

finaIModMapdefautModwdngwMM

private

###      ![image.png][image.png 4]   ooargs-fobject\[41@57151  Notshowingnullelements  Map  0-BindingAwareModelMap@58455size-  Map  1-BindingAwareModelMap@58457size-0  Mode1      ###

###      ![image.png][image.png 5]   LModEIAnwContALR5689MDIAnVWConAINERRequesthandeddiLY  oomavContainer  ignoreDefaultModelOnRedirectatrue  viewenul  BindingAwareModelMap@5845  defaultModel  size32  world666'  hello  "hello666'  redirectModelenull  redirectModelscenariofalse  status二null  noBindingHashSe@145'size0  bindingDisabledHaeize  sessionStatusSimplesessionStatus@6147  requestHandledetrue      ###

### 1.4、自定义对象参数： ###

可以自动类型转换与格式化，可以级联封装。

  


## 2、POJO封装过程 ##

 *  **ServletModelAttributeMethodProcessor**

  


## 3、参数处理原理 ##

 *  HandlerMapping中找到能处理请求的Handler（Controller.method()）
 *  为当前Handler 找一个适配器 HandlerAdapter； **RequestMappingHandlerAdapter**
 *  适配器执行目标方法并确定方法参数的每一个值

  


  


  


### 1、HandlerAdapter ###

 ![image.png][image.png 6] 

oothis.handlerAdapters-ArrayList@61size

O-RequestMappingHandlerAdapter@5828

1-HandlerFunctionAdapter@5829

2-HttpRequestHandlerAdapter@5830

3-SimpleControllerHandlerAdapter@5831

0 - 支持方法上标注@RequestMapping

1 - 支持函数式编程的

xxxxxx

### 2、执行目标方法 ###

### 3、参数解析器-HandlerMethodArgumentResolver ###

确定将要执行的目标方法的每一个参数的值是什么;

SpringMVC目标方法能写多少种参数类型。取决于参数解析器。

 ![image.png][image.png 7] 

thisargumnResolversHandeMethodgumnesolvercomposie@5840)

argumentResolvers-ArrayList@5965size26

0-RequestParamMethodArqumenResolver@5968

1RequestParamMapMethodArgumenResolver@5969

三2-PPathVariableMethodArgumenResolve@5970

3-PPathVariableMapMethodArgun

ArgumentResolver@5971)

4-MatrixVariableMethodArgumenResole@5972

5-MatrixVariableMapMethodrgumentResolver@5973

三6-ServletModelAttributeMethodProcessor@5974

7-RequestResponseBodyMethodProcessor@5975

8RequestPartMethodArgumentResolver@5976

9-RequestHeaderMethodArgumentResolver@5977

10-RequestHeaderMapMethodArgumentResolver@5978

11-SeryletCookievalueMethodArgumentResolver@5979

12-ExpressionValueMethodArgumentResolver@5980

13-SessionAttributeMethodArgumentResolver@5981

14RequestAttributeMethodArgumenResoler@5982

15-SerVletRequestMethodArgumenResol@5983

16-ServletResponseMethodArgumentResoler@5984

17-HttpEntityMethodProcessor@5985

18-RedirectAttributesMethodArgumentResolver@5986

19-ModelMethodProcessor@5987

20-MapMethodProcessor@5988

21ErrorsMethodArgumentResolver@5989

三22-SessionStatusMethodArgumentResolver@5990

23-UricomponentsBuilderMethodArgumentResolver@5991)

24-RequestParamMethodArgumentResolver@5992

25-SeryletModelAttributeMethodProcessor@5993

 ![image.png][image.png 8] 

HandlerMethodArgumentResolver

est,WebD

YSSOMEAGUMMARAMMA

supportsParameter(MethodParamete):boolean

 *  当前解析器是否支持解析这种参数
 *  支持就调用 resolveArgument

  


### 4、返回值处理器 ###

 ![image.png][image.png 9] 

S.retumvalueHandlers-fHandlerMethodRetumvaluHdcomposie@5843)

this.

LogAdaptersifjLocationAwareLog@6007

logger

returnvalueHandlersArrayList@6008size15

ModelAndViewMethodReturnValueHandler@6010

MethodProcessor@60111

MOdel

ViwethodReturnValueHandler@6012

uResponseBody三mitterReturnVlueHandler@6013

1

StreamingResponseBodyReturnValueHandler@6014

三

三5

HttpEntityMethodProcessor@60151

6-HttpHeadersReturnValueHandler@616

7-\[CallableMethodReturnValueHandler@6017

8DeferredResultMethodReturnValueHandler@6018

9AsyncTaskMethodReturnValueHandler@6019

10-ModelAttributeMethodProcessor@6020

11-RequestResponseBodyMethodProcessor@6021)

12二VViewameMethodReturValueHandler@6022

13-MapMethodProcessor@60231

14-ModelAttributeMethodProcessor@60241

  


### 5、如何确定目标方法每一个参数的值 ###

#### 5.1、挨个判断所有参数解析器那个支持解析这个参数 ####

#### 5.2、解析这个参数的值 ####

#### 5.3、自定义类型参数 封装POJO ####

**ServletModelAttributeMethodProcessor  这个参数处理器支持**

 **是否为简单类型。**

###     ###

**WebDataBinder binder = binderFactory.createBinder(webRequest, attribute, name);**

**WebDataBinder :web数据绑定器，将请求参数的值绑定到指定的JavaBean里面**

**WebDataBinder 利用它里面的 Converters 将请求数据转成指定的数据类型。再次封装到JavaBean中**

  


**GenericConversionService：在设置每一个值的时候，找它里面的所有converter那个可以将这个数据类型（request带来参数的字符串）转换到指定的类型（JavaBean -- Integer）**

**byte -- > file**

  


@FunctionalInterface**public interface** Converter<S, T>

###      ![image.png][image.png 10]   OOBINDEREXLENDEDSEMVLELREqUEsTDATABInDeR@6677  fieLDMarkcrPrefox二""  FieLDDefaultPrefix二"  bindEmptyiultipartFiles-true  targefPPorsong6626)PersontuserNamnuabih  objoctName"person  bindingResultenull  ignoreUnknownFielldsatre  ignorelnvalidFieldsefalse  autoGrowNestedPathseTrue  autoGrowCollectionLimit256  allowedFieldsenul  disallowedFieldsanul  reguiredFields二null  mtmam..wacommteo@.m.ommmmm.mm  CMBEDDEDVALUEROSONRMBODDODVALUEROSONR@0693)  cachodPrintors-(ConcurontHashMap@6694)size-0  cachedParsersEconcurentHashMap@6695)i80  SrsGmomtomatmootdt.otomoooomomw.mtcg.touuamoudom.mdmDaommm.  globalconvertersLinkedHashset@6699)size  converters-LinkedHashiMap@67o0)size124  Gmmaomoroamtbabo.mmmmaora  人人  1mcComAeteomoteaoymomooom  山I  ienencComyerersConearQ0valnum  versionServicesconvertersForPair@608"java.lang  uwmCometedomemte.1ddgsmaRoal  owTCOmEnoPiaLcmm/m2oaa      ###

  


  


 ![image.png][image.png 11] 

杯都都都都都都都都都....m

globalConertersLinkdHash@ize

coriverlersLinkedHashp@1

1mmo01

m

Buwtwmwrsmwodtomtlogdmow.gdhmuroommwmotomwromwmomhiawouii.mo.m

都都都

ewtamwwtahwmatodo.hamobwmmmmommmm

都而mm

种

ihog\*wotomwtmmm.m.mgomiomou.oa

地

u.r

.ao

Lmemawteohwwwlbmmomm

o.char

一都...

om

而

um

都都都

  


  


未来我们可以给WebDataBinder里面放自己的Converter；

**private static final class** StringToNumber<T **extends** Number> **implements** Converter<String, T>

  


自定义 Converter

  


  


### 6、目标方法执行完成 ###

将所有的数据都放在 **ModelAndViewContainer**；包含要去的页面地址View。还包含Model数据。

 ![image.png][image.png 12] 

oomavContainerModelAndviewContain69Mo

ignoreDefaultModelOnRedirecttrue

view"forward:/success

defaultModelBindingAwareModeIMap@5845ize

"hello"

world666'

"world">"hello666"

redirectModel二null

redirectModelScenario二false

status三null

noBindingHashSet@6145size-0

bindingDisabled-HashSe

6size二0

sessionStatus-SimpleSessionStatus@6147

reguestHandled-false

### 7、处理派发结果 ###

**processDispatchResult**(processedRequest, response, mappedHandler, mv, dispatchException);

  


renderMergedOutputModel(mergedModel, getRequestToExpose(request), response);

  


#     #

#     #

  


# 4、数据响应与内容协商 #

 100% 

![original][]

  

  


## 1、响应JSON ##

### 1.1、jackson.jar+@ResponseBody ###

###      ![image.png][image.png 13]   <dependency>  groupid>com.fasterxmi.jackson.core/groupid  <artifactid>jackson-databind/arifact  <version>2.11.2/version  <scope>compile</scope>  </dependency>  <dependency>  groupldcom.fasterxml.jackson.datatypes/groupd  artifactid>jackson-dtatypedk/iac  <version>2.11.2/version>  <scope>compile</scope>  </dependency>  <dependency>  <groupid.com.fasterxml.jackson.datatypes/groupd  <artifactid>jackson-datatype-j31/artifact  <version>2.11.2</version>  <scope>compiles/scope  <Idependency>      ###

  


给前端自动返回json数据；

  


  


#### 1、返回值解析器 ####

 ![image.png][image.png 14] 

thsUMALHAum

loggerLogAdaptesSIfjLocationAwreLog@5832

retumValueHandlers-fArraylist@5833size二15

0-ModelAndViewMethodReturValueHandler@5835

1-ModelMethodProcessor@5836

三2-MiewMethodReturnValueHandler@5837

三3-ResponseBodyEmitterReturnValueHandler@5838

StreamingResponseBodyReturValueHandler@5839

三5-HttpEntityMethodProcessor@5840

6-HttpHeadersRetumValueHandler@58411

7-CallableMethodReturnValueHandler@5842

8DeferreDResultMethodReturnValueHandler@5843

9AyncTaskMethodReturValueHandler@5844

10二ModelAttributeMethodProcessor@5845

11-RequestResponseBodyMethodProcessor@58461

12-ViewNameMethodReturnValueHandler@5847

13-MapMethodProcessor@5848

14-ModelAttributeMethodProcessor@5849\]

  


  


  


#### 2、返回值解析器原理 ####

###      ![image.png][image.png 15]   HandlerMethodRetumValueHandler  HANdREUMVALLBMM  supportsReturnType(MethodParameter):boolean      ###

  


 *  1、返回值处理器判断是否支持这种类型返回值 supportsReturnType
 *  2、返回值处理器调用 handleReturnValue 进行处理
 *  3、RequestResponseBodyMethodProcessor 可以处理返回值标了@ResponseBody 注解的。

 *  1.  利用 MessageConverters 进行处理 将数据写为json

 *  1、内容协商（浏览器默认会以请求头的方式告诉服务器他能接受什么样的内容类型）
 *  2、服务器最终根据自己自身的能力，决定服务器能生产出什么样内容类型的数据，
 *  3、SpringMVC会挨个遍历所有容器底层的 HttpMessageConverter ，看谁能处理？

 *  1、得到MappingJackson2HttpMessageConverter可以将对象写为json
 *  2、利用MappingJackson2HttpMessageConverter将对象转为json再写出去。

  


  


  


  


  


  


 ![image.png][image.png 16] 

RequestHeaders

heptowhw.htowhm.

Accept-Encoding:gzipdeflate,br

Accept-Language:zh-cN,zh;q-0.9

  


  


### 1.2、SpringMVC到底支持哪些返回值 ###

### 1.3、HTTPMessageConverter原理 ###

  


#### 1、MessageConverter规范 ####

 ![image.png][image.png 17] 

ThhentedmembersCiht+F2)

Lambdascm+

AnonyihousClasses(

HttpMessageConverter

CanReadClassk?>,MediaType

boolean

CanWrite(Class?>,MediaType)

boolean

:ListMediatype>

getSupportedMediaTypesO:Li

readClass<?extendsT>,HttplnputMessage):T

write(T,MediaType,ttpOutputMessage:vo

HttpMessageConverter: 看是否支持将 此 Class类型的对象，转为MediaType类型的数据。

例子：Person对象转为JSON。或者 JSON转为Person

  


#### 2、默认的MessageConverter ####

 ![image.png][image.png 18] 

oothis.messageConverters-Arraylist@57137

size二10

O-ByteArrayHttpMessageConverter@6214

1-StringHttpMessageConverter@6221

2-fStringHttpMessageConverter@6222

3-ResourceHttpMessageConverter@62231

4-ResourceRegionHttpMessageConverter@6224

5-SourceHttpMessageConverter@62251

6-AlIEncompassingFommHttpMessageConverter@6226

7-MappingJackson2HttpMessageConverter@6227

\-MappingJackson2HttpMessageConverter@6228

9-Jaxb2RootElementHttpMessageConverter@6229

0 - 只支持Byte类型的

1 - String

2 - String

3 - Resource

4 - ResourceRegion

5 - DOMSource.**class \\** SAXSource.**class**) \\ StAXSource.**class \\**StreamSource.**class \\**Source.**class**

**6 -** MultiValueMap

7 - **true** 

**8 - true**

**9 - 支持注解方式xml处理的。**

  


最终 MappingJackson2HttpMessageConverter  把对象转为JSON（利用底层的jackson的objectMapper转换的）

 ![image.png][image.png 19] 

OOOUTPUTMESSAGESEMVLEISEIVERHITPRONSE@5971

SEIIetResponseResponseFacaDE@5613

response-Response@6706\]

fommatenull

coyoteResponse-Response@6707)

outputBufferOutputBuffer@6708\]

encodersHashMap@6714size-0

defaultBuffersize二8192

BbHEAByBuffeRQ6715VvaioHBylBuflerpos0im0cap8192

v1921@

.View

0108123

  


## 2、内容协商 ##

根据客户端接收能力不同，返回不同媒体类型的数据。

### 1、引入xml依赖 ###

### 2、postman分别测试返回json和xml ###

只需要改变请求头中Accept字段。Http协议中规定的，告诉服务器本客户端可以接收的数据类型。

 ![image.png][image.png 20] 

GET

http://ocalhost:8080/test/person

uthorization

Settings

Pre-requestScrlpt

Body

Headers

Params

Tests

Postman-Token

<calculatedwhenreguestissent>

Host

<calculatedwhenrequestissent

PostmanRuntime/7.26.5

Jser-Agent

牛

Accept

Accept-Encoding

gzip,deflate,br

keep-alive

Connection

Accept

application/xml

application/json

  


### 3、开启浏览器参数方式内容协商功能 ###

为了方便内容协商，开启基于请求参数的内容协商功能。

发请求： [http://localhost:8080/test/person?format=json][http_localhost_8080_test_person_format_json]

[http://localhost:8080/test/person?format=][http_localhost_8080_test_person_format_json]xml

  


 ![image.png][image.png 21] 

oothisCOntentNegotiationManagerContenNegotiaionMng@771)

ArrayList@58931size-2

strategies

\-PParameterContentNegotiationStrategy@5896

e二"format"

parameterName二

logger-LogAdapterssif4jLocationAwareLog@5899

useRegisteredExtensionsOnlytrue

ignoreUnknownExtensionsfalse

mediaTypes-ConcurrentHashMap@5900ize

"xml>MediaType@5909"application/xml

三"json">IMediaType@5911)"applicationjson"

fileExtensions-ConcurrentHashMap@5901size-2

allFileExtensions-copyonwiteArrayList@5902size

HeaderContentNegotiationStrategy@5897

resolversLinkedHashset@58947size1

确定客户端接收什么样的内容类型；

1、Parameter策略优先确定是要返回json数据（获取请求头中的format的值）

 ![image.png][image.png 22] 

();

getParameterName

eturnreguestgetParameter

2、最终进行内容协商返回给客户端json即可。

### 4、内容协商原理 ###

 *  1、判断当前响应头中是否已经有确定的媒体类型。MediaType
 *  **2、获取客户端（PostMan、浏览器）支持接收的内容类型。（获取客户端Accept请求头字段）【application/xml】**

 *  **contentNegotiationManager 内容协商管理器 默认使用基于请求头的策略**
 *       ![image.png][image.png 23] 
    
    oothis.strategies-Arraylist@62587size
    
    HeaderContentNegotiationStrategy@21
    
       
 *  **HeaderContentNegotiationStrategy  确定客户端可以接收的内容类型** 
 *       ![image.png][image.png 24] 
    
    string
    
    (HttpHeaders.ACCEPT
    
    headervalueArrayrequestgetHeadervalues(
    
    if(headervalueArrayanu11)
    
    \+"Accept"
    
    returnMEDIATYPEALL\_LIST
    
       

 *  3、遍历循环所有当前系统的 **MessageConverter**，看谁支持操作这个对象（Person）
 *  4、找到支持操作Person的converter，把converter支持的媒体类型统计出来。
 *  5、客户端需要【application/xml】。服务端能力【10种、json、xml】
 *          ![image.png][image.png 25] 
    
    ooresult-ArrayList@5994size-10
    
    0-MediaType@6171\]'"applicationjson
    
    1-MediaType@6172"application/+json"
    
    三2-MediaType@61711'application/json"
    
    3-MediaType@617"application/\*+json"
    
    4-MediaType@6231"application/xmlcharset-UTF-8"
    
    5-MediaType@6232"extxml,charset-UTF-8"
    
    6-MediaType@6233"applircation/+xml.charset-UTF-8
    
    7-MediaType@6252"application/xml.charset-UTF-8"
    
    MediaType@6253"extxmlcharset-UTF-8"
    
    8二
    
    9MediaType@6254"application/+xmcharsetT-
    
       
 *  6、进行内容协商的最佳匹配媒体类型
 *  7、用 支持 将对象转为 最佳匹配媒体类型 的converter。调用它进行转化 。

  


  


 ![image.png][image.png 26] 

oothis.messageConverters

ArrayList@5761

11

size

0-ByteArrayHttpMessageConverter@61761

1-StringHttpMessageConverter@5999

2-StringHttpMessageConverter@6000

3-ResourceHttpMessageConverter@6001

4-ResourceRegionHttpMessageConverter@6002

5-SourceHttpMessageConverter@60031

6三AlEncompassingFomHttessaeConvet@6004

7-MappingJackson2HttpMessageConverter@6005

8-fMappingJackson2HttpMessageConverter@6177

9-fMappingJackson2xmlHttpMessageconverter@6178\]

10三MappingJackson2XmlhttpMessageconverter@6179

导入了jackson处理xml的包，xml的converter就会自动进来

  


  


  


### 5、自定义 MessageConverter ###

**实现多协议数据兼容。json、xml、x-guigu**

**0、**@ResponseBody 响应数据出去 调用 **RequestResponseBodyMethodProcessor** 处理

1、Processor 处理方法返回值。通过 **MessageConverter** 处理

2、所有 **MessageConverter** 合起来可以支持各种媒体类型数据的操作（读、写）

3、内容协商找到最终的 **messageConverter**；

  


SpringMVC的什么功能。一个入口给容器中添加一个  WebMvcConfigurer

  


  


 ![image.png][image.png 27] 

oostrategyParameterContentNegotiationStrategy@5893

parameterName"format'

logger-ILogAdapterSif4jLocationAwareLog@5896

UseRegisteredExtensionsOnlytrue

ignoreUnknownExtensions-false

size二2

mediaTypes-ConcurrentHashMap@5897

"xmlMediaType@5905"application/xml

"json"Medialype@5907"application/json"

fileExtensions-ConcurrentHashMap@5898size-2

allFileExtensions-opyonwiteArrayList@5899size2

  


  


  


 ![image.png][image.png 28] 

pothiscontentNegotiatioMngonNegotiaionMn77

strategisArrayList@6231size

0-ParameterContentNegotiationStrategy@6234

parameterName-"format"

logger-LogAdaptejLocationAwareLog@6236

useRegisteredExtensionsOnlyfalse

ignoreUnknownExtensions-false

mediaTypes-ConcurrentHashMap@6237)size3

"xml>MediaType@6246"application/xml

"son">IMediaType@5930"application/json"

"gg">MediaType@6084)"application/x-quigu"

fileExtensions-ConcurentHashMap@6238size

allFileExtensionoyowiteArrayLit@iz

resolvers-LinkedHashset@6232size1

  


  


**有可能我们添加的自定义的功能会覆盖默认很多功能，导致一些默认的功能失效。**

**大家考虑，上述功能除了我们完全自定义外？SpringBoot有没有为我们提供基于配置文件的快速修改媒体类型功能？怎么配置呢？【提示：参照SpringBoot官方文档web开发内容协商章节】**

  


# 5、视图解析与模板引擎 #

视图解析：**SpringBoot默认不支持 JSP，需要引入第三方模板引擎技术实现页面渲染。**

## 1、视图解析 ##

 100% 

![original][]

  

### 1、视图解析原理流程 ###

1、目标方法处理的过程中，所有数据都会被放在 **ModelAndViewContainer 里面。包括数据和视图地址**

**2、方法的参数是一个自定义类型对象（从请求参数中确定的），把他重新放在** **ModelAndViewContainer** 

**3、任何目标方法执行完成以后都会返回 ModelAndView（****数据和视图地址****）。**

**4、****processDispatchResult  处理派发结果（页面改如何响应）**

 *  1、**render**(**mv**, request, response); 进行页面渲染逻辑

 *  1、根据方法的String返回值得到 **View** 对象【定义了页面的渲染逻辑】

 *  1、所有的视图解析器尝试是否能根据当前返回值得到**View**对象
 *  2、得到了  **redirect:/main.html** \--> Thymeleaf new **RedirectView**()
 *  3、ContentNegotiationViewResolver 里面包含了下面所有的视图解析器，内部还是利用下面所有视图解析器得到视图对象。
 *  4、view.render(mv.getModelInternal(), request, response);   视图对象调用自定义的render进行页面渲染工作

 *  **RedirectView 如何渲染【重定向到一个页面】**
 *  **1、获取目标url地址**
 *  **2、****response.sendRedirect(encodedURL);**

  


  


**视图解析：**

 *  **返回值以 forward: 开始： new InternalResourceView(forwardUrl); -->  转发****request.getRequestDispatcher(path).forward(request, response);** 
 *  **返回值以** **redirect: 开始：** **new RedirectView() --》 render就是重定向** 
 *  **返回值是普通字符串： new ThymeleafView（）--->** 

  


  


自定义视图解析器+自定义视图； **大厂学院。**

  


  


  


  


 ![image.png][image.png 29] 

ynamic\_table")

mode1)

size

ynamic\_table(Mode1

model:

\-1

遍历

zha

BindingAwareModelMap@7898size-

users

User(uscrvamc.

IS

password.

 ![image.png][image.png 30] 

lnheritedmembers(Ctrl+F12)

Lambdas(Ctrl+L)

AnonymousClasses(Ctrl+l)

View

getContentTypeO:String

renDERMAPStingut

PATHVARIABLES:StringView.classgeiName+"thale

  


 ![image.png][image.png 31] 

oothis.viewResolvers-ArrayList@5651)size-5

0-ContentNegotiatingViewResolver@70531

1-BeanNameViewResolver@70541

2-(hymeleafViewResolver@70557

3-ViewResolverComposite@7056\]

4二fnternalResourceViewResolver@70571

  


 ![image.png][image.png 32] 

ContentNegotiatingViewResolver@7053

oviewResolver

COntentNegotitioMnNgiioM417

CnmFactoryBean-IContEentNegotiationMangerfactoryBean@7066

uSeNotAcceptableStatuscodefalse

defaultviews二null

viewResolvers-Arraylist@7067\]

size

O-BeanNameViewResolver@7054

1-ChymeleafViewResolver@70551

2-ViewResolverComposite@7556

3值nteralResourceViewResolver@75651

## 2、模板引擎-Thymeleaf ##

### 1、thymeleaf简介 ###

Thymeleaf is a modern server-side Java template engine for both web and standalone environments, capable of processing HTML, XML, JavaScript, CSS and even plain text.

**现代化、服务端Java模板引擎**

  


### 2、基本语法 ###

#### 1、表达式 ####

<table style="width: 814px;">      
 <tbody> 
  <tr> 
   <td><p>表达式名字</p></td> 
   <td><p>语法</p></td> 
   <td><p>用途</p></td> 
  </tr> 
  <tr> 
   <td><p><span>变量取值</span></p></td> 
   <td><p><span>${...} </span></p></td> 
   <td><p>获取请求域、session域、对象等值</p></td> 
  </tr> 
  <tr> 
   <td><p>选择变量</p></td> 
   <td><p><span>*{...}</span></p></td> 
   <td><p>获取上下文对象值</p></td> 
  </tr> 
  <tr> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>消息</p></td> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>#{...}</p></td> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>获取国际化等值</p></td> 
  </tr> 
  <tr> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>链接</p></td> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p><span>@{...}</span></p></td> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>生成链接</p></td> 
  </tr> 
  <tr> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>片段表达式</p></td> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>~{...}</p></td> 
   <td colspan="1" style="vertical-align: top; background-color: #FFFFFF; color: #404040;"><p>jsp:include 作用，引入公共页面片段</p></td> 
  </tr> 
 </tbody> 
</table>

 

  


#### 2、字面量 ####

文本值: **'one text'** **,** **'Another one!'** **,…**数字: **0** **,** **34** **,** **3.0** **,** **12.3** **,…**布尔值: **true** **,** **false**

空值: **null**

变量： one，two，.... 变量不能有空格

#### 3、文本操作 ####

字符串拼接: **+**

变量替换: **|The name is $\{name\}|**

  


#### 4、数学运算 ####

运算符: \+ , \- , \* , / , %

  


#### 5、布尔运算 ####

运算符:  **and** **,** **or**

一元运算: **!** **,** **not**

  


  


#### 6、比较运算 ####

比较: **>** **,** **<** **,** **>=** **,** **<=** **(** **gt** **,** **lt** **,** **ge** **,** **le** **)**等式: **==** **,** **!=** **(** **eq** **,** **ne** **)**

  


#### 7、条件运算 ####

If-then: **(if) ? (then)**

If-then-else: **(if) ? (then) : (else)**

Default: (value) **?: (defaultvalue)**

  


#### 8、特殊操作 ####

无操作： \_

  


  


### 3、设置属性值-th:attr ###

设置单个值

设置多个值

  


以上两个的代替写法 th:xxxx

  


所有h5兼容的标签写法

[https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html\#setting-value-to-specific-attributes][https_www.thymeleaf.org_doc_tutorials_3.0_usingthymeleaf.html_setting-value-to-specific-attributes]

  


### 4、迭代 ###

  


  


### 5、条件运算 ###

  


#     #

### 6、属性优先级 ###

 ![image.png][image.png 33] 

Order

Feature

AttrIbutes

Fragmentinclusion

th:insert

th:replace

Fragmentiteration

th:each

Conditionalevaluation

th:if

th:unless

th:switch

butes

th:case

th:object

Localvariabledefinition

th:with

Generalattributemodification

th:attr

th:attrorepend

th:attrappend

Specificattributemodification

th:value

th:href

th:src

7

Text(tagbodymodification)

th:text

th:utext

8

Fragmentspecification

th:fragment

9

Fragmentremoval

th:remove

#     #

## 3、thymeleaf使用 ##

#### 1、引入Starter ####

#### 2、自动配置好了thymeleaf ####

#     #

自动配好的策略

 *  1、所有thymeleaf的配置值都在 ThymeleafProperties
 *  2、配置好了 **SpringTemplateEngine** 
 *  **3、配好了** **ThymeleafViewResolver** 
 *  4、我们只需要直接开发页面

#### 3、页面开发 ####

## 4、构建后台管理系统 ##

### 1、项目创建 ###

thymeleaf、web-starter、devtools、lombok

  


### 2、静态资源处理 ###

自动配置好，我们只需要把所有静态资源放到 static 文件夹下

### 3、路径构建 ###

th:action="@\{/login\}"

  


### 4、模板抽取 ###

th:insert/replace/include

  


### 5、页面跳转 ###

  


### 6、数据渲染 ###

  


# 6、拦截器 #

## 1、HandlerInterceptor 接口 ##

  


## 2、配置拦截器 ##

  


## 3、拦截器原理 ##

1、根据当前请求，找到**HandlerExecutionChain【**可以处理请求的handler以及handler的所有 拦截器】

2、先来**顺序执行** 所有拦截器的 preHandle方法

 *  1、如果当前拦截器prehandler返回为true。则执行下一个拦截器的preHandle
 *  2、如果当前拦截器返回为false。直接    倒序执行所有已经执行了的拦截器的  afterCompletion；

**3、如果任何一个拦截器返回false。直接跳出不执行目标方法**

**4、所有拦截器都返回True。执行目标方法**

**5、倒序执行所有拦截器的postHandle方法。**

**6、前面的步骤有任何异常都会直接倒序触发** afterCompletion

7、页面成功渲染完成以后，也会倒序触发 afterCompletion

  


 ![image.png][image.png 34] 

T

oomappacHandRHandleExacutionch

HAYANm

bean-flndexController@6459)

beanTypa-ichs@1r8hscomauumcucom

地心

地中

parameters-MMcthodParameter(21@0402)

responseslatus-null

responseStatusReason-null

mA

intertaceParameterAnnotationsanull

doscmLoncomiguM

0ELoqinIntorcoptor@6470.

1gConversionServiceExposinginterceptor@6471)

2+(RosourcourProvidorExposingintorcoptor@6472)

interceptorlhdex三-1

  


 ![image.png][image.png 35] 

preHandle

preHandle

preHandle

目标方法

页面涓染

拦截器3

拦截器2

拦截器1

postHandle

postHandle

postHandle

afterCompletion

afterCompletion

afterCompletion

  


# 7、文件上传 #

## 1、页面表单 ##

  


## 2、文件上传代码 ##

  


## 3、自动配置原理 ##

**文件上传自动配置类-MultipartAutoConfiguration-****MultipartProperties**

 *  自动配置好了 **StandardServletMultipartResolver   【文件上传解析器】**
 *  **原理步骤**

 *  **1、请求进来使用文件上传解析器判断（**isMultipart**）并封装（**resolveMultipart，**返回**MultipartHttpServletRequest**）文件上传请求**
 *  **2、参数解析器来解析请求中的文件内容封装成MultipartFile**
 *  **3、将request中文件信息封装为一个Map；**MultiValueMap<String, MultipartFile>

**FileCopyUtils**。实现文件流的拷贝

 ![image.png][image.png 36] 

8-RequestPartMethodArgumentResolver@7533

logger二LogAdapterSIfjLocationAwareLog@7552

messageConvertersArrayList@7492ize1

AISUPPOTEDMEDIATYPSOLCIONSUMLERANDOMACCeSLISQ753)E

adviceRequestResponseBodyAdviceChain@7554

# 8、异常处理 #

## 1、错误处理 ##

#### 1、默认规则 ####

 *  默认情况下，Spring Boot提供`/error`处理所有错误的映射
 *  对于机器客户端，它将生成JSON响应，其中包含错误，HTTP状态和异常消息的详细信息。对于浏览器客户端，响应一个“ whitelabel”错误视图，以HTML格式呈现相同的数据
 *       ![image.png][image.png 37] 
    
    "timestamp":"2020-11-22T05:53:28.416+00:00"
    
    "status":404,
    
    "error":"NotFound",
    
    ":"Nomessageavailable"
    
    "message":
    
    "path":"/asadada
    
            ![image.png][image.png 38] 
    
    WhitelabelErrorPage
    
    Thisapplicationhasnoexp
    
    gthisasafallback.
    
    explicitmappingfor/errorsoyouareseeing
    
    SunNov2213:56:48CST2020
    
    Therewasanunexpectederror(type-NotFound,staus404)
    
    Nomessageavailable
    
       
 *  **要对其进行自定义，添加****`View`****解析为`error```**
 *  要完全替换默认行为，可以实现 `ErrorController`并注册该类型的Bean定义，或添加`ErrorAttributes类型的组件`以使用现有机制但替换其内容。
 *  error/下的4xx，5xx页面会被自动解析；

 *       ![image.png][image.png 39] 
    
    templates
    
    error
    
    5xx.html
    
    404.html
    
       

#### 2、定制错误处理逻辑 ####

 *  自定义错误页

 *  error/404.html   error/5xx.html；有精确的错误状态码页面就匹配精确，没有就找 4xx.html；如果都没有就触发白页

 *  @ControllerAdvice+@ExceptionHandler处理全局异常；底层是 **ExceptionHandlerExceptionResolver 支持的**
 *  @ResponseStatus+自定义异常 ；底层是 **ResponseStatusExceptionResolver ，把responsestatus注解的信息底层调用** **response.sendError(statusCode, resolvedReason)；tomcat发送的/error**
 *  Spring底层的异常，如 参数类型转换异常；**DefaultHandlerExceptionResolver 处理框架底层的异常。**

 *  response.sendError(HttpServletResponse.**SC\_BAD\_REQUEST**, ex.getMessage());
 *       ![image.png][image.png 40] 
    
    HTTPStatus404-qerw
    
    Bypestatusreport
    
    message/qerw
    
    descriptionTherequestedresourceisnotavaitable
    
    https://blog.csdn.net/qq\_32523587
    
    ApacheTomcat/8.0.32(Ubuntu
    
       

 *  自定义实现 HandlerExceptionResolver 处理异常；可以作为默认的全局异常处理规则

 *       ![image.png][image.png 41] 
    
    oothishandlerExceptionResolersArayList@6349Size3
    
    0-CustomerHandlerExceptionResolver@64311
    
    1-DefaulterrorAttributes@6437
    
    三2-HandlerExceptionResolverComposite@6438
    
       

 *  **ErrorViewResolver**  实现自定义处理异常；

 *  response.sendError 。error请求就会转给controller
 *  你的异常没有任何人能处理。tomcat底层 response.sendError。error请求就会转给controller
 *  **basicErrorController 要去的页面地址是** **ErrorViewResolver**  ；

  


  


#### 3、异常处理自动配置原理 ####

 *  **ErrorMvcAutoConfiguration  自动配置异常处理规则**

 *  **容器中的组件：类型：DefaultErrorAttributes ->** **id：errorAttributes**

 *  **public class** **DefaultErrorAttributes** **implements** **ErrorAttributes**, **HandlerExceptionResolver**
 *  **DefaultErrorAttributes**：定义错误页面中可以包含哪些数据。
 *       ![image.png][image.png 42] 
    
    @override
    
    publicMap<string,object>
    
    Err
    
    getErrorattributes(webRequest
    
    webReguest,
    
    geterrorAttributeswebRequest
    
    Mapstring,objecterrorAttributes
    
    f(BooJeAN.Tqu(thixceo
    
    otionsotionsiig(uT
    
    (loptions.isIncluded(Include.EXCEPTION))
    
    if(!op
    
    errorAttributes.
    
    remove(key:"exception
    
    if
    
    (loptions.isIncluded(Include.STACK\_TRACE))
    
    key:"trace"
    
    errorAttributes
    
    remove(
    
    (loptions.isncluded(IncludeMSS)eorAttrbuteseme
    
    if
    
    put("message"
    
    errorattributes
    
    if(loptions.iIncluded(Include.BDINGEORS)
    
    remove(key:"errors
    
    errorattributes
    
    returnerrorAttributes;
    
    @Override
    
       
 *       ![image.png][image.png 43] 
    
    doverride
    
    @Deprecated
    
    pubiicMap<string,object
    
    getErrorattributes(WebRequestwebReguestboolean
    
    Mapcstring,object
    
    srrorattributesnewlinkedHashMap;
    
    timestamp
    
    newDateO));
    
    errorattributesput
    
    (errorAttributes,webRequest);
    
    DDatabase
    
    addstatus
    
    tdderronpetailsqerrorAttribute,weequek
    
    rorAttributes,webRequest);
    
    addPath(e
    
    orAttributes;
    
    privatevodaddstatusMapstingue
    
    uSEgetAttribute(requestattrbutesqueiheR
    
    Integerstatus
    
    if(statusanu11)f
    
    status"
    
    999);
    
    errorAttributes.put
    
    errorattributes.put"error","None);
    
    return;
    
    errorAttributes.putteror"Httpstatusuu
    
       

 *  **容器中的组件：类型：****BasicErrorController --> id：basicErrorController（json+白页 适配响应）**

 *  **处理默认** **/error 路径的请求；页面响应** **new** ModelAndView(**"error"**, model)；
 *  **容器中有组件 View**\->**id是error**；（响应默认错误页）
 *  容器中放组件 **BeanNameViewResolver（视图解析器）；按照返回的视图名作为组件的id去容器中找View对象。**

 *  **容器中的组件：**类型：**DefaultErrorViewResolver -> id：**conventionErrorViewResolver

 *  如果发生错误，会以HTTP的状态码 作为视图页地址（viewName），找到真正的页面
 *  error/404、5xx.html

  


如果想要返回页面；就会找error视图【**StaticView**】。(默认是一个白页)

  


  


 ![image.png][image.png 44] 

@RequestMapping

pubiicResponseEntityMapstring,eueue)

写出去json

 ![image.png][image.png 45] 

@RequestMapping(Produces

MEdiaType.TEXTHTMLVALUE)

errorhtmi(HttpservletReguestregues

pubiicModeiAndview

HttpsservletResponseresponse)

streguesT

httPstacussatu

Coilections

Mapsstring,

,object>

model

MMODIFIABLMAEOAttrbuTeSCeqUeSTEAttbutOptionSqUeSTM

response.setstatus(status.value);

ModeiAndviewmodeiAndview

resolveErrorViewrequest,response,status

mode1)

nu11

modelAndview:newModelAndviewV

ewviewName

return(modelAndvieW

error

 错误页

  


  


#### 4、异常处理步骤流程 ####

1、执行目标方法，目标方法运行期间有任何异常都会被catch、而且标志当前请求结束；并且用 **dispatchException** 

2、进入视图解析流程（页面渲染？）

processDispatchResult(processedRequest, response, mappedHandler, **mv**, **dispatchException**);

3、**mv** = **processHandlerException**；处理handler发生的异常，处理完成返回ModelAndView；

 *  1、遍历所有的 **handlerExceptionResolvers，看谁能处理当前异常【****HandlerExceptionResolver处理器异常解析器****】**
 *       ![image.png][image.png 46] 
    
    In
    
    HandlerExceptionResolver
    
    object
    
    HttpServletReguestHttpSReonse
    
    resolveException(Htt
    
    ModelAndview
    
    Exception
    
       
 *  **2、系统默认的  异常解析器；**
 *       ![image.png][image.png 47] 
    
    oothishandrExceptionesoversArrayLi@4
    
    0-DefaulterrorAttributes@67771
    
    includeException二n
    
    二null
    
    HandlerExceptionResolverComposite@6778
    
    resolvers-ArrayList@67841
    
    size
    
    0-ExceptionHandlerExceptionResolver@6786
    
    1-ResponseStatusExceptionResolver@6787
    
    2-DefaultHandlerExceptionResolver@6788
    
    order-0
    
       

 *  **1、DefaultErrorAttributes先来处理异常。把异常信息保存到rrequest域，并且返回null；**
 *  **2、默认没有任何人能处理异常，所以异常会被抛出**

 *  **1、如果没有任何人能处理最终底层就会发送 /error 请求。会被底层的BasicErrorController处理**
 *  **2、解析错误视图；遍历所有的  ****ErrorViewResolver  看谁能解析。**
 *       ![image.png][image.png 48] 
    
    oothis.errorViewResolvers-ArrayList@7067size
    
    0-DefaulterrorviewResolver@7099
    
       
 *  **3、默认的** **DefaultErrorViewResolver ,作用是把响应状态码作为错误页的地址，error/500.html** 
 *  **4、模板引擎最终响应这个页面** **error/500.html** 

# 9、Web原生组件注入（Servlet、Filter、Listener） #

## 1、使用Servlet API ##

@ServletComponentScan(basePackages = **"com.atguigu.admin"**) :指定原生Servlet组件都放在那里

@WebServlet(urlPatterns = **"/my"**)：效果：直接响应，**没有经过Spring的拦截器？**

@WebFilter(urlPatterns=\{**"/css/\*"**,**"/images/\*"**\})

@WebListener

  


推荐可以这种方式；

  


  


  


扩展：DispatchServlet 如何注册进来

 *  容器中自动配置了  DispatcherServlet  属性绑定到 WebMvcProperties；对应的配置文件配置项是 **spring.mvc。**
 *  **通过** **ServletRegistrationBean**<DispatcherServlet> 把 DispatcherServlet  配置进来。
 *  默认映射的是 / 路径。

 ![image.png][image.png 49] 

DispatcherServlet

Spring流程

MyServlet

Tomcat处理

Imy

Tomcat-Servlet；

多个Servlet都能处理到同一层路径，精确优选原则

A： /my/

B： /my/1

  


  


## 2、使用RegistrationBean ##

`ServletRegistrationBean`, `FilterRegistrationBean`, and `ServletListenerRegistrationBean`

  


# 10、嵌入式Servlet容器 #

## 1、切换嵌入式Servlet容器 ##

 *  默认支持的webServer

 *  `Tomcat`, `Jetty`, or `Undertow`
 *  `ServletWebServerApplicationContext 容器启动寻找ServletWebServerFactory 并引导创建服务器`

 *  切换服务器

 ![image.png][image.png 50] 

Jettywebserver(org.springframework.boot.wemedet

Nettywebserver

org.springframework.bootwembedednt)

anionjs:

(org.springframework.boot.web.embedded.tomcat)

TOmcatWebserver

undertowebseryerorg.springframework.boom

  


  


 *  原理

 *  SpringBoot应用启动发现当前是Web应用。web场景包-导入tomcat
 *  web应用会创建一个web版的ioc容器 `ServletWebServerApplicationContext` 
 *  `ServletWebServerApplicationContext`  启动的时候寻找 **`ServletWebServerFactory`**`（Servlet 的web服务器工厂---> Servlet 的web服务器）`  
 *  SpringBoot底层默认有很多的WebServer工厂；`TomcatServletWebServerFactory`, `JettyServletWebServerFactory`, or `UndertowServletWebServerFactory`
 *  `底层直接会有一个自动配置类。ServletWebServerFactoryAutoConfiguration`
 *  `ServletWebServerFactoryAutoConfiguration导入了ServletWebServerFactoryConfiguration（配置类）`
 *  `ServletWebServerFactoryConfiguration 配置类 根据动态判断系统中到底导入了那个Web服务器的包。（默认是web-starter导入tomcat包），容器中就有 TomcatServletWebServerFactory`
 *  `TomcatServletWebServerFactory 创建出Tomcat服务器并启动；TomcatWebServer 的构造器拥有初始化方法initialize---this.tomcat.start();`
 *  `内嵌服务器，就是手动把启动服务器的代码调用（tomcat核心jar包存在）`

 *  ``

## 2、定制Servlet容器 ##

 *  实现 **WebServerFactoryCu**stomizer<ConfigurableServletWebServerFactory>

 *  把配置文件的值和**`ServletWebServerFactory 进行绑定`**

 *  修改配置文件 **server.xxx**
 *  直接自定义 **ConfigurableServletWebServerFactory** 

  


**xxxxx****Customizer****：定制化器，可以改变xxxx的默认规则**

# 11、定制化原理 #

## 1、定制化的常见方式 ##

 *  修改配置文件；
 *  **xxxxxCustomizer；**
 *  **编写自定义的配置类   xxxConfiguration；+** **@Bean替换、增加容器中默认组件；视图解析器** 
 *  **Web应用 编写一个配置类实现 WebMvcConfigurer 即可定制化web功能；+ @Bean给容器中再扩展一些组件**

 *  @EnableWebMvc + WebMvcConfigurer —— @Bean  可以全面接管SpringMVC，所有规则全部自己重新配置； 实现定制和扩展功能

 *  原理
 *  1、WebMvcAutoConfiguration  默认的SpringMVC的自动配置功能类。静态资源、欢迎页.....
 *  2、一旦使用 @EnableWebMvc 、。会 @Import(DelegatingWebMvcConfiguration.**class**)
 *  3、**DelegatingWebMvcConfiguration** 的 作用，只保证SpringMVC最基本的使用

 *  把所有系统中的 WebMvcConfigurer 拿过来。所有功能的定制都是这些 WebMvcConfigurer  合起来一起生效
 *  自动配置了一些非常底层的组件。**RequestMappingHandlerMapping**、这些组件依赖的组件都是从容器中获取
 *  **public class** DelegatingWebMvcConfiguration **extends** **WebMvcConfigurationSupport**

 *  4、**WebMvcAutoConfiguration** 里面的配置要能生效 必须  @ConditionalOnMissingBean(**WebMvcConfigurationSupport**.**class**)
 *  5、@EnableWebMvc  导致了 **WebMvcAutoConfiguration  没有生效。**

 *  ... ...

  


## 2、原理分析套路 ##

**场景starter** **- xxxxAutoConfiguration - 导入xxx组件 - 绑定xxxProperties --** **绑定配置文件项**

  


  



[original]: https://gw.alipayobjects.com/mdn/prod_resource/afts/img/A*vl1iS57KtIoAAAAAAAAAAABjAQAAAQ/original
[later in this document]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-mvc-static-content
[later in this document 1]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-mvc-message-converters
[later in this document 2]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-message-codes
[later in this document 3]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-mvc-favicon
[later in this document 4]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-mvc-web-binding-initializer
[MVC customizations]: https://docs.spring.io/spring/docs/5.2.9.RELEASE/spring-framework-reference/web.html#mvc
[webjars]: http://localhost:8080/webjars/jquery/3.5.1/jquery.js
[https_www.webjars.org]: https://www.webjars.org/
[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603181171918-b8acfb93-4914-4208-9943-b37610e93864.png
[image.png 1]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603181460034-ba25f3c0-9cfd-4432-8949-3d1dd88d8b12.png
[image.png 2]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603181662070-9e526de8-fd78-4a02-9410-728f059d6aef.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 3]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603271442869-63b4c3c7-c721-4074-987d-cbe5999273ae.png
[image.png 4]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603271678813-d8e1a1e5-94fa-412c-a7f1-6f27174fd127.png?x-oss-process=image%2Fresize%2Cw_702
[image.png 5]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603271813894-037be041-92a5-49af-a49c-c350b3dd587a.png?x-oss-process=image%2Fresize%2Cw_938
[image.png 6]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603262942726-107353bd-f8b7-44f6-93cf-2a3cad4093cf.png
[image.png 7]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603263283504-85bbd4d5-a9af-4dbf-b6a2-30b409868774.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 8]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603263394724-33122714-9d06-42ec-bf45-e440e8b49c05.png
[image.png 9]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603263524227-386da4be-43b1-4b17-a2cc-8cf886346af9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 10]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603337871521-25fc1aa1-133a-4ce0-a146-d565633d7658.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 11]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603338486441-9bbd22a9-813f-49bd-b51b-e66c7f4b8598.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 12]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1603272018605-1bce3142-bdd9-4834-a028-c753e91c52ac.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 13]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605151090728-f7c60e6f-d0c0-4541-bfa3-8cc805dfd5d6.png
[image.png 14]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605151359370-01cd1fbe-628a-4eea-9430-d79a78f59125.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 15]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605151728659-68c8ce8a-1b2b-4ab0-b86d-c3a875184672.png
[image.png 16]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605163005521-a20d1d8e-0494-43d0-8135-308e7a22e896.png?x-oss-process=image%2Fresize%2Cw_1028
[image.png 17]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605163447900-e2748217-0f31-4abb-9cce-546b4d790d0b.png
[image.png 18]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605163584708-e19770d6-6b35-4caa-bf21-266b73cb1ef1.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 19]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605164243168-1a31e9af-54a4-463e-b65a-c28ca7a8a2fa.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 20]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605173127653-8a06cd0f-b8e1-4e22-9728-069b942eba3f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[http_localhost_8080_test_person_format_json]: http://localhost:8080/test/person?format=json
[image.png 21]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605230907471-b0ed34bc-6782-40e7-84b7-615726312f01.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 22]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605231074299-25f5b062-2de1-4a09-91bf-11e018d6ec0e.png
[image.png 23]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605230462280-ef98de47-6717-4e27-b4ec-3eb0690b55d0.png
[image.png 24]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605230546376-65dcf657-7653-4a58-837a-f5657778201a.png?x-oss-process=image%2Fresize%2Cw_916
[image.png 25]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605173876646-f63575e2-50c8-44d5-9603-c2d11a78adae.png
[image.png 26]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605173657818-73331882-6086-490c-973b-af46ccf07b32.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 27]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605260623995-8b1f7cec-9713-4f94-9cf1-8dbc496bd245.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 28]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605261062877-0a27cc41-51cb-4018-a9af-4e0338a247cd.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 29]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605680247945-088b0f17-185c-490b-8889-103e8b4d8c07.png
[image.png 30]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605679959020-54b96fe7-f2fc-4b4d-a392-426e1d5413de.png
[image.png 31]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605679471537-7db702dc-b165-4dc6-b64a-26459ee5fd6c.png
[image.png 32]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605679913592-151a616a-c754-4da3-a2c1-91dc0230a48d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[https_www.thymeleaf.org_doc_tutorials_3.0_usingthymeleaf.html_setting-value-to-specific-attributes]: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-value-to-specific-attributes
[image.png 33]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605498132699-4fae6085-a207-456c-89fa-e571ff1663da.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 34]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605764129365-5b31a748-1541-4bee-9692-1917b3364bc6.png?x-oss-process=image%2Fresize%2Cw_1028
[image.png 35]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605765121071-64cfc649-4892-49a3-ac08-88b52fb4286f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 36]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1605847414866-32b6cc9c-5191-4052-92eb-069d652dfbf9.png
[image.png 37]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606024421363-77083c34-0b0e-4698-bb72-42da351d3944.png
[image.png 38]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606024616835-bc491bf0-c3b1-4ac3-b886-d4ff3c9874ce.png
[image.png 39]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606024592756-d4ab8a6b-ec37-426b-8b39-010463603d57.png
[image.png 40]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606114118010-f4aaf5ee-2747-4402-bc82-08321b2490ed.png
[image.png 41]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606114688649-e6502134-88b3-48db-a463-04c23eddedc7.png
[image.png 42]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606044430037-8d599e30-1679-407c-96b7-4df345848fa4.png?x-oss-process=image%2Fresize%2Cw_856
[image.png 43]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606044487738-8cb1dcda-08c5-4104-a634-b2468512e60f.png?x-oss-process=image%2Fresize%2Cw_856
[image.png 44]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606043870164-3770e116-344f-448e-8bff-8f32438edc9a.png
[image.png 45]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606043904074-50b7f088-2d2b-4da5-85e2-0a756da74dca.png?x-oss-process=image%2Fresize%2Cw_1028
[image.png 46]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606047252166-ce71c3a1-0e0e-4499-90f4-6d80014ca19f.png
[image.png 47]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606047109161-c68a46c1-202a-4db1-bbeb-23fcae49bbe9.png
[image.png 48]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606047900473-e31c1dc3-7a5f-4f70-97de-5203429781fa.png
[image.png 49]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606284869220-8b63d54b-39c4-40f6-b226-f5f095ef9304.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[image.png 50]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606280937533-504d0889-b893-4a01-af68-2fc31ffce9fc.png?x-oss-process=image%2Fresize%2Cw_916
# 06、数据访问 #

# 1、SQL #

## 1、数据源的自动配置-**HikariDataSource** ##

### 1、导入JDBC场景 ###

    <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-data-jdbc</artifactId> </dependency>

###      ![image.png][]   川org.springframework.bootspring-bootstarterjdbc:2.4.  iorg.springirameworkbootspringbootstarter240(omitedforduplicate)  com.zaxxer:HikariCP:3.4.5  数据源  org.slf4jsIf4j-ap1.7.30mittedforduplicate)  org.springframeworkspring-jdbc:5.3.1jdb  orgspringframeworkpring-beans5.3.mdodulicate)  org.springframeworkpringcoe..ic  org.springframeworkspring-tx:5.3.1  事务  orgpringframework:spring-beans:5.3.1(midoduplicate)  org.springframeworkpringcor..ic      ###

  


  


数据库驱动？

为什么导入JDBC场景，官方不导入驱动？官方不知道我们接下要操作什么数据库。

数据库版本和驱动版本对应

    默认版本：<mysql.version>8.0.22</mysql.version> <dependency> <groupId>mysql</groupId> <artifactId>mysql-connector-java</artifactId> <!-- <version>5.1.49</version>--> </dependency> 想要修改版本 1、直接依赖引入具体版本（maven的就近依赖原则） 2、重新声明版本（maven的属性的就近优先原则） <properties> <java.version>1.8</java.version> <mysql.version>5.1.49</mysql.version> </properties>

  


  


### 2、分析自动配置 ###

#### 1、自动配置的类 ####

 *  DataSourceAutoConfiguration ： 数据源的自动配置

 *  修改数据源相关的配置：**spring.datasource**
 *  **数据库连接池的配置，是自己容器中没有DataSource才自动配置的**
 *  底层配置好的连接池是：**HikariDataSource**

    @Configuration(proxyBeanMethods = false) @Conditional(PooledDataSourceCondition.class) @ConditionalOnMissingBean({ DataSource.class, XADataSource.class }) @Import({ DataSourceConfiguration.Hikari.class, DataSourceConfiguration.Tomcat.class, DataSourceConfiguration.Dbcp2.class, DataSourceConfiguration.OracleUcp.class, DataSourceConfiguration.Generic.class, DataSourceJmxConfiguration.class }) protected static class PooledDataSourceConfiguration

  


 *  DataSourceTransactionManagerAutoConfiguration： 事务管理器的自动配置
 *  JdbcTemplateAutoConfiguration： **JdbcTemplate的自动配置，可以来对数据库进行crud**

 *  可以修改这个配置项@ConfigurationProperties(prefix = **"spring.jdbc"**) 来修改JdbcTemplate
 *  @Bean@Primary    JdbcTemplate；容器中有这个组件

 *  JndiDataSourceAutoConfiguration： jndi的自动配置
 *  XADataSourceAutoConfiguration： 分布式事务相关的

  


  


### 3、修改配置项 ###

  


  


### 4、测试 ###

## 2、使用Druid数据源 ##

### 1、druid官方github地址 ###

[https://github.com/alibaba/druid][https_github.com_alibaba_druid]

  


整合第三方技术的两种方式

 *  自定义
 *  找starter

  


### 2、自定义方式 ###

#### 1、创建数据源 ####

  


  


#### 2、StatViewServlet ####

> StatViewServlet的用途包括：
> 
>  *  提供监控信息展示的html页面
>  *  提供监控信息的JSON API

  


#### 3、StatFilter ####

> 用于统计监控信息；如SQL监控、URI监控

系统中所有filter：

<table style="width: 667px; text-align: left;">     
 <tbody> 
  <tr style="height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;"><span>别名</span></td> 
   <td style="color: #4F4F4F; text-align: left;"><span>Filter类名</span></td> 
  </tr> 
  <tr style="background-color: #F7F7F7; height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">default</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.stat.StatFilter</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">stat</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.stat.StatFilter</td> 
  </tr> 
  <tr style="background-color: #F7F7F7; height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">mergeStat</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.stat.MergeStatFilter</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">encoding</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.encoding.EncodingConvertFilter</td> 
  </tr> 
  <tr style="background-color: #F7F7F7; height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">log4j</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.logging.Log4jFilter</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">log4j2</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.logging.Log4j2Filter</td> 
  </tr> 
  <tr style="background-color: #F7F7F7; height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">slf4j</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.logging.Slf4jLogFilter</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #4F4F4F; text-align: left;">commonlogging</td> 
   <td style="color: #4F4F4F; text-align: left;">com.alibaba.druid.filter.logging.CommonsLogFilter</td> 
  </tr> 
 </tbody> 
</table>

 

**慢SQL记录配置**

### 3、使用官方starter方式 ###

#### 1、引入druid-starter ####

  


#### 2、分析自动配置 ####

 *  扩展配置项 **spring.datasource.druid**
 *  DruidSpringAopConfiguration.**class**,   监控SpringBean的；配置项：**spring.datasource.druid.aop-patterns**
 *  DruidStatViewServletConfiguration.**class**, 监控页的配置：**spring.datasource.druid.stat-view-servlet；默认开启**
 *  DruidWebStatFilterConfiguration.**class**, web监控配置；**spring.datasource.druid.web-stat-filter；默认开启**
 *  DruidFilterConfiguration.**class**\}) 所有Druid自己filter的配置

  


#### 3、配置示例 ####

SpringBoot配置示例

[https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter][https_github.com_alibaba_druid_tree_master_druid-spring-boot-starter]

  


配置项列表[https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7%E5%88%97%E8%A1%A8][https_github.com_alibaba_druid_wiki_DruidDataSource_E9_85_8D_E7_BD_AE_E5_B1_9E_E6_80_A7_E5_88_97_E8_A1_A8]

  


## 3、整合MyBatis操作 ##

[https://github.com/mybatis][https_github.com_mybatis]

starter

SpringBoot官方的Starter：spring-boot-starter-\*

第三方的： \*\-spring-boot-starter

 ![image.png][image.png 1] 

org.mybatis.pring.bootmybatisspring-bootstater2.1.4

org.springframework.bootringootta24.idoduica

org.springframework.bootspring-bootstaterjbc2.4

ogmybatispring.oomiringootautoconigu2.1.

Torg.mybatis:mybatis:3.5.6

org.mybatis:mybatis-spring:2.0.6

### 1、配置模式 ###

 *  全局配置文件
 *  SqlSessionFactory: 自动配置好了
 *  SqlSession：自动配置了 **SqlSessionTemplate 组合了SqlSession**
 *  @Import(**AutoConfiguredMapperScannerRegistrar**.**class**）；
 *  Mapper： 只要我们写的操作MyBatis的接口标准了 **@Mapper 就会被自动扫描进来**

可以修改配置文件中 mybatis 开始的所有；

  


  


  


配置 **private** Configuration **configuration**; mybatis.**configuration下面的所有，就是相当于改mybatis全局配置文件中的值**

  


  


  


 *  导入mybatis官方starter
 *  编写mapper接口。标准@Mapper注解
 *  编写sql映射文件并绑定mapper接口
 *  在application.yaml中指定Mapper配置文件的位置，以及指定全局配置文件的信息 （建议；**配置在mybatis.configuration**）

  


  


### 2、注解模式 ###

  


  


  


### 3、混合模式 ###

  


**最佳实战：**

 *  引入mybatis-starter
 *  **配置application.yaml中，指定mapper-location位置即可**
 *  编写Mapper接口并标注@Mapper注解
 *  简单方法直接注解方式
 *  复杂方法编写mapper.xml进行绑定映射
 *  *@MapperScan("com.atguigu.admin.mapper") 简化，其他的接口就可以不用标注@Mapper注解*

  


## 4、整合 MyBatis-Plus 完成CRUD ##

### 1、什么是MyBatis-Plus ###

[MyBatis-Plus][]（简称 MP）是一个 [MyBatis][] 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

[mybatis plus 官网][mybatis plus]

建议安装 **MybatisX** 插件 

  


### 2、整合MyBatis-Plus    ###

自动配置

 *  MybatisPlusAutoConfiguration 配置类，MybatisPlusProperties 配置项绑定。**mybatis-plus：xxx 就是对****mybatis-plus的定制**
 *  **SqlSessionFactory 自动配置好。底层是容器中默认的数据源**
 *  **mapperLocations 自动配置好的。有默认值。****classpath\*:/mapper/\*\*/\*.xml；任意包的类路径下的所有mapper文件夹下任意路径下的所有xml都是sql映射文件。  建议以后sql映射文件，放在 mapper下**
 *  **容器中也自动配置好了** **SqlSessionTemplate**
 *  **@Mapper 标注的接口也会被自动扫描；建议直接** @MapperScan(**"com.atguigu.admin.mapper"**) 批量扫描就行

  


  


**优点：**

 *  只需要我们的Mapper继承 **BaseMapper** 就可以拥有crud能力

  


  


  


### 3、CRUD功能 ###

  


# 2、NoSQL #

Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、**缓存**和消息中间件。 它支持多种类型的数据结构，如 [字符串（strings）][strings]， [散列（hashes）][hashes]， [列表（lists）][lists]， [集合（sets）][sets]， [有序集合（sorted sets）][sorted sets] 与范围查询， [bitmaps][]， [hyperloglogs][] 和 [地理空间（geospatial）][geospatial] 索引半径查询。 Redis 内置了 [复制（replication）][replication]，[LUA脚本（Lua scripting）][LUA_Lua scripting]， [LRU驱动事件（LRU eviction）][LRU_LRU eviction]，[事务（transactions）][transactions] 和不同级别的 [磁盘持久化（persistence）][persistence]， 并通过 [Redis哨兵（Sentinel）][Redis_Sentinel]和自动 [分区（Cluster）][Cluster]提供高可用性（high availability）。

## 1、Redis自动配置 ##

 ![image.png][image.png 2] 

川

org.springframework.booting-oot-statdatard:24.

org.springframework.bootring-ootstat2.4.mi

org.springframework.data:spring-data-redis:2.4.1

org.springframework.datapring-dataeyalue2.4.1

orgspringframeworkspring-tx:5.3.1

org.springframework:spring-oxm:5.3.1

iorg.springframeworkpring-aop.3.idoduica

oRg.springframeworkspring-context-support:5.3.1

lorg.slf4j:slf4j-api1.7.30mittedforduplicate

io.lettuce:lettuce-core:6.0.1.RELEASE

io.netty:netty-common:4.1.54.Final

io.netty:netty-handler:4.1.54.Final

io.netty:netty-transport:4.1.54.Final

io.projectreactor:reactor-core:3.4.0

  


自动配置：

 *  RedisAutoConfiguration 自动配置类。RedisProperties 属性类 --> **spring.redis.xxx是对redis的配置**
 *  连接工厂是准备好的。**Lettuce**ConnectionConfiguration、**Jedis**ConnectionConfiguration
 *  **自动注入了RedisTemplate**<**Object**, **Object**> ： xxxTemplate；
 *  **自动注入了StringRedisTemplate；k：v都是String**
 *  **key：value**
 *  **底层只要我们使用** **StringRedisTemplate、****RedisTemplate就可以操作redis**

  


  


**redis环境搭建**

**1、阿里云按量付费redis。经典网络**

**2、申请redis的公网连接地址**

**3、修改白名单  允许0.0.0.0/0 访问**

  


  


  


## 2、RedisTemplate与Lettuce ##

  


  


  


  


  


## 3、切换至jedis ##

  



[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606366100317-5e0199fa-6709-4d32-bce3-bb262e2e5e6a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[https_github.com_alibaba_druid]: https://github.com/alibaba/druid
[https_github.com_alibaba_druid_tree_master_druid-spring-boot-starter]: https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter
[https_github.com_alibaba_druid_wiki_DruidDataSource_E9_85_8D_E7_BD_AE_E5_B1_9E_E6_80_A7_E5_88_97_E8_A1_A8]: https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7%E5%88%97%E8%A1%A8
[https_github.com_mybatis]: https://github.com/mybatis
[image.png 1]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606704096118-53001250-a04a-4210-80ee-6de6a370be2e.png
[MyBatis-Plus]: https://github.com/baomidou/mybatis-plus
[MyBatis]: http://www.mybatis.org/mybatis-3/
[mybatis plus]: https://baomidou.com/
[strings]: http://www.redis.cn/topics/data-types-intro.html#strings
[hashes]: http://www.redis.cn/topics/data-types-intro.html#hashes
[lists]: http://www.redis.cn/topics/data-types-intro.html#lists
[sets]: http://www.redis.cn/topics/data-types-intro.html#sets
[sorted sets]: http://www.redis.cn/topics/data-types-intro.html#sorted-sets
[bitmaps]: http://www.redis.cn/topics/data-types-intro.html#bitmaps
[hyperloglogs]: http://www.redis.cn/topics/data-types-intro.html#hyperloglogs
[geospatial]: http://www.redis.cn/commands/geoadd.html
[replication]: http://www.redis.cn/topics/replication.html
[LUA_Lua scripting]: http://www.redis.cn/commands/eval.html
[LRU_LRU eviction]: http://www.redis.cn/topics/lru-cache.html
[transactions]: http://www.redis.cn/topics/transactions.html
[persistence]: http://www.redis.cn/topics/persistence.html
[Redis_Sentinel]: http://www.redis.cn/topics/sentinel.html
[Cluster]: http://www.redis.cn/topics/cluster-tutorial.html
[image.png 2]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606745732785-17d1227a-75b9-4f00-a3f1-7fc4137b5113.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
# 07、单元测试 #

# 1、JUnit5 的变化 #

**Spring Boot 2.2.0 版本开始引入 JUnit 5 作为单元测试默认库**

作为最新版本的JUnit框架，JUnit5与之前版本的Junit框架有很大的不同。由三个不同子项目的几个不同模块组成。

> **JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage**

**JUnit Platform**: Junit Platform是在JVM上启动测试框架的基础，不仅支持Junit自制的测试引擎，其他测试引擎也都可以接入。

**JUnit Jupiter**: JUnit Jupiter提供了JUnit5的新的编程模型，是JUnit5新特性的核心。内部 包含了一个**测试引擎**，用于在Junit Platform上运行。

**JUnit Vintage**: 由于JUint已经发展多年，为了照顾老的项目，JUnit Vintage提供了兼容JUnit4.x,Junit3.x的测试引擎。

 ![1606796395719-eb57ab48-ae44-45e5-8d2e-c4d507aff49a.png][] 

注意：

**SpringBoot 2.4 以上版本移除了默认对 Vintage 的依赖。如果需要兼容junit4需要自行引入（不能使用junit4的功能 @Test）**

**JUnit 5’s Vintage Engine Removed from** **`spring-boot-starter-test,如果需要继续兼容junit4需要自行引入vintage`**

    <dependency> <groupId>org.junit.vintage</groupId> <artifactId>junit-vintage-engine</artifactId> <scope>test</scope> <exclusions> <exclusion> <groupId>org.hamcrest</groupId> <artifactId>hamcrest-core</artifactId> </exclusion> </exclusions> </dependency>

  


  


 ![image.png][] 

orgjunit.jupiterjunit-jupiter:5.7.0test)

iorgjunitjupiterjunit-jupiterapi5.7.0(

org.apiguardian:apiguardian-ap1.1.0

org.opentest4i:opentest4j:1.2.0(test)

orgjunit.platfommjunit-platform-commons1.7.0()

orgjunitjupiterjuiit-jupiter-params5.7.0(est)

dorgjunit.jupiterjunit-jupiterengine.7.()

org.apiguardian:apiguadinai.1.mitdoulicate)

lorgjunit.platformjunit-platform-engine;1.7.0(test)

org.apiguardianapiguardianapi.1.1.0(tsomittedforduplic

org.opentest4iopentes41.2.0ioduica)

org.junit.platfomjuitlafomcommo.

org.junitjupiterjunituitapi..duic

  


  


    <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-test</artifactId> <scope>test</scope> </dependency>

现在版本：

  


  


以前：

@SpringBootTest + @RunWith(SpringTest.class)

  


  


SpringBoot整合Junit以后。

 *  编写测试方法：@Test标注（注意需要使用junit5版本的注解）
 *  Junit类具有Spring的功能，@Autowired、比如 @Transactional 标注测试方法，测试完成后自动回滚

  


# 2、JUnit5常用注解 #

JUnit5的注解与JUnit4的注解有所变化

[https://junit.org/junit5/docs/current/user-guide/\#writing-tests-annotations][https_junit.org_junit5_docs_current_user-guide_writing-tests-annotations]

 *  **@Test :**表示方法是测试方法。但是与JUnit4的@Test不同，他的职责非常单一不能声明任何属性，拓展的测试将会由Jupiter提供额外测试
 *  **@ParameterizedTest :**表示方法是参数化测试，下方会有详细介绍
 *  **@RepeatedTest :**表示方法可重复执行，下方会有详细介绍
 *  **@DisplayName :**为测试类或者测试方法设置展示名称
 *  **@BeforeEach :**表示在每个单元测试之前执行
 *  **@AfterEach :**表示在每个单元测试之后执行
 *  **@BeforeAll :**表示在所有单元测试之前执行
 *  **@AfterAll :**表示在所有单元测试之后执行
 *  **@Tag :**表示单元测试类别，类似于JUnit4中的@Categories
 *  **@Disabled :**表示测试类或测试方法不执行，类似于JUnit4中的@Ignore
 *  **@Timeout :**表示测试方法运行如果超过了指定时间将会返回错误
 *  **@ExtendWith :**为测试类或测试方法提供扩展类引用

  


# 3、断言（assertions） #

断言（assertions）是测试方法中的核心部分，用来对测试需要满足的条件进行验证。**这些断言方法都是 org.junit.jupiter.api.Assertions 的静态方法**。JUnit 5 内置的断言可以分成如下几个类别：

**检查业务逻辑返回的数据是否合理。**

**所有的测试运行结束以后，会有一个详细的测试报告；**

## 1、简单断言 ##

用来对单个值进行简单的验证。如：

<table style="width: 786px;">     
 <thead> 
  <tr style="height: 33px;"> 
   <td colspan="1" style="text-align: left;">方法</td> 
   <td colspan="1" style="text-align: left;">说明</td> 
  </tr> 
 </thead> 
 <tbody> 
  <tr style="background-color: inherit; height: 33px;"> 
   <td style="background-color: inherit;">assertEquals</td> 
   <td style="background-color: inherit;">判断两个对象或两个原始类型是否相等</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="background-color: inherit;">assertNotEquals</td> 
   <td style="background-color: inherit;">判断两个对象或两个原始类型是否不相等</td> 
  </tr> 
  <tr style="background-color: inherit; height: 33px;"> 
   <td style="background-color: inherit;">assertSame</td> 
   <td style="background-color: inherit;">判断两个对象引用是否指向同一个对象</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="background-color: inherit;">assertNotSame</td> 
   <td style="background-color: inherit;">判断两个对象引用是否指向不同的对象</td> 
  </tr> 
  <tr style="background-color: inherit; height: 33px;"> 
   <td style="background-color: inherit;">assertTrue</td> 
   <td style="background-color: inherit;">判断给定的布尔值是否为 true</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="background-color: inherit;">assertFalse</td> 
   <td style="background-color: inherit;">判断给定的布尔值是否为 false</td> 
  </tr> 
  <tr style="background-color: inherit; height: 33px;"> 
   <td style="background-color: inherit;">assertNull</td> 
   <td style="background-color: inherit;">判断给定的对象引用是否为 null</td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="background-color: inherit;">assertNotNull</td> 
   <td style="background-color: inherit;">判断给定的对象引用是否不为 null</td> 
  </tr> 
 </tbody> 
</table>

 

  


## 2、数组断言 ##

通过 assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等

  


## 3、组合断言 ##

assertAll 方法接受多个 org.junit.jupiter.api.Executable 函数式接口的实例作为要验证的断言，可以通过 lambda 表达式很容易的提供这些断言

  


  


## 4、异常断言 ##

在JUnit4时期，想要测试方法的异常情况时，需要用**@Rule**注解的ExpectedException变量还是比较麻烦的。而JUnit5提供了一种新的断言方式**Assertions.assertThrows()** ,配合函数式编程就可以进行使用。

  


## 5、超时断言 ##

Junit5还提供了**Assertions.assertTimeout()** 为测试方法设置了超时时间

  


## 6、快速失败 ##

通过 fail 方法直接使得测试失败

  


# 4、前置条件（assumptions） #

JUnit 5 中的前置条件（**assumptions【假设】**）类似于断言，不同之处在于**不满足的断言会使得测试方法失败**，而不满足的**前置条件只会使得测试方法的执行终止**。前置条件可以看成是测试方法执行的前提，当该前提不满足时，就没有继续执行的必要。

assumeTrue 和 assumFalse 确保给定的条件为 true 或 false，不满足条件会使得测试执行终止。assumingThat 的参数是表示条件的布尔值和对应的 Executable 接口的实现对象。只有条件满足时，Executable 对象才会被执行；当条件不满足时，测试执行并不会终止。

  


# 5、嵌套测试 #

JUnit 5 可以通过 Java 中的内部类和@Nested 注解实现嵌套测试，从而可以更好的把相关的测试方法组织在一起。在内部类中可以使用@BeforeEach 和@AfterEach 注解，而且嵌套的层次没有限制。

  


  


# 6、参数化测试 #

参数化测试是JUnit5很重要的一个新特性，它使得用不同的参数多次运行测试成为了可能，也为我们的单元测试带来许多便利。

  


利用**@ValueSource**等注解，指定入参，我们将可以使用不同的参数进行多次单元测试，而不需要每新增一个参数就新增一个单元测试，省去了很多冗余代码。

  


**@ValueSource**: 为参数化测试指定入参来源，支持八大基础类以及String类型,Class类型

**@NullSource**: 表示为参数化测试提供一个null的入参

**@EnumSource**: 表示为参数化测试提供一个枚举入参

**@CsvFileSource**：表示读取指定CSV文件内容作为参数化测试入参

**@MethodSource**：表示读取指定方法的返回值作为参数化测试入参(注意方法返回需要是一个流)

> 当然如果参数化测试仅仅只能做到指定普通的入参还达不到让我觉得惊艳的地步。让我真正感到他的强大之处的地方在于他可以支持外部的各类入参。如:CSV,YML,JSON 文件甚至方法的返回值也可以作为入参。只需要去实现**ArgumentsProvider**接口，任何外部文件都可以作为它的入参。

  


# 7、迁移指南 #

在进行迁移的时候需要注意如下的变化：

 *  注解在 org.junit.jupiter.api 包中，断言在 org.junit.jupiter.api.Assertions 类中，前置条件在 org.junit.jupiter.api.Assumptions 类中。
 *  把@Before 和@After 替换成@BeforeEach 和@AfterEach。
 *  把@BeforeClass 和@AfterClass 替换成@BeforeAll 和@AfterAll。
 *  把@Ignore 替换成@Disabled。
 *  把@Category 替换成@Tag。
 *  把@RunWith、@Rule 和@ClassRule 替换成@ExtendWith。


[1606796395719-eb57ab48-ae44-45e5-8d2e-c4d507aff49a.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606796395719-eb57ab48-ae44-45e5-8d2e-c4d507aff49a.png
[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606797616337-e73010e9-9cac-496d-a177-64b677af5a3d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[https_junit.org_junit5_docs_current_user-guide_writing-tests-annotations]: https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations
# 08、指标监控 #

# 1、SpringBoot Actuator #

## 1、简介 ##

未来每一个微服务在云上部署以后，我们都需要对其进行监控、追踪、审计、控制等。SpringBoot就抽取了Actuator场景，使得我们每个微服务快速引用即可获得生产级别的应用监控、审计等功能。

    <dependency> <groupId>org.springframework.boot</groupId> <artifactId>spring-boot-starter-actuator</artifactId> </dependency>

 ![image.png][] 

orgspringframework.bootspring-bootstateractuator:2.4.0

orgspringframework.bootingootta24iuic

org.springframework.bootring-ootcuaouoconiqu2.4.

io.micrometer:micrometer-core:1.6.1

## 2、1.x与2.x的不同 ##

  


 ![image.png][image.png 1] 

SpringBootActuator2.X

SpringBootActuator1.x

支持SpringMVC

支持SpringMVCJAX-RS以及

基于继承方式进行扩展

Webflux

层级Metrics配置

注解驱动进行扩展

自定义Metrics收集

层级&名称空间Metrics

默认较少的安全策略

底层使用MicroMeter,强大,便捷

默认丰富的安全策略

  


  


## 3、如何使用 ##

 *  引入场景
 *  访问 [http://localhost:8080/actuator/][http_localhost_8080_actuator]\*\*
 *  暴露所有监控信息为HTTP

    management: endpoints: enabled-by-default: true #暴露所有端点信息 web: exposure: include: '*' #以web方式暴露

 *  测试

[http://localhost:8080/actuator/beans][http_localhost_8080_actuator_beans]

[http://localhost:8080/actuator/configprops][http_localhost_8080_actuator_configprops]

[http://localhost:8080/actuator/metrics][http_localhost_8080_actuator_metrics]

[http://localhost:8080/actuator/metrics/jvm.gc.pause][http_localhost_8080_actuator_metrics_jvm.gc.pause]

[http://localhost:8080/actuator/][http_localhost_8080_actuator_metrics]endpointName/detailPath  
。。。。。。

  


  


## 4、可视化 ##

[https://github.com/codecentric/spring-boot-admin][https_github.com_codecentric_spring-boot-admin]

  


# 2、Actuator Endpoint #

## 1、最常使用的端点 ##

  


<table style="width: 751px;">     
 <thead> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;">ID</td> 
   <td style="color: #000000; text-align: left; vertical-align: top;">描述</td> 
  </tr> 
 </thead> 
 <tbody> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>auditevents</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>暴露当前应用程序的审核事件信息。需要一个<code>AuditEventRepository组件</code>。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>beans</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示应用程序中所有Spring Bean的完整列表。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>caches</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>暴露可用的缓存。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>conditions</code></p></td> 
   <td><p>显示自动配置的所有条件信息，包括匹配或不匹配的原因。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>configprops</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示所有<code>@ConfigurationProperties</code>。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>env</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>暴露Spring的属性<code>ConfigurableEnvironment</code></p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>flyway</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示已应用的所有Flyway数据库迁移。<br>需要一个或多个<code>Flyway</code>组件。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>health</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示应用程序运行状况信息。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>httptrace</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示HTTP跟踪信息（默认情况下，最近100个HTTP请求-响应）。需要一个<code>HttpTraceRepository</code>组件。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>info</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示应用程序信息。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>integrationgraph</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示Spring&nbsp;<code><span>integrationgraph</span></code> 。需要依赖<code>spring-integration-core</code>。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>loggers</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示和修改应用程序中日志的配置。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>liquibase</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示已应用的所有Liquibase数据库迁移。需要一个或多个<code>Liquibase</code>组件。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>metrics</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示当前应用程序的“指标”信息。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>mappings</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示所有<code>@RequestMapping</code>路径列表。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>scheduledtasks</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示应用程序中的计划任务。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>sessions</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>允许从Spring Session支持的会话存储中检索和删除用户会话。需要使用Spring Session的基于Servlet的Web应用程序。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>shutdown</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>使应用程序正常关闭。默认禁用。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>startup</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>显示由<code><span>ApplicationStartup</span></code>收集的启动步骤数据。需要使用<code>SpringApplication</code>进行配置<code>BufferingApplicationStartup</code>。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>threaddump</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>执行线程转储。</p></td> 
  </tr> 
 </tbody> 
</table>

 

  


  


如果您的应用程序是Web应用程序（Spring MVC，Spring WebFlux或Jersey），则可以使用以下附加端点：

<table style="width: 720px;">     
 <thead> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;">ID</td> 
   <td style="color: #000000; text-align: left; vertical-align: top;">描述</td> 
  </tr> 
 </thead> 
 <tbody> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>heapdump</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>返回<code>hprof</code>堆转储文件。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>jolokia</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>通过HTTP暴露JMX bean（需要引入Jolokia，不适用于WebFlux）。需要引入依赖<code>jolokia-core</code>。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>logfile</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>返回日志文件的内容（如果已设置<code>logging.file.name</code>或<code>logging.file.path</code>属性）。支持使用HTTP<code>Range</code>标头来检索部分日志文件的内容。</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>prometheus</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>以Prometheus服务器可以抓取的格式公开指标。需要依赖<code>micrometer-registry-prometheus</code>。</p></td> 
  </tr> 
 </tbody> 
</table>

 

  


  


最常用的Endpoint

 *  **Health：监控状况**
 *  **Metrics：运行时指标**
 *  **Loggers：日志记录**

  


  


## 2、Health Endpoint ##

健康检查端点，我们一般用于在云平台，平台会定时的检查应用的健康状况，我们就需要Health Endpoint可以为平台返回当前应用的一系列组件健康状况的集合。

重要的几点：

 *  health endpoint返回的结果，应该是一系列健康检查后的一个汇总报告
 *  很多的健康检查默认已经自动配置好了，比如：数据库、redis等
 *  可以很容易的添加自定义的健康检查机制

 ![image.png][image.png 2] 

全部折叠全部展开

保存

status:

component's:

fo

db:

diskspace:

f..

f..

ping:

## 3、Metrics Endpoint ##

提供详细的、层级的、空间指标信息，这些信息可以被pull（主动推送）或者push（被动获取）方式得到；

 *  通过Metrics对接多种监控系统
 *  简化核心Metrics开发
 *  添加自定义Metrics或者扩展已有Metrics

  


 ![image.png][image.png 3] 

names:

"http.server.requests"

0:

"jvm.buffer.count"

1:"

2:"jvm,buffer.memory.used"

3:"jivm,buffer.total.capacity

4:

"jivm.classes.1oaded"

5:

"jivm.classes.un1oaded"

6:

"jvm.gc.live.data.size

7:

"jivm.gc.max.data.size

8:

"jivm.gc.memory.allocated"

9:

"jvm.gc.memory.promoted"

"jvm.gc.pause"

10:

"jivm.memory.committed"

11:

12:

"jvm.memory.max?

"jvm.memory.used"

13:

14:

"jvm.threads.daemon"

15:

"jivm.threadsive

16:

"jvm.threads.peak"

17:

"jvm.threads.states

"1ogback.events"

18:

19:

"process.Cpu.usage

20:

"process.start.time

21:

"process.uptime"

22:

"system.cpu.count"

23:

"'system.cpu.usage"

  


  


  


## 4、管理Endpoints ##

### 1、开启与禁用Endpoints ###

 *  默认所有的Endpoint除过shutdown都是开启的。
 *  需要开启或者禁用某个Endpoint。配置模式为  **management.endpoint.****<endpointName>****.enabled = true**

 *  或者禁用所有的Endpoint然后手动开启指定的Endpoint

  


  


### 2、暴露Endpoints ###

支持的暴露方式

 *  HTTP：默认只暴露**health**和**info** Endpoint
 *  **JMX**：默认暴露所有Endpoint
 *  除过health和info，剩下的Endpoint都应该进行保护访问。如果引入SpringSecurity，则会默认配置安全访问规则

<table style="width: 604px;">      
 <thead> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;">ID</td> 
   <td style="color: #000000; text-align: left; vertical-align: top;">JMX</td> 
   <td style="color: #000000; text-align: left; vertical-align: top;">Web</td> 
  </tr> 
 </thead> 
 <tbody> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>auditevents</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>beans</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>caches</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>conditions</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>configprops</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>env</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>flyway</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>health</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>heapdump</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>N/A</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>httptrace</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>info</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>integrationgraph</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>jolokia</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>N/A</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>logfile</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>N/A</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>loggers</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>liquibase</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>metrics</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>mappings</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>prometheus</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>N/A</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>scheduledtasks</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>sessions</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>shutdown</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>startup</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
  <tr style="height: 33px;"> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p><code>threaddump</code></p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>Yes</p></td> 
   <td style="color: #000000; text-align: left; vertical-align: top;"><p>No</p></td> 
  </tr> 
 </tbody> 
</table>

 

  


  


  


  


# 3、定制 Endpoint #

## 1、定制 Health 信息 ##

  


  


###     ###

## 2、定制info信息 ##

常用两种方式

#### 1、编写配置文件 ####

#### 2、编写InfoContributor ####

  


  


[http://localhost:8080/actuator/info][http_localhost_8080_actuator_info] 会输出以上方式返回的所有info信息

## 3、定制Metrics信息 ##

#### 1、SpringBoot支持自动适配的Metrics ####

 *  JVM metrics, report utilization of:

 *  Various memory and buffer pools  
    
 *  Statistics related to garbage collection  
    
 *  Threads utilization  
    
 *  Number of classes loaded/unloaded  
    

 *  CPU metrics  
    
 *  File descriptor metrics  
    
 *  Kafka consumer and producer metrics  
    
 *  Log4j2 metrics: record the number of events logged to Log4j2 at each level  
    
 *  Logback metrics: record the number of events logged to Logback at each level  
    
 *  Uptime metrics: report a gauge for uptime and a fixed gauge representing the application’s absolute start time  
    
 *  Tomcat metrics (`server.tomcat.mbeanregistry.enabled` must be set to `true` for all Tomcat metrics to be registered)  
    
 *  [Spring Integration][] metrics  
    

  


#### 2、增加定制Metrics ####

  


  


## 4、定制Endpoint ##

场景：开发**ReadinessEndpoint**来管理程序是否就绪，或者**Liveness****Endpoint**来管理程序是否存活；

当然，这个也可以直接使用 [https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html\#production-ready-kubernetes-probes][https_docs.spring.io_spring-boot_docs_current_reference_html_production-ready-features.html_production-ready-kubernetes-probes]

  


更多内容参照：大厂学院

  


  


  


  


  



[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606886483335-697ee1c1-2f69-43ab-bddc-3a038382319c.png
[image.png 1]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606884394162-ac7f2d8e-7abb-44df-9998-fb0f2705f238.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_1028
[http_localhost_8080_actuator]: http://localhost:8080/actuator/
[http_localhost_8080_actuator_beans]: http://localhost:8080/actuator/beans
[http_localhost_8080_actuator_configprops]: http://localhost:8080/actuator/configprops
[http_localhost_8080_actuator_metrics]: http://localhost:8080/actuator/metrics
[http_localhost_8080_actuator_metrics_jvm.gc.pause]: http://localhost:8080/actuator/metrics/jvm.gc.pause
[https_github.com_codecentric_spring-boot-admin]: https://github.com/codecentric/spring-boot-admin
[image.png 2]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606908975702-4f9a3208-15ca-4a78-9f76-939ef986db7e.png
[image.png 3]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1606909073222-c6e77ca3-4b1c-4f38-a1c6-8614dec4f7bc.png
[http_localhost_8080_actuator_info]: http://localhost:8080/actuator/info
[Spring Integration]: https://docs.spring.io/spring-integration/docs/5.4.1/reference/html/system-management.html#micrometer-integration
[https_docs.spring.io_spring-boot_docs_current_reference_html_production-ready-features.html_production-ready-kubernetes-probes]: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-kubernetes-probes
# 09、原理解析 #

# 1、Profile功能 #

为了方便多环境适配，springboot简化了profile功能。

## 1、application-profile功能 ##

 *  默认配置文件  application.yaml；任何时候都会加载
 *  指定环境配置文件  application-\{env\}.yaml
 *  激活指定环境

 *  配置文件激活
 *  命令行激活：java -jar xxx.jar --**spring.profiles.active=prod  --person.name=haha**

 *  **修改配置文件的任意值，命令行优先**

 *  默认配置与环境配置同时生效
 *  同名配置项，profile配置优先

  


  


## 2、@Profile条件装配功能 ##

    @Configuration(proxyBeanMethods = false) @Profile("production") public class ProductionConfiguration { // ... }

## 3、profile分组 ##

    spring.profiles.group.production[0]=proddb spring.profiles.group.production[1]=prodmq 使用：--spring.profiles.active=production 激活

  


  


# 2、外部化配置 #

[https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html\#boot-features-external-config][https_docs.spring.io_spring-boot_docs_current_reference_html_spring-boot-features.html_boot-features-external-config]

##     ##

1.  Default properties (specified by setting `SpringApplication.setDefaultProperties`).  
    
2.  [`@PropertySource`][PropertySource] annotations on your `@Configuration` classes. Please note that such property sources are not added to the `Environment` until the application context is being refreshed. This is too late to configure certain properties such as `logging.*` and `spring.main.*` which are read before refresh begins.  
    
3.  **Config data (such as** **`application.properties`** **files)**  
    
4.  A `RandomValuePropertySource` that has properties only in `random.*`.  
    
5.  OS environment variables.  
    
6.  Java System properties (`System.getProperties()`).  
    
7.  JNDI attributes from `java:comp/env`.  
    
8.  `ServletContext` init parameters.  
    
9.  `ServletConfig` init parameters.  
    
10. Properties from `SPRING_APPLICATION_JSON` (inline JSON embedded in an environment variable or system property).  
    
11. Command line arguments.  
    
12. `properties` attribute on your tests. Available on [`@SpringBootTest`][SpringBootTest] and the [test annotations for testing a particular slice of your application][].  
    
13. [`@TestPropertySource`][TestPropertySource] annotations on your tests.  
    
14. [Devtools global settings properties][] in the `$HOME/.config/spring-boot` directory when devtools is active.  
    

  


## 1、外部配置源 ##

常用：**Java属性文件**、**YAML文件**、**环境变量**、**命令行参数**；

  


## 2、配置文件查找位置 ##

(1) classpath 根路径

(2) classpath 根路径下config目录

(3) jar包当前目录

(4) jar包当前目录的config目录

(5) /config子目录的直接子目录

## 3、配置文件加载顺序： ##

1.  　当前jar包内部的application.properties和application.yml
2.  　当前jar包内部的application-\{profile\}.properties 和 application-\{profile\}.yml
3.  　引用的外部jar包的application.properties和application.yml
4.  　引用的外部jar包的application-\{profile\}.properties 和 application-\{profile\}.yml

## 4、指定环境优先，外部优先，后面的可以覆盖前面的同名配置项 ##

  


  


  


  


  


  


  


# 3、自定义starter #

## 1、starter启动原理 ##

 *  starter-pom引入 autoconfigurer 包

 100% 

![original][]

  

 *  autoconfigure包中配置使用 **META-INF/spring.factories** 中 **EnableAutoConfiguration 的值，使得项目启动加载指定的自动配置类**
 *  **编写自动配置类 xxxAutoConfiguration -> xxxxProperties**

 *  **@Configuration**
 *  **@Conditional**
 *  **@EnableConfigurationProperties**
 *  **@Bean**
 *  ......

**引入starter** **--- xxxAutoConfiguration --- 容器中放入组件 ---- 绑定xxxProperties ----** **配置项**

## 2、自定义starter ##

**atguigu-hello-spring-boot-starter（启动器）**

**atguigu-hello-spring-boot-starter-autoconfigure（自动配置包）**

  


  


  


# 4、SpringBoot原理 #

Spring原理【[Spring注解][Spring]】、**SpringMVC**原理、**自动配置原理**、SpringBoot原理

## 1、SpringBoot启动过程 ##

 *  创建 **SpringApplication**

 *  保存一些信息。
 *  判定当前应用的类型。ClassUtils。Servlet
 *  **bootstrappers****：初始启动引导器（**List<Bootstrapper>**）：去spring.factories文件中找** org.springframework.boot.**Bootstrapper**
 *  找 **ApplicationContextInitializer**；去**spring.factories****找** **ApplicationContextInitializer**

 *  List<ApplicationContextInitializer<?>> **initializers**

 *  **找** **ApplicationListener  ；应用监听器。**去**spring.factories****找** **ApplicationListener**

 *  List<ApplicationListener<?>> **listeners**

 *  运行 **SpringApplication**

 *  **StopWatch**
 *  **记录应用的启动时间**
 *  **创建引导上下文（Context环境）****createBootstrapContext()**

 *  获取到所有之前的 **bootstrappers 挨个执行** intitialize() 来完成对引导启动器上下文环境设置

 *  让当前应用进入**headless**模式。**java.awt.headless**
 *  **获取所有** **RunListener****（运行监听器）【为了方便所有Listener进行事件感知】**

 *  getSpringFactoriesInstances 去**spring.factories****找** **SpringApplicationRunListener**.

 *  遍历 **SpringApplicationRunListener 调用 starting 方法；**

 *  **相当于通知所有感兴趣系统正在启动过程的人，项目正在 starting。**

 *  保存命令行参数；ApplicationArguments
 *  准备环境 prepareEnvironment（）;

 *  返回或者创建基础环境信息对象。**StandardServletEnvironment**
 *  **配置环境信息对象。**

 *  **读取所有的配置源的配置属性值。**

 *  绑定环境信息
 *  监听器调用 listener.environmentPrepared()；通知所有的监听器当前环境准备完成

 *  创建IOC容器（createApplicationContext（））

 *  根据项目类型（Servlet）创建容器，
 *  当前会创建 **AnnotationConfigServletWebServerApplicationContext**

 *  **准备ApplicationContext IOC容器的基本信息**   **prepareContext()**

 *  保存环境信息
 *  IOC容器的后置处理流程。
 *  应用初始化器；applyInitializers；

 *  遍历所有的 **ApplicationContextInitializer 。调用** **initialize.。来对ioc容器进行初始化扩展功能**
 *  遍历所有的 listener 调用 **contextPrepared。EventPublishRunListenr；通知所有的监听器contextPrepared**

 *  **所有的监听器 调用** **contextLoaded。通知所有的监听器 contextLoaded；**

 *  **刷新IOC容器。**refreshContext

 *  创建容器中的所有组件（Spring注解）

 *  容器刷新完成后工作？afterRefresh
 *  所有监听 器 调用 listeners.**started**(context); **通知所有的监听器** **started**
 *  **调用所有runners；**callRunners()

 *  **获取容器中的** **ApplicationRunner** 
 *  **获取容器中的  ****CommandLineRunner**
 *  **合并所有runner并且按照@Order进行排序**
 *  **遍历所有的runner。调用 run** **方法**

 *  **如果以上有异常，**

 *  **调用Listener 的 failed**

 *  **调用所有监听器的 running 方法  **listeners.running(context); **通知所有的监听器** **running** 
 *  **running如果有问题。继续通知 failed 。****调用所有 Listener 的** **failed；****通知所有的监听器** **failed**

  


  


  


 ![image.png][] 

LinkedHashSet@3540size7

o0result

\-DelegatingApplicationContextlnitializer@3499

1-SharedMetadataReaderFactoryContextlnitializ@3520

三2-ContextldApplicationContextlnitializer@3537)

3-ConfigurationwamingsApplicationContextlnitializer@3542

三4-RSoCKetPortlnfoApplicationContextlnitializer@3543

5-ServerPortlnfoApplicationContextlnitializer@3544

6-ConditionEvaluationReportLoggingListener@3545

 ![image.png][image.png 1] 

SpringApplicationRunListener

ContextLoaded(ConfigurableApplicationContext)vo

contextPrepared(ConfigurableApplicationContext):void

enyironmentpreparedConigurableBootstraonxili

enviFenMentPreparedConfigurableEnvironment:yoid

failedConfigurableApplicationContexw

running(ConfigurableApplicationContext):void

startedConfigurableApplicationContext):void

stantingo:void

starting(ConfigurableBootstrapContext):void

  


 ![image.png][image.png 2] 

this.listeners-ArrayList@2114size

0-EventPublishingRunListener@2116

applicationSpringApplication@1446

args-fString\[0\]@1230\]

initialMulticasterSimpleApplicationventMulticaste@2117

##     ##

## 2、Application Events and Listeners ##

[https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html\#boot-features-application-events-and-listeners][https_docs.spring.io_spring-boot_docs_current_reference_html_spring-boot-features.html_boot-features-application-events-and-listeners]

**ApplicationContextInitializer**

**ApplicationListener**

**SpringApplicationRunListener**

  


## 3、ApplicationRunner 与 CommandLineRunner ##

  


  


  


  


  


##     ##


[https_docs.spring.io_spring-boot_docs_current_reference_html_spring-boot-features.html_boot-features-external-config]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config
[PropertySource]: https://docs.spring.io/spring/docs/5.3.1/javadoc-api/org/springframework/context/annotation/PropertySource.html
[SpringBootTest]: https://docs.spring.io/spring-boot/docs/2.4.0/api/org/springframework/boot/test/context/SpringBootTest.html
[test annotations for testing a particular slice of your application]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-tests
[TestPropertySource]: https://docs.spring.io/spring/docs/5.3.1/javadoc-api/org/springframework/test/context/TestPropertySource.html
[Devtools global settings properties]: https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools-globalsettings
[original]: https://gw.alipayobjects.com/mdn/prod_resource/afts/img/A*vl1iS57KtIoAAAAAAAAAAABjAQAAAQ/original
[Spring]: https://www.bilibili.com/video/BV1gW411W7wy?p=1
[image.png]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1607005958877-bf152e3e-4d2d-42b6-a08c-ceef9870f3b6.png
[image.png 1]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1607004823889-8373cea4-6305-40c1-af3b-921b071a28a8.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
[image.png 2]: https://cdn.nlark.com/yuque/0/2020/png/1354552/1607006112013-6ed5c0a0-3e02-4bf1-bdb7-423e0a0b3f3c.png
[https_docs.spring.io_spring-boot_docs_current_reference_html_spring-boot-features.html_boot-features-application-events-and-listeners]: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-application-events-and-listeners
# 第一季：SpringBoot2核心技术-场景整合 #

更多内容关注  尚硅谷-[**大厂学院**][Link 1]

  


[http://www.itdachang.com/][Link 1]

  


  



[Link 1]: http://www.itdachang.com/
