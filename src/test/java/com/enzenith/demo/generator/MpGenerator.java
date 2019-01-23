package com.enzenith.demo.generator;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class MpGenerator {

    @Test
    public void create() {

        String tableName = "code_test";

        /**
         * 配置：
         * 1.全局配置
         * 2.数据源配置
         * 3.策略配置
         * 4.包名策略配置
         * 5.整合配置
         */

        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                //设置代码生成路径
                .setOutputDir("E:\\generatorcode")
                //设置作者
                .setAuthor("xugb")
                //设置二级缓存的开闭
                .setEnableCache(false)
                //设置数据库id自增
                .setIdType(IdType.AUTO)
                //设置覆盖更新
                .setFileOverride(true)
                //设置去I
                .setServiceName("%sService")
                //设置生产结果映射map
                .setBaseResultMap(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                //设置数据库类型
                .setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=GMT")
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.cj.jdbc.Driver");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                //开启全局大写命名
                .setCapitalMode(true)
                //开启下划线转换
                .setDbColumnUnderline(true)
                //开启驼峰命名
                //开启驼峰命名
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setInclude(tableName);

        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent("com.enzenith.demo")
                .setController("controller")
                .setEntity("entity")
                .setMapper("dao")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();

    }

}