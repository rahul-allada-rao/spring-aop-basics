package com.arr.aop.rest;

import com.arr.aop.aspect.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
