package com.arr.aop.rest;

import com.arr.aop.aspect.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AspectController {

    private AspectService aspectService;

    @Autowired
    public AspectController(AspectService aspectService) {
        this.aspectService = aspectService;
    }

    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> add(){
        int result = aspectService.add(10, 20);
        ResponseEntity<Integer> responseEntity = ResponseEntity.ok(result);
        return responseEntity;
    }

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/beans")
    @ResponseStatus(value = HttpStatus.OK)
    public String[] registeredBeans() {
        return printBeans();
    }

    private String[] printBeans() {
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if (autowireCapableBeanFactory instanceof SingletonBeanRegistry) {
            String[] singletonNames = ((SingletonBeanRegistry) autowireCapableBeanFactory).getSingletonNames();
            for (String singleton : singletonNames) {
                System.out.println(singleton);
            }
            return singletonNames;
        }
        return null;
    }
}
