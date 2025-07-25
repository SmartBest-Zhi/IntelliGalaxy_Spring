package cn.yczbest.codegenerator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.nio.file.Paths;

@SpringBootApplication
public class CodeGeneratorApplication {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public void codeGenerate() {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("SmartBest_Zhi")
                        .enableSpringdoc()
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/code-generator/src/main/java")
                        .commentDate("yyyy-MM-dd")
                        .disableOpenDir()
                )
                .packageConfig(builder -> builder
                        .parent("cn.yczbest.usercenterserver")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .addTablePrefix("t_")
                )
                // Controller 配置
                .strategyConfig(builder -> builder
                        .controllerBuilder()
                        .enableHyphenStyle()
                        .enableRestStyle()
                )
                // Service 生成配置
                .strategyConfig(builder -> builder
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                )
                // Mapper 生成配置
                .strategyConfig(builder -> builder
                        .mapperBuilder()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .enableMapperAnnotation()
                        .enableFileOverride()
                )
                // Entity 生成配置
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                        .enableRemoveIsPrefix()
                        .enableTableFieldAnnotation()
                        .enableActiveRecord()
                        .versionColumnName("version")
                        .logicDeleteColumnName("deleted")
                        .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                        .idType(IdType.AUTO)
                        .formatFileName("%s")
                        .enableFileOverride()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CodeGeneratorApplication.class, args);
        CodeGeneratorApplication app = context.getBean(CodeGeneratorApplication.class);
        app.codeGenerate();
    }

}
