package com.example.mybatisplusatuo2;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

public class generator {


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("yujie");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.example.mybatisplusatuo2");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
       // strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
       // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}





    //暂时没用到也没懂
    // javadoc
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setActiveRecord(true);//是否支持AR模式？？？？
//        String projectPath = System.getProperty("user.dir");//????
//        gc.setOutputDir(projectPath + "/src/main/java");//
//        gc.setAuthor("jie");
//        gc.setFileOverride(true);//是否进行文件覆盖
//        gc.setIdType(IdType.AUTO);//？？？？主键策略
//        gc.setServiceName("true");//设置service接口首字母是否为I，true是不为I
////        gc.setOpen(false);
//        gc.setBaseResultMap(true);//有这个生成基本的ResultMap
//        gc.setBaseColumnList(true);//生成SQL片段
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);//????
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("root");
////        mpg.setDataSource(dsc);//这是啥？
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
////        pc.setModuleName(scanner("MybatisPlusAtuo"));//?????
//        pc.setParent("com.example.mybatisplusatuo2");//dao,service等前面的一串。
//        pc.setController("controller");
//        pc.setMapper("dao");
//        pc.setEntity("entity");
//        pc.setService("service");
//        pc.setServiceImpl("service.impl");
//        pc.setXml("mapper");
////        mpg.setPackageInfo(pc);//??????
//
//
//
////
////        // 自定义配置
////        InjectionConfig cfg = new InjectionConfig() {
////            @Override
////            public void initMap() {
////                // to do nothing
////
////                //?????
////                Map<String, Object> map = new HashMap<>();
////                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
////                this.setMap(map);
////            }
////        };
////
////        // 如果模板引擎是 freemarker
////        String templatePath = "/templates/mapper.xml.ftl";
////        // 如果模板引擎是 velocity
////        // String templatePath = "/templates/mapper.xml.vm";
////
////        // 自定义输出配置
////        List<FileOutConfig> focList = new ArrayList<>();
////        // 自定义配置会被优先输出
////        focList.add(new FileOutConfig(templatePath) {
////            @Override
////            public String outputFile(TableInfo tableInfo) {
////                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
////                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
////                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
////            }
////        });
////        /*
////        cfg.setFileCreate(new IFileCreate() {
////            @Override
////            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
////                // 判断自定义文件夹是否需要创建
////                checkDir("调用默认方法创建的目录，自定义目录用");
////                if (fileType == FileType.MAPPER) {
////                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
////                    return !new File(filePath).exists();
////                }
////                // 允许生成模板文件
////                return true;
////            }
////        });
////        */
////        cfg.setFileOutConfigList(focList);
////        mpg.setCfg(cfg);
////
////        // 配置模板
////        TemplateConfig templateConfig = new TemplateConfig();
////
////        // 配置自定义输出模板
////        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
////        // templateConfig.setEntity("templates/entity2.java");
////        // templateConfig.setService();
////        // templateConfig.setController();
////
////        templateConfig.setXml(null);
////        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setCapitalMode(true);//全局大写命名
////        strategy.setDbColumnUnderline(true);
// //       strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setRestControllerStyle(true);//?????
//        strategy.setInclude("user"); // 设置要映射的表名
//        strategy.setNaming(NamingStrategy.underline_to_camel);//设置命名规则，允许驼峰命名
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//设置命名规则，允许列驼峰命名
//        strategy.setEntityLombokModel(true); // 自动lombok；
//        strategy.setLogicDeleteFieldName("deleted");//设置逻辑删除的名字
////        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
//        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
////        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//
//
//    }
//}