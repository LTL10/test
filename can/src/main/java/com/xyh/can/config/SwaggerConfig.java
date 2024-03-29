package com.xyh.can.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
@Configuration
@EnableSwagger2
/*@EnableWebMvc
@ComponentScan(basePackages = {"com.demo.Controller"})*/
public class SwaggerConfig {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()   // RequestHandlerSelectors 配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.xyh.can.controller")) // 指定要扫描的包
                .paths(PathSelectors.any())
                .build();
    }

    // 配置Swagger信息 = apiInfo
    private ApiInfo apiInfo() {
        Contact contact = new Contact("夕阳红团队","https://www.baidu.com/","3067063725@qq.com");
        return new ApiInfo("夕阳红系统的接口文档",
                "good good study, day day up",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());

    }
}







/*@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.demo.Controller"})
public class SwaggerConfig {
    //创建一个docket容器
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact=new Contact("lpw", "http.**.com", "1193119289@qq.com");

        return new ApiInfoBuilder()
                .title("某某项目的API接口")
                .description("某某项目的API接口的描述")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {
        public void addResourceHandlers(ResourceHandlerRegistry registry){
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath/META-INF/resources/");
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath/META-INF/resources/webjars/");
        }
    }
}*/