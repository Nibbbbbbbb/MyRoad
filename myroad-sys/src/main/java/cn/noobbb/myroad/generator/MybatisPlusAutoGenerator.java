package cn.noobbb.myroad.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenbihao
 * @create: 2020/12/30
 * @Description:
 * @History:
 */
public class MybatisPlusAutoGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/myroad-sys/src/main/java");
        globalConfig.setAuthor("chenbihao");
        globalConfig.setOpen(false);
        // 开启覆盖已有文件
        globalConfig.setFileOverride(true);
        // 实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/my_road?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("5233");
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("");
        packageConfig.setParent("cn.noobbb.myroad.generator");
        packageConfig.setEntity("domain");
        packageConfig.setMapper("repository");
        packageConfig.setXml("repository");
        generator.setPackageInfo(packageConfig);

        // 注入自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // 自定义配置会被优先输出
        fileOutConfigList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/myroad-sys/src/main/java/cn/noobbb/myroad/generator/repository/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        generator.setCfg(injectionConfig);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);

        // 逻辑删除字段 全局配置，这边可以不用写
//        strategy.setLogicDeleteFieldName("del_flag");
        // 生成Lombok 和链式
        strategy.setChainModel(true);
        strategy.setEntityLombokModel(true);

        // 基类配置
        strategy.setSuperEntityClass("cn.noobbb.myroad.domain.BaseEntity");
        // 基类字段名
        strategy.setSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time", "del_flag");

        // 自己填充要生成的表名
        strategy.setInclude("sys_user");
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new VelocityTemplateEngine());
        generator.execute();
    }

}
