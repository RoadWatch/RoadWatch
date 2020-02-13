package com.codeup.demo.services;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnviromentSvc {
//    @Autowired
    private Environment env;

    @Value("${app.token}")
    private String mapboxToken;

    public String getMapboxKey(){
        return mapboxToken;
    }
}
