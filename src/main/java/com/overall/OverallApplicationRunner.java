package com.overall;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OverallApplicationRunner implements ApplicationRunner {

    public final Map<String,String> cacheMap = new HashMap<>();


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
