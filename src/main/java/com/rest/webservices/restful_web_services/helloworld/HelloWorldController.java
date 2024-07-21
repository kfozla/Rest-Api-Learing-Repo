package com.rest.webservices.restful_web_services.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @RequestMapping(path = "hello-world",method = RequestMethod.GET)
    public String helloWorld(){
        return "hello world";
    }
    @RequestMapping(path = "hello-world-bean",method = RequestMethod.GET)
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
    @RequestMapping(path = "hello-world-bean/path-variable/{name}",method = RequestMethod.GET)
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello World"+ name);
    }
    @RequestMapping(path = "hello-world-internationalized",method = RequestMethod.GET)
    public String helloWorldInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
}
