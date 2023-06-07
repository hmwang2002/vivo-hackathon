# Hackathon Backend

## vivo-hackathon 09-vivo5000 后端项目

### 项目架构

基础设置：java sdk11+mysql8

springboot+mybatis+jdbc+mysql+服务器

数据库：基于阿里云服务器：jdbc:mysql://47.99.63.112:3306/landscape

项目主要结构：

```txt
hackathon_backend 文件夹
    demo文件夹
        src文件夹
            main文件夹
                java.com.example.demo文件夹
                    controller文件夹
                        ScenerySpotController.java 景色实体控制器
                    dao文件夹
                        ScenerySpotDao.java 景色mapper
                    entity文件夹
                        ScenerySpot.java 景色实体接口
                        SimpleSpot.java 简单景色实体接口
                    pojo文件夹
                    service文件夹
                        impl文件夹
                            ScenerySpotServiceImpl.java 景色服务实现
                        ScenerySpotService.java 景色服务 
                    util文件夹
                    DemoApplication.java 项目运行文件
            resources文件夹
                mapper文件夹
                    ScenerySpotDao.xml 与mapper和实体项目映射的sql语句
                static文件夹
                templates文件夹
                application.properties 项目配置
        test文件夹
            java.com.example.demo 文件夹
                ScenerySpotControllerTest.java 景色控制器测试文件
        pom.xml maven构建文件

```

### 项目实现

实现了三个查询数据库的方式

queryById 通过经纬度的方式查询数据库中景点的结果

queryByName 通过景点名称的方式查询数据库中景点的结果

queryNameAndLocation 返回所有景点的简要数据

### 运行方式

pom.xml使用maven方式构建项目并自动添加依赖

选中DemoApplication.java文件 运行该文件 即后端项目部署完成
