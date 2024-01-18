package com.arr.aop.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AspectServiceImpl implements AspectService{

    Logger logger = LoggerFactory.getLogger(AspectServiceImpl.class);

    @Override
    public int add(int x, int y) {
        logger.info(">> AspectServiceImpl.add()");
        return x+y;
    }
}
