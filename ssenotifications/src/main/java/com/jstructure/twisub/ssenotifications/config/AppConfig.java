package com.jstructure.twisub.ssenotifications.config;

import com.jstructure.twisub.ssenotifications.SsenotificationsApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import redis.clients.jedis.Jedis;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@RequiredArgsConstructor
@EnableSwagger2
@EnableConfigurationProperties(AppRedisConfigProperties.class)
public class AppConfig {

    private static final String CHARACTER_ENCODING = "UTF-8";

    private final AppRedisConfigProperties redisProps;

    private final ApplicationContext applicationContext;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SsenotificationsApplication.class.getPackage().getName()))
                .paths(any())
                .build();
    }

    @Bean
    public Jedis redisTemplate() {
        Jedis redisTemplate = new Jedis(redisProps.getHost(), redisProps.getPort());
        redisTemplate.auth(redisProps.getPassword());
        return redisTemplate;
    }

    @Bean
    public ViewResolver javascriptViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setContentType("application/javascript");
        resolver.setCharacterEncoding(CHARACTER_ENCODING);
        resolver.setViewNames(new String[] { "*.js" });
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setMessageSource(messageSource());
        engine.addTemplateResolver(javascriptTemplateResolver());
        return engine;
    }

    public ITemplateResolver javascriptTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setOrder(1);
        resolver.setCheckExistence(true);
        resolver.setPrefix("classpath:/static/js/");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
        msgSource.setAlwaysUseMessageFormat(false);
        msgSource.setBasename("messages");
        msgSource.setDefaultEncoding(CHARACTER_ENCODING);
        msgSource.setFallbackToSystemLocale(true);
        msgSource.setUseCodeAsDefaultMessage(false);
        return msgSource;
    }

}
