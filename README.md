# crawler爬虫项目
## 主要技术
- Spring Boot，项目主要框架
- WebMagic，Java爬虫框架
- LogBack，日志框架
- MyBatis，持久层框架
- Selenium，自动化测试工具
## 简介
本项目为使用Spring Boot工具搭建的SpringWeb项目，利用WebMagic、Jsoup实现网页爬取、页面分析、数据提取、数据持久化到数据库以及图片、压缩包等资源下载到本地。使用LogBack作为日志框架，MyBatis作为持久层框架。对于使用JS渲染而生成的网页或是网页数据经过加密的网站，使用Selenium模拟用户登录浏览器，爬取渲染后的最终页面。部分网站采用了防盗链技术，此时必须在请求资源时设置请求头，否则无法下载资源。

目前该项目由多个业务模块构成，下面依次介绍：

1. 获取WebMagic官方文档
   
   入口WebmagicDocPageProcessor.java
   
   较为简单，获取网页内容后，使用com.overzealous.remark.Remark工具类将HTML转换为Markdown，最后持久化到本地文件。

   注意：默认文件存储位置为 D:/crawler/output ，也可自行修改PathConstant.java中的路径常量。
   
   为了避免文章内容顺序有问题，在代码中设置了线程数为1。
   
2. 获取MyBatis官方文档

   入口MyBatisPageProcessor.java

3. 获取CSDN博客文档

   入口CSDNPageProcessor.java

4. 获取“语雀”资源文档

   入口YuqueProcessor.java

   “语雀”前端页面较为复杂，数据有多层加密，且主要由Ajax渲染页面数据，这里使用 Selenium+chrome浏览器 爬取动态页面数据。

   由于本地的谷歌浏览器可能会自动升级，相应的驱动也要及时更换。

   驱动地址：http://npm.taobao.org/mirrors/chromedriver/

   当前项目浏览器驱动版本：93.0.4577.63

5. 雅拉伊 美图下载

   入口YalayiPageProcessor.java

   通过遍历gallery，获取目标图片源地址，然后自定义pipe用于图片下载、图片信息持久化到数据库。

   注意：在这里要特别注意WebMagic与Spring的整合，否则资源注入会失败，持久化到数据库时会报空指针异常。

   关键语句：

   ```java
   @Autowired
   private YalayiPipeline yalayiPipeline;
   Spider.create(new YalayiPageProcessor())
                .addUrl(urls.toArray(new String[urls.size()]))
                .addPipeline(yalayiPipeline)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(1000)))
                .thread(10)
                .run();
   ```

6. 亿图全景图库 图片下载

   入口YeituProcessor.java

   该网站采取了防盗链技术，图片无法直接使用源地址下载，需要我们在请求资源时设置相应的请求头。此外，在图片全部下载后，增加了打包的操作。

7. 美图吧 图片下载

   入口Ku137PageProcessor.java

   说明：该网站图片太多，注意自己的存储空间。

项目中的部分业务模块开启了定时任务，可根据自己的需求自行设置启动时间。